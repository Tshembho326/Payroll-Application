package com.payroll.startup.Models;


import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table
@Builder
public class Address {
    @Id
    @GeneratedValue
    private Integer id;

    private String city;
    private Integer postalCode;
    private String country;
    private String street;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Address() {
    }

    public Address(Integer id, String city, Integer postalCode, String country, String street, Employee employee) {
        this.id = id;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.street = street;
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
