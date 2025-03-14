package com.payroll.startup.Models;

import jakarta.persistence.*;
import lombok.Builder;

@Builder
@Entity
@Table
public class Position {
    @Id
    @GeneratedValue
    private Integer id;
    private String positionCode;
    private String status;

    @OneToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;


    public Position() {
    }

    public Position(Integer id, String positionCode, String status, Employee employee, Job job) {
        this.id = id;
        this.positionCode = positionCode;
        this.status = status;
        this.employee = employee;
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
