package com.example.UserTP.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;

@Entity
@Table(name="commands")
@Getter @Setter @ToString @NoArgsConstructor 
public class Command {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="command_id")
	private int id;
	
	@Column(name="command_date")
	private Date commandDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private User user;
	
	@OneToMany(mappedBy = "command")
	@JsonManagedReference
    private List<CommandLine> commandLine;
//	@OneToOne
//	@JoinColumn(name="command_line_id", nullable=false)
//	private CommandLine commandLine;
	
	@OneToOne( mappedBy = "command")
	private Payment payment;

}
