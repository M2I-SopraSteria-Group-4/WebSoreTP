package com.example.UserTP.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name="paypal")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor 
public class PaypalPayment extends Payment{
	
	
	
	@Column(name ="account_number")
	private String accountNumber;
	@Override
	public String toString() {
		return super.toString() + "PaypalPayment [ accountNumber=" + accountNumber + "]";
	}
	
	
	
	
	
	

}
