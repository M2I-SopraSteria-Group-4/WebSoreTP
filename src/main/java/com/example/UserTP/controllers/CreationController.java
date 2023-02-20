package com.example.UserTP.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.UserTP.entity.*;
import com.example.UserTP.services.*;

@RestController
@RequestMapping("/create")
public class CreationController {



    @Autowired
    UserServices uService;

    @Autowired
    CommandServices cService;

    @Autowired
    PaymentServices pService;
    @Autowired
    FakeServices fService;

    public User user;

    @GetMapping
	  public User fakeUser(){
        fService.creatFakeUser();
        fService.addRole();
        fService.addInfo();
        fService.addCommand();
        fService.addCOmmandLine();
        fService.addPayment();
        return user;

    }
}
