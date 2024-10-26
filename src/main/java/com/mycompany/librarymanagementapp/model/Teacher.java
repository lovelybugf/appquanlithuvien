/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementapp.model;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author ddd
 */

@Entity
@Table(name = "teachers")
public class Teacher extends Person {
    @Column(name = "teacher_code", nullable = false)
    private String teacherCode;
    
    @Column(name = "department", nullable = false)
    private String department;
    
    @OneToOne
    @JoinColumn(name = "borrower_id")
    private Borrower borrower;

    public Teacher() {
    }

    public Teacher(String teacherCode, String department) {
        this.teacherCode = teacherCode;
        this.department = department;
    }

    public Teacher(String teacherCode, String department, int id, String fullName, Date dob, String address) {
        super(fullName, dob, address);
        this.teacherCode = teacherCode;
        this.department = department;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }        
    
    @Override
    public String toString() {
        return "Họ tên: " + this.getFullName() + "\n" + 
                "Mã giảng viên: " + teacherCode + "\n" + 
                "Khoa: " + department;
    }
  
}
