package com.example.UserTP.entity;

import javax.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.*;

import lombok.*;

@Entity
@Table(name ="article")
@Getter @Setter @NoArgsConstructor @ToString
public class Article {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int article_id;
	private String description;
	private String brand;
	private double price;
	
	public Article(String description, String brand, double price) {
		this.description = description;
		this.brand = brand;
		this.price = price;
	}
	
	// @OneToMany(mappedBy = "article")
	// @JsonBackReference
    // private List<CommandLine> CommandLine;

	

}
