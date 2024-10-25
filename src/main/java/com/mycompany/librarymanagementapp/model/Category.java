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
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    
    @Column(name = "category_name")
    private String categoryName;
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Book> books;
    
    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }
    
    public String getCategory() {
        return categoryName;
    }

    public void setCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Thể loại: " + categoryName;
    }
    
}
