package com.example.UserTP.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.UserTP.entity.*;
import com.example.UserTP.services.*;

@RestController
@RequestMapping("/faker")
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

    @GetMapping("/create")
	  public User fakeUser(){
        fService.creatFakeUser();
        fService.addRole();
        fService.addInfo();
        fService.addCommand();
        fService.addCOmmandLine();
        // fService.addPayment();
        return user;
    }

    // @GetMapping("/delete/{id}")
    // public void deleteAll(@PathVariable("id") int user_id){
    //     User u = uService.getOneUser(user_id);
    //     System.out.println(u.getLogin());
    //     List<Command> c = u.getCommand();
    //     for(Command command : c){
    //         CommandLine cl = command.getAllCL();
    //         System.out.println(command.getId());
    //         cService.deleteCommand(command.getId());
    //     }
    //     CommandLine cl = c.getAllCL();
    //     for(CommandLine commandLine : cl){
    //         System.out.println(commandLine.getId());
    //         cService.deleteCL(commandLine.getId());
    //     }

    //     // uService.deleteUser(user_id);
    //     // uService.deleteRole(user_id);
    //     // uService.deleteInfo(user_id);
    //     // cService.deleteCommand(user_id);
    // }
}
