package com.example.UserTP.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.UserTP.repository.*;
import com.example.UserTP.entity.*;

@Service
public class PaymentServices {

    @Autowired
    CardRepository ccRepo;

    @Autowired
    PaypalRepository pRepo;

    @Autowired
    UserRepository uRepo;

    public List<CardPayment> getAllCard(){
        return ccRepo.findAll();
    }

    public CardPayment findOneCard(int id){
        return ccRepo.findById(id).orElse(null);
    }

    public void createCard(CardPayment cc ){
        ccRepo.save(cc);
    }

    public void deleteCard(int id){
        CardPayment cc = ccRepo.findById(id).orElse(null);
        if (cc!=null) ccRepo.delete(cc);
    }

    public void updateCard(CardPayment cc, int id){
        CardPayment card = ccRepo.findById(id).orElse(null);
        if(cc!=null){
            card.setAmount(cc.getAmount());
            card.setCardNumber(cc.getCardNumber());
            card.setExpirationDate(cc.getExpirationDate());
            card.setPaymentDate(cc.getPaymentDate());
            card.setCommand(cc.getCommand());
            ccRepo.save(card);
        }
    }

    public List<Paypal> getAllPaypal(){
        return pRepo.findAll();
    }

    public Paypal findOnePaypal(int id){
        return pRepo.findById(id).orElse(null);
    }

    public void createPaypal(Paypal p ){
        pRepo.save(p);
    }

    public void deletePaypal(int id){
        Paypal p = pRepo.findById(id).orElse(null);
        if (p!=null) pRepo.delete(p);
    }

    public void updatePaypal(Paypal p, int id){
        Paypal paypal = pRepo.findById(id).orElse(null);
        if(p!=null){
            paypal.setAmount(p.getAmount());
            paypal.setAccountNumber(p.getAccountNumber());
            paypal.setPaymentDate(p.getPaymentDate());
            paypal.setCommand(p.getCommand());
            pRepo.save(paypal);
        }
    }

    public Payment getByUser(int user_id){
        User u = uRepo.findById(user_id).orElse(null);
        List<Command> commands = u.getCommand();
        for(Command c : commands){
            if(c.getPayment()!=null) return c.getPayment();
        }
        return null;
    }

    public double userPayments(int id){
        double userPayment = 0;
        User user = uRepo.findById(id).orElse(null);
        List<Command> commands = user.getCommand();
        for(Command c : commands){
            Payment p = c.getPayment();
            userPayment += p.getAmount();
        }


        return userPayment;
    }
    
}
