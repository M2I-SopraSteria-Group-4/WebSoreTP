package com.example.UserTP.entity;

import java.util.Date;

import javax.persistence.*;

import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter @NoArgsConstructor @ToString
public abstract class Payment {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private float amount;
	private Date paymentDate;
	
	
	@OneToOne
	@JoinColumn(name="payment_id", nullable=false)
	private Command command;

}
