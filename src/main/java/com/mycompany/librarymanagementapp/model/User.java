/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementapp.model;

import java.util.List;
import javax.persistence.*;
/**
 *
 * @author ddd
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    
    @Column(name = "username", nullable = false)
    private String username;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "role", nullable = false)
    private String role;
    
    @OneToOne
    @JoinColumn(name = "student_id", unique = true)
    private Student student;
    
    @OneToOne
    @JoinColumn(name = "teacher_id", unique = true)
    private Teacher teacher;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BorrowRecord> BorrowRecords;

    public User() {
    }

    public User(String username, String password, String role, Student student) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.student = student;
        this.teacher = null;
    }

    public User(String username, String password, String role, Teacher teacher) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.student = null;
        this.teacher = teacher;
    }

    public Integer getUserId() {
        return userId;
    }
  
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        return BorrowRecords;
    }

    public void setBorrowRecords(List<BorrowRecord> BorrowRecords) {
        this.BorrowRecords = BorrowRecords;
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
            return "username: " + username +
                    "\nHọ tên: " + teacher.getFullName() + 
                    "\nrole: " + role;
        } else {
            return "username: " + username +
                    "\nHọ tên: " + student.getFullName() + 
                    "\nrole: " + role;
        }
    }
}
