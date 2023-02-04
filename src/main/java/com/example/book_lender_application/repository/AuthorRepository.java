package com.example.book_lender_application.repository;

import com.example.book_lender_application.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {

    List<Author> findAllByWrittenBookId (int bookId);


}
