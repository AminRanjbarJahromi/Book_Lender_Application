package com.example.book_lender_application.repository;

import com.example.book_lender_application.entity.Details;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DetailsRepository extends CrudRepository <Details, Integer> {

    @Query("select d from Details d where d.email = :el")
    Optional<Details> findByEmailIgnoreCase (@Param("el") String email);

    List<Details> findAllByNameContains (String name);

    List<Details> findAllByNameIgnoreCaseAndBirthDate (String name, LocalDate localDate);



}

