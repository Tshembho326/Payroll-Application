package com.payroll.startup.Repository;

import com.payroll.startup.Models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {
}
