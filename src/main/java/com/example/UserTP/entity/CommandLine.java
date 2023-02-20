package com.example.UserTP.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;
@Entity
@Table(name="command_line")
@Getter @Setter @NoArgsConstructor @ToString
public class CommandLine {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "command_id")
	@JsonBackReference
	private Command command;
	
//	@OneToOne( mappedBy = "commandLine")
//	private Command command;
	
//	@OneToOne
//	( mappedBy = "commandLine")
//	private Article article;
	
	@ManyToOne
	@JoinColumn(name = "article_id")
	@JsonManagedReference
	private Article article;

	public CommandLine(int quantity, Command command, Article article) {
		this.article=article;
		this.quantity = quantity;
		this.command = command;
	}

	

}
