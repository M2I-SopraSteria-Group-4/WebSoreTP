package com.example.UserTP.controllers;
import java.util.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.example.UserTP.entity.*;
import com.example.UserTP.services.*;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Controller;


@RestController
@RequestMapping("/command")
public class CommandController {

    @Autowired
    UserServices uService;

    @Autowired
    CommandServices cService;

    @Autowired
    PaymentServices pService;

    @GetMapping("/{id}")
    public Command getCommand(@PathVariable int id){
        return cService.getOneCommand(id);
    }

    @GetMapping("/all")
    public List<Command> getAllCommands(){
        return cService.getAllCommands();
    }

    @GetMapping("/user/{id}")
    public List<Command> getCommandsByUser(@PathVariable int id){
        return cService.getByUser(id);
    }

    @GetMapping("/user/{id}/payment")
    public Payment getPaymentsByUser(@PathVariable int id){
        return pService.getByUser(id);
    }



   


    


    
    
}
