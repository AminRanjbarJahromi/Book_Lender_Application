package com.example.book_lender_application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@Column(unique = true,nullable = false)
    private String isbn;
    //@Column(nullable = false)
    private String title;
    //@Column(nullable = false)
    private int maxLoanDate;

    public Book(String isbn, String title, int maxLoanDate) {
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDate = maxLoanDate;
    }
}
