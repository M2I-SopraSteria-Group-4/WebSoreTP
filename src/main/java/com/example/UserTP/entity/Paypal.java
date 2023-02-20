package com.example.UserTP.entity;

import javax.persistence.*;
import java.util.*;

import lombok.*;

@Entity
@Table(name="paypal")
@Getter @Setter @NoArgsConstructor 
public class Paypal extends Payment{
	
	@Column(name ="account_number")
	private String accountNumber;
	@Override
	public String toString() {
		return super.toString() + "PaypalPayment [ accountNumber=" + accountNumber + "]";
	}
	public Paypal(String accountNumber, double amount, Date paymentDate, Command command) {
		super(amount, paymentDate, command);
		this.accountNumber = accountNumber;
	}

}
