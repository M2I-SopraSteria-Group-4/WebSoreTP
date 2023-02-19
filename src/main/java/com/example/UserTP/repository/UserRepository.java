package com.example.UserTP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UserTP.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

}
