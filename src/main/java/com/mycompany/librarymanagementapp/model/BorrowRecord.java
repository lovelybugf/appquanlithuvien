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
@Table(name = "borrow_records")
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer borrowRecordId;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
      
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;   
    
    @ManyToOne
    @JoinColumn(name = "borrower_id")
    private Borrower borrower;
    
    @Temporal(TemporalType.DATE)
    private Date borrowDate;

    @Temporal(TemporalType.DATE)
    private Date returnDate; 
    
    @Column(name = "fine", nullable = false)
    private int fine;
    
    @Column(name = "status", nullable = false)
    private int status;
    
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    public BorrowRecord() {
    }

    public BorrowRecord(User user, Book book, Borrower borrower, Date borrowDate, Date dueDate) {
        this.user = user;
        this.book = book;
        this.borrower = borrower;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.fine = 0;
        this.status = 0;
    }

    public Integer getBorrowRecordId() {
        return borrowRecordId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

       
}
