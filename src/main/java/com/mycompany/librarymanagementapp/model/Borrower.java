/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementapp.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author ddd
 */

@Entity
@Table(name = "borrowers")
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer borrowerId;

    @Column(name = "borrower_type", nullable = false)
    private String borrowerType;  // "student" hoac "teacher"
    
    @OneToOne(mappedBy = "borrower", cascade = CascadeType.ALL)
    private Student student;
    
    @OneToOne(mappedBy = "borrower", cascade = CascadeType.ALL)
    private Teacher teacher;
    
    @OneToMany(mappedBy = "borrower", cascade = CascadeType.ALL)
    private List<BorrowRecord> borrowRecords;

    @ManyToOne
    @JoinColumn(name = "borrower_rule_id")
    private BorrowerRule borrowerRule;
    
//    @Column(name = "borrowing_book_quantity", nullable = false)
//    private Integer borrowingBookQuantity;
    
    public Borrower() {
    }

    public Borrower(String borrowerType, Student student, BorrowerRule borrowerRule) {
        this.borrowerType = borrowerType;
        this.student = student;
        this.teacher = null;
        this.borrowerRule = borrowerRule;
//        this.borrowingBookQuantity = borrowingBookQuantity;
    }

    public Borrower(String borrowerType, Teacher teacher, BorrowerRule borrowerRule) {
        this.borrowerType = borrowerType;
        this.teacher = teacher;
        this.student = null;
        this.borrowerRule = borrowerRule;
//        this.borrowingBookQuantity = borrowingBookQuantity;
    }

    public Integer getBorrowerId() {
        return borrowerId;
    }
    
    public String getBorrowerType() {
        return borrowerType;
    }

    public void setBorrowerType(String borrowerType) {
        this.borrowerType = borrowerType;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<BorrowRecord> getBorrowRecords() {
        return borrowRecords;
    }

    public void setBorrowRecords(List<BorrowRecord> borrowRecords) {
        this.borrowRecords = borrowRecords;
    }
    
    public boolean isTeacher() {
        if (teacher != null) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        if (isTeacher()) {
            return "Kiểu người mượn: " + borrowerType + "\n" +
                    teacher + "\n" + borrowerRule;
        } else {
            return "Kiểu người mượn: " + borrowerType + "\n" +
                    student + "\n" + borrowerRule;
        }
    }
    
    
}
