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

    public List<CardPayment> getAllCard(){
        return ccRepo.findAll();
    }

    public CardPayment findOneCard(int id){
        return ccRepo.findById(id).orElse(null);
    }

    public void createCard(CardPayment cc ){
        ccRepo.save(cc);
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
    
}
