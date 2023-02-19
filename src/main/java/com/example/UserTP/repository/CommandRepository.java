package com.example.UserTP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UserTP.entity.Command;

public interface CommandRepository extends JpaRepository<Command, Integer> {

}
