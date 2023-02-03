package com.example.book_lender_application.repository;

import com.example.book_lender_application.entity.AppUser;
import com.example.book_lender_application.entity.Details;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest

public class AppRepositoyTest {

    @Autowired
    AppUserRepository testObject;

    AppUser creatAppUser;
    @BeforeEach
     public  void  setup(){

        Details detailsDate = new Details("Amin@gmail.com","Amin Ranjbar",LocalDate.parse("2020-02-02"));
        AppUser appUserDate = new AppUser("Amin", "AminAmin" ,detailsDate );
        creatAppUser = testObject.save(appUserDate);
       assertNotNull(creatAppUser);

     }

     @Test
    public void test_findById() {

        Optional<AppUser> appUserOptional = testObject.findById(creatAppUser.getId());
        assertTrue(appUserOptional.isPresent());
        AppUser actualData = appUserOptional.get();
        AppUser expectData = creatAppUser;
        assertEquals(expectData , actualData);

    }

    @Test
    public void test_findByUsername() {

        Optional<AppUser> appUserOptional = testObject.findByUsername(creatAppUser.getUsername());
        assertTrue(appUserOptional.isPresent());
        AppUser actualData = appUserOptional.get();
        AppUser expectData = creatAppUser;
        assertEquals(expectData, actualData);

    }
}



