package com.example.UserTP.entity;

import java.util.Date;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter @Setter @NoArgsConstructor @ToString
public abstract class Payment {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int payment_id;
	private double amount;
	private Date paymentDate;
	
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true )
	@JoinColumn(name="command_id", nullable=false)
	@JsonBackReference
	private Command command;


	public Payment(double amount, Date paymentDate, Command command) {
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.command = command;
	}

	

}
