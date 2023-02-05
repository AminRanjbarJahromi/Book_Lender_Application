package com.example.book_lender_application.entity;

import com.example.book_lender_application.Exception.DataDuplicateException;
import com.example.book_lender_application.Exception.DataNotFoundException;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;


import java.util.ArrayList;
import java.util.List;
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


    @OneToMany(mappedBy = "borrower",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<BookLoan> bookLoans = new ArrayList<>();

    public AppUser(String userName, String passWord,Details details) {
        this.username =  userName;
        this.passWord = passWord;
        this.details = details;
    }

    /*public AppUser() {
        this.regDate = LocalDate.now();
    }

     */

    /*public boolean addBookLoan (BookLoan bookLoan){
        if(bookLoans.contains(bookLoan)){
            return false;
        }
        bookLoans.add(bookLoan);
        bookLoan.setBorrower(this);
        return true;
    }

    public boolean removeBookLoan(BookLoan bookLoan){
        if(!bookLoans.contains(bookLoan)){
            return false;
        }
        bookLoans.remove(bookLoan);
        bookLoan.setBorrower(this);
        return true;

    }*/



    public void addBookLoan (BookLoan bookLoan){
        if(bookLoans.contains(bookLoan)){
            throw new DataDuplicateException("Book is loaned");
        }
        bookLoans.add(bookLoan);
        bookLoan.setBorrower(this);

    }

    public void removeBookLoan(BookLoan bookLoan){
        if(!bookLoans.contains(bookLoan)){
            throw new DataNotFoundException("book is not loaned");
        }
        bookLoans.remove(bookLoan);
        bookLoan.setBorrower(this);

    }
}
