package com.example.book_lender_application.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;


import java.util.Objects;


@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false)
    private String userName;
    @Column(nullable = false)
    private String passWord;
    @CreationTimestamp
    private LocalDate regDate;

    public AppUser(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    /*public AppUser() {
        this.regDate = LocalDate.now();
    }

     */
}
