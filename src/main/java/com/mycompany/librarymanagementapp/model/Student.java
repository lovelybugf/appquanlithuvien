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
@Table(name = "students")
public class Student extends Person {
    @Column(name = "student_code", nullable = false)
    private String studentCode;
    
    @Column(name = "student_class", nullable = false)
    private String studentClass;
    
    @OneToOne
    @JoinColumn(name = "borrowe_id")
    private Borrower borrower;
    
    public Student() {
        
    }

    public Student(String studentCode, String studentClass) {
        this.studentCode = studentCode;
        this.studentClass = studentClass;
    }

    public Student(String studentCode, String studentClass, int id, String fullName, Date dob, String address) {
        super(fullName, dob, address);
        this.studentCode = studentCode;
        this.studentClass = studentClass;
    }
    
    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    @Override
    public String toString() {
        return "Họ tên: " + this.getFullName() + "\n" +
                "MSV: " + studentCode + "\n" +
                "Lớp: " + studentClass + "\n";
    }
    
    
}
