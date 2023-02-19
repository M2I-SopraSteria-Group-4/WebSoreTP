package com.example.UserTP.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserTP.entity.User;
import com.example.UserTP.entity.Command;
import com.example.UserTP.repository.UserRepository;
import com.example.UserTP.repository.CommandRepository;

@Service
public class CommandServices {

    @Autowired
    CommandRepository cRepo;

    @Autowired
	UserRepository uRepo;

    public List<Command> getAllCommands(){
        return cRepo.findAll();
    }

    public List<Command> getByUser(int user_id){
        User u = uRepo.findById(user_id).orElse(null);
        return u.getCommand();
    }

    public Command getOneCommand(int id){
        return cRepo.findById(id).orElse(null);
    }

    public void createCommand(Command c){
        cRepo.save(c);
    }

    public void deleteCommand(int id){
        Command c = cRepo.findById(id).orElse(null);
        if(c!=null) cRepo.delete(c);
    }

}