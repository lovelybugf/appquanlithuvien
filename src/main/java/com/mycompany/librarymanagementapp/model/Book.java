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
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    
//    @Column(name = "book_code", nullable = false)
//    private String bookCode;
    
    @Column(name = "title", nullable = false)
    private String title;
    
    @Column(name = "author", nullable = false)
    private String author;
    
    @Column(name = "year_published", nullable = false)
    private Integer yearPublished;
    
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    
    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;
    
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BorrowRecord> borrowRecords;
    
    
    public Book() {
    }

    public Book(String title, String author, Integer yearPublished, Integer quantity, Category category, Publisher publisher) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.quantity = quantity;
        this.category = category;
        this.publisher = publisher;
    }

//    public String getBookCode() {
//        return bookCode;
//    }
//
//    public void setBookCode(String bookCode) {
//        this.bookCode = bookCode;
//    }

    public Integer getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }


    @Override
    public String toString() {
        return "\nTên sách: " + title + 
                "\nTác giả: " + author + "\n" +
                category + "\n" +
                publisher +
                "\nNăm xuất bản: " + yearPublished + 
                "\nSố lượng: " + quantity;
    }
    
    
    
}
