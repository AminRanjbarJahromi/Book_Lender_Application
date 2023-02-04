package com.example.book_lender_application.repository;

import com.example.book_lender_application.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BookRepository extends CrudRepository<Book , Integer> {

    List<Book> findAllByIsbn(String isbn);

    List<Book> findAllByTitleContains(String title);

    List<Book> findAllByTitleContainsIgnoreCase (String title);




}
