/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementapp.model;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author ddd
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "full_name", nullable = false)
    private String fullName;
    
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    
    @Column(name = "address")
    private String address;

    public Person() {
    }

    public Person(String fullName, Date dob, String address) {
        this.fullName = fullName;
        this.dob = dob;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public Date getDob() {
        return dob;
    }

    public String getFullName() {
        return fullName;
    }

    public int getId() {
        return id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
            return "Person{" +
            ", fullName='" + fullName + '\'' +
            ", dob=" + dob +
            ", address='" + address + '\'' +
            '}';
    }
    
}
