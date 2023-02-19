package com.example.UserTP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UserTP.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {


}
