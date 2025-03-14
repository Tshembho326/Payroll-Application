package com.payroll.startup.Controllers;

import com.payroll.startup.Models.Address;
import com.payroll.startup.Models.Contact;
import com.payroll.startup.Models.Employee;
import com.payroll.startup.Models.Position;
import com.payroll.startup.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("{employee_id}")
    public Employee getEmployee(@PathVariable("employee_id") Integer employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping
    public void addEmployee(
            @RequestBody Employee employee
    ) {
        employeeService.addEmployee(employee);
    }

    @DeleteMapping("{employee_id}")
    public void deleteEmployee(
            @PathVariable("employee_id") Integer employeeId
    ) {
        employeeService.deleteEmployee(employeeId);
    }

    @PutMapping("{employee_id}")
    public void updateEmployee(
            @PathVariable("employee_id") Integer employeeId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Address address,
            @RequestParam(required = false) Position position,
            @RequestParam(required = false) Contact contact

            ) {
        employeeService.updateEmployee(employeeId, firstName, lastName, email, address, position, contact);
    }
}
