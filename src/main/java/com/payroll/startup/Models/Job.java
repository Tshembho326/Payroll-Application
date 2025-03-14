package com.payroll.startup.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Builder;

import java.util.List;

@Entity
@Table
@Builder
public class Job {

    @Id
    @GeneratedValue
    private Integer id;

    private List<Position> positions;

    public Job() {
    }

    public Job(Integer id, List<Position> positions) {
        this.id = id;
        this.positions = positions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }
}
