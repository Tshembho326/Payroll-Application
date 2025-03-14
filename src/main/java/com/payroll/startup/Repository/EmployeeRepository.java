package com.payroll.startup.Repository;

import com.payroll.startup.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
