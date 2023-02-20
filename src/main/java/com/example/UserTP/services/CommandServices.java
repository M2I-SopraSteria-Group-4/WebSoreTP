package com.example.UserTP.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserTP.entity.*;
import com.example.UserTP.repository.*;

@Service
public class CommandServices {

    @Autowired
    CommandRepository cRepo;

    @Autowired
    CommandLineRepository clRepo;

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

    public void updateCommand(Command c, int id){
        Command command = cRepo.findById(id).orElse(null);
        if(command!=null){
            command.setCommandDate(c.getCommandDate());
            command.setUser(c.getUser());
            command.setCommandLine(c.getCommandLine());
            command.setPayment(c.getPayment());
            cRepo.save(command);
        }
    }

    public List<CommandLine> getAllCL(){
        return clRepo.findAll();
    }

    public CommandLine getOneCL(int id){

        return clRepo.findById(id).orElse(null);
    }

    public void createCL(CommandLine cl){
        clRepo.save(cl);
    }

    public void deleteCL(int id){
        CommandLine cl = clRepo.findById(id).orElse(null);
        if(cl!=null) clRepo.delete(cl);
    }

    public void updateCL(CommandLine cl, int id){
        CommandLine cLine = clRepo.findById(id).orElse(null);
        if(cLine != null) {
            cLine.setCommand(cl.getCommand());
            cLine.setArticle(cl.getArticle());
            cLine.setQuantity(cl.getQuantity());

            clRepo.save(cLine);
        }
    }

}