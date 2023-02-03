package com.example.book_lender_application.repository;

import com.example.book_lender_application.entity.AppUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser,Integer> {

    Optional<AppUser> findByUsername (String username);

    @Query("select a from AppUser a where a.username = : un")
    Optional<AppUser> selectByUsername (@Param("un") String username);

    //select * from appUser where regDate between 1? and 2?

    List<AppUser> findAllByRegDateBetween(LocalDate from, LocalDate to);

    @Query("select a from AppUser a where a.regDate >= : from and a.regDate <= : to")
    List<AppUser> selectByRegistrationDate(@Param("from")LocalDate from,@Param("to") LocalDate to);

    // I am going to update password
    @Modifying
    @Query("update AppUser a set a.passWord = : pwd where a.username = : un")
    void resetPassword( @Param("un") String username ,@Param("pwd") String password);


}
