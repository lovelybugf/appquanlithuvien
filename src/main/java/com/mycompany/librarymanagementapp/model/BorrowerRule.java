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
@Table(name = "borrower_rule")
public class BorrowerRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer borrowerRuleId;

    @Column(name = "borrower_type", nullable = false)
    private String borrowerType;

    @Column(name = "max_books", nullable = false)
    private int maxBooks;

    @Column(name = "borrow_duration", nullable = false)
    private int borrowDuration;  // so ngay muon toi da

    @Column(name = "fine_per_day", nullable = false)
    private int finePerDay;
    
    @OneToMany(mappedBy = "borrowerRule", cascade = CascadeType.ALL)
    private List<Borrower> borrowers;

    public BorrowerRule() {
    }

    public BorrowerRule(String borrowerType, int maxBooks, int borrowDuration, int finePerDay) {
        this.borrowerType = borrowerType;
        this.maxBooks = maxBooks;
        this.borrowDuration = borrowDuration;
        this.finePerDay = finePerDay;
    }

    public Integer getId() {
        return borrowerRuleId;
    }

    public String getBorrowerType() {
        return borrowerType;
    }

    public void setBorrowerType(String borrowerType) {
        this.borrowerType = borrowerType;
    }

    public int getMaxBooks() {
        return maxBooks;
    }

    public void setMaxBooks(int maxBooks) {
        this.maxBooks = maxBooks;
    }

    public int getBorrowDuration() {
        return borrowDuration;
    }

    public void setBorrowDuration(int borrowDuration) {
        this.borrowDuration = borrowDuration;
    }

    public int getFinePerDay() {
        return finePerDay;
    }

    public void setFinePerDay(int finePerDay) {
        this.finePerDay = finePerDay;
    }

    @Override
    public String toString() {
        return "Số lượng mượn tối đa: " + maxBooks +
                "\nThời gian mượn: " + borrowDuration +
                "\nPhạt trả muộn mỗi ngày: " + finePerDay;
    }
   
}
