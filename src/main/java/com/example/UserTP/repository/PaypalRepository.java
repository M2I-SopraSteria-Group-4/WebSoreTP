package com.example.UserTP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UserTP.entity.Paypal;

public interface PaypalRepository extends JpaRepository<Paypal, Integer> {


}
