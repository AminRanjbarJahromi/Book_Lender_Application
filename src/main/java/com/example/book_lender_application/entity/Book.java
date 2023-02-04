package com.example.book_lender_application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "Book_Author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();

    public Book(String isbn, String title, int maxLoanDate) {
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDate = maxLoanDate;
    }
}
