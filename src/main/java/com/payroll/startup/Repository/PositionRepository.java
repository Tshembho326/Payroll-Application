package com.payroll.startup.Repository;

import com.payroll.startup.Models.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}

