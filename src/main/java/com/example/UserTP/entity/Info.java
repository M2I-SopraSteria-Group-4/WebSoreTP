package com.example.UserTP.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name="user_info")
@Getter @Setter @ToString @NoArgsConstructor 
public class Info {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_info_id")
	private int id;
	private String adress;
	private String city;
	private String email;
	@Column(name="phone_number")
	private String phoneNumber;
	
	
	
	@OneToOne
	@JoinColumn(name="user_id", nullable=false)
	@JsonBackReference
	private User user;



	public Info(String adress, String city, String email, String phoneNumber) {
		this.adress = adress;
		this.city = city;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}



	public Info(String adress, String city, String email, String phoneNumber, User user) {
		this.adress = adress;
		this.city = city;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.user = user;
	}

	

	

}
