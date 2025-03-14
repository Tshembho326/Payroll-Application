package com.payroll.startup.Repository;

import com.payroll.startup.Models.Identity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentityRepository extends JpaRepository<Identity, Integer> {
}
