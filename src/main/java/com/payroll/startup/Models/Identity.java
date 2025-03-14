package com.payroll.startup.Models;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table
@Builder
public class Identity {
    @Id
    @GeneratedValue
    private Integer id;

    private String idType;

    @Column(unique = true)
    private String idValue;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Identity() {
    }

    public Identity(Integer id, String idType, String idValue) {
        this.id = id;
        this.idType = idType;
        this.idValue = idValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdValue() {
        return idValue;
    }

    public void setIdValue(String idValue) {
        this.idValue = idValue;
    }
}
