package com.example.UserTP.entity;


import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;

@Entity
@Table(name ="users")
@Getter @Setter @NoArgsConstructor @ToString
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	private String login;
	private String password;
	private int connectionNumber;
	
	@ManyToMany
    @JoinTable( name = "role_user_association",
			    joinColumns = @JoinColumn( name = "id_user" ),
			    inverseJoinColumns = @JoinColumn( name = "id_role" ) )
	@JsonManagedReference
	private List<Role> role;

	@OneToOne( mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private Info info;
	
	@OneToMany(mappedBy = "user")
	@JsonManagedReference
    private List<Command> command;

	public User(String login, String password, int connectionNumber) {
		this.login = login;
		this.password = password;
		this.connectionNumber = connectionNumber;
	}

	public User(String login, String password, int connectionNumber, Info info) {
		this.login = login;
		this.password = password;
		this.connectionNumber = connectionNumber;
		this.info = info;
	}

	public User(String login, String password, int connectionNumber, List<Role> role) {
		this.login = login;
		this.password = password;
		this.connectionNumber = connectionNumber;
		this.role = role;
	}
}
