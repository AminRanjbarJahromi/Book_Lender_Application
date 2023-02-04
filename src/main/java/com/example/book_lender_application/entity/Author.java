package com.example.book_lender_application.entity;

import lombok.*;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity


public class Author {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String Name;

        private String lastName;

        @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
        @JoinTable(name = "Book_Author",
                joinColumns = @JoinColumn(name = "author_id"),
                inverseJoinColumns = @JoinColumn(name = "book_id")
        )
        private List<Book> writtenBook = new ArrayList<>();
}
