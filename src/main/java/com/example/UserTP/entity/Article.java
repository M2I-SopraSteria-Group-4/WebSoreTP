package com.example.UserTP.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name ="article")
@Getter @Setter @NoArgsConstructor @ToString
public class Article {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int article_id;
	private String description;
	private String brand;
	private float price;
	
	@OneToOne
	@JoinColumn(name="article_id", nullable=false)
	private CommandLine commandLine;

}
