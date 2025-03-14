package com.payroll.startup.Models;


import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table
@Builder
public class Contact {
    @Id
    @GeneratedValue
    private Integer id;

    private String phoneNumber;

    @Column(unique = true)
    private String email;

    private String homeNumber;

    public Contact() {
    }

    public Contact(Integer id, String phoneNumber, String email, String homeNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.homeNumber = homeNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }
}
