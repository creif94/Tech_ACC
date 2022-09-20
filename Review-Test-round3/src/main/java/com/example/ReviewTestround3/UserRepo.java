package com.example.ReviewTestround3;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    //Custom Query to find the Users by their email address
    User findByEmail(String email);


}
