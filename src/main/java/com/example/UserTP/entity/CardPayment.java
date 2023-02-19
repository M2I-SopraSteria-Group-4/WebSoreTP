package com.example.UserTP.entity;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="credit_card")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor 
public class CardPayment extends Payment {
	

	
	@Column(name ="card_number")
	private String cardNumber;
	
	@Column(name ="expiration_date")
	private Date expirationDate;
	
	@Override
	public String toString() {
		return super.toString() + "TCredit [cardNumber=" + cardNumber + ", dateExp=" + expirationDate + "]";
	}

}
