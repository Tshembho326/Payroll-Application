package com.payroll.startup.Services;

import com.payroll.startup.Models.Address;
import com.payroll.startup.Models.Contact;
import com.payroll.startup.Models.Employee;
import com.payroll.startup.Models.Position;
import com.payroll.startup.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(Integer employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(
                () -> new IllegalArgumentException("Employee doesn't exist")
        );
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer employeeId) {
        boolean validation = employeeRepository.existsById(employeeId);
        if (!validation) throw new IllegalArgumentException("Employee doesn't exist.");
        employeeRepository.deleteById(employeeId);
    }

    public void updateEmployee(Integer employeeId, String firstName, String lastName, String email, Address address, Position position, Contact contact) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new IllegalArgumentException("Employee doesn't exist")
        );

        if (firstName != null) employee.setFirstName(firstName);
        if (lastName != null) employee.setLastName(lastName);
        if (email != null) employee.setEmail(email);
        if (position != null) employee.setPosition(position);
        if (contact != null) employee.setContact(contact);
        if (address != null) employee.setAddress(address);

        employeeRepository.save(employee);
    }
}
