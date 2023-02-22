package com.example.UserTP.services;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserTP.entity.*;
import com.github.javafaker.Faker;

@Service
public class FakeServices {

    @Autowired
    UserServices uService;
    @Autowired
    CommandServices cService;
    @Autowired
    PaymentServices pService;

    public User user;
    public Command command;
    public Faker faker = new Faker();

    public User creatFakeUser(){
        String login = faker.name().username();
        String password = faker.internet().password();
        int connectionNumber = faker.number().numberBetween(0, 100000);
        user = new User(login, password, connectionNumber);
        uService.createUser(user);
        return user;
    }

    public User addRole(){
        List<User> users = new ArrayList<>(); 
        users.add(user);

        
        Role role = uService.getRandomRole();
        if (role == null) {
            role = new Role("User",users);
            } else {
            role.setUser(users);
        }
        
        uService.createRole(role);
        return user;
    }


    public User addInfo(){
        String adress = faker.address().streetAddressNumber();
	    String city = faker.address().city();
	    String email = faker.internet().emailAddress();
	    String phoneNumber = faker.phoneNumber().cellPhone();
        Info info = new Info(adress, city,email, phoneNumber, user);
        
        uService.createInfo(info);
        return user;
    }

    public User addCommand(){
        Date dateCommand = faker.date().birthday(1, 6);

        command = new Command(dateCommand,user);

        cService.createCommand(command);
        return user;
    }

    public User addCOmmandLine(){
        Article article = cService.getRandomArticle();
        double itemPrice = article.getPrice();

        System.out.println("=========================================");
        System.out.println(article.getBrand()+ " " +article.getPrice()); 
        System.out.println("=========================================");
        

        int quantity = faker.number().randomDigitNotZero();
        System.out.println("=========================================");
        System.out.println("quantity : " + quantity); 
        System.out.println("=========================================");

        CommandLine cLine = new CommandLine(quantity, command, article);     
         

        cService.createCL(cLine);

        String accountNumber = faker.finance().iban();
        double amount = quantity*(double) itemPrice;
        System.out.println("=========================================");
        System.out.println("amount : " + amount); 
        System.out.println("=========================================");
        Date paymentDate = faker.date().birthday(1, 6);


        Paypal paypal = new Paypal( accountNumber, amount,  paymentDate, command);
        pService.createPaypal(paypal);
        return user;
    }

    // public User addPayment(){

        
    //     return user;
    // }

}

