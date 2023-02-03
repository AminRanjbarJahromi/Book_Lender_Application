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
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String passWord;
    @CreationTimestamp
    private LocalDate regDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private Details details;

    public AppUser(String userName, String passWord,Details details) {
        this.username =  userName;
        this.passWord = passWord;
        this.details = details;
    }

    /*public AppUser() {
        this.regDate = LocalDate.now();
    }

     */
}
