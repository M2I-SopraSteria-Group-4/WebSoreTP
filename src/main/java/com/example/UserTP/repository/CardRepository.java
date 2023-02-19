package com.example.UserTP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UserTP.entity.CardPayment;

public interface CardRepository extends JpaRepository<CardPayment, Integer> {


}
