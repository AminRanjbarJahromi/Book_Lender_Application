package com.example.book_lender_application.repository;

import com.example.book_lender_application.entity.Book;
import com.example.book_lender_application.entity.BookLoan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookLoanRepository extends CrudRepository<BookLoan, Integer> {




}
