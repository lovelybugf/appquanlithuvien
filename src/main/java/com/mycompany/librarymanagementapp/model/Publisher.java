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
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publisherId;
    
    @Column(name = "publisher", nullable = false)
    private String publisherName;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private List<Book> books;
    
    public Publisher() {
    }

    public Publisher(String publisherName) {
        this.publisherName = publisherName;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Nhà xuất bản: "  + publisherName;
    }
    
}
