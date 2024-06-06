package com.tobeto.java4a.hotelnow.repositories;

import com.tobeto.java4a.hotelnow.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u INNER JOIN Customer c on u.id = c.id WHERE u.id = :id")
    List<User>findByCustomerId(Long id);

    Optional<User> findByEmailIgnoreCase (String email);
}
