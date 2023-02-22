package com.example.UserTP.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.UserTP.entity.*;
import com.example.UserTP.services.*;
import com.github.javafaker.Faker;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServices uService;

    @Autowired
    CommandServices cService;

    @Autowired
    PaymentServices pService;

    

    @GetMapping("/fakeUser")
    public User fakeUserOnly() {
        Faker faker = new Faker();
        String login = faker.name().username();
        String password = faker.internet().password();
        int connectionNumber = faker.number().numberBetween(0, 100000);

        User user = new User(login, password, connectionNumber);        
    
        uService.createUser(user);
    
        return user;
    }

    @GetMapping("/fakeInfo")
    public Info fakeInfo() {

        Faker faker = new Faker();
        String adress = faker.address().streetAddressNumber();
	    String city = faker.address().city();
	    String email = faker.internet().emailAddress();
	    String phoneNumber = faker.phoneNumber().cellPhone();

        User user = uService.getRandomUser();

        Info info = new Info(adress, city,email, phoneNumber,user);

        return info;

    }

    @GetMapping
    public List<User> getAll(){
        return uService.getAllUsers();
    }

    

    @GetMapping("/{id}")
    public User getOne(@PathVariable("id") int id){
        return uService.getOneUser(id);
    }


    @PostMapping
    public void create(@RequestBody User u){
        uService.createUser(u);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody User u, @PathVariable("id") int id){
        uService.updateUser(id, u);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        uService.deleteUser(id);
    }


    @GetMapping("/role")
    public List<Role> getAllRole(){
        return uService.getAllRole();
    }

    @GetMapping("role/{id}")
    public Role getOneRole(@PathVariable("id") int id){
        return uService.getOneRole(id);
    }

    @GetMapping("/userrole/{id}")
    public List<Role> getUserRole(@PathVariable("id") int id){
        return uService.getUserRole(id);
    }

    @DeleteMapping("info/{id}")
    public void deleteInfo(@PathVariable("id") int id){
        uService.deleteInfo(id);
    }

    @GetMapping("/info")
    public List<Info> getAllInfo(){
        return uService.getAllInfo();
    }

   
        

    
}
