package com.payroll.startup.Repository;

import com.payroll.startup.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
