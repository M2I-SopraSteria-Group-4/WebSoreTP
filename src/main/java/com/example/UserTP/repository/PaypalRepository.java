package com.example.UserTP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UserTP.entity.PaypalPayment;

public interface PaypalRepository extends JpaRepository<PaypalPayment, Integer> {


}
