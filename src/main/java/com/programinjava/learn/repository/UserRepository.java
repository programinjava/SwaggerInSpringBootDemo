package com.programinjava.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programinjava.learn.dto.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
