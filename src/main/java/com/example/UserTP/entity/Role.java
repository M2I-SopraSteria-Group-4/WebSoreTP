package com.example.UserTP.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="user_role")
@Getter @Setter @ToString @NoArgsConstructor 
public class Role {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	private int id;
	@Column(name="rolename")
	private String roleName;
	
	@ManyToMany
    @JoinTable( name = "role_user_association",
			    joinColumns = @JoinColumn( name = "id_role" ),
			    inverseJoinColumns = @JoinColumn( name = "id_user" ) )
	@JsonBackReference
	private List<User> user;

	public Role(String roleName) {
		this.roleName = roleName;
	}

	public Role(String roleName, List<User> user) {
		this.roleName = roleName;
		this.user = user;
	}

	

	

}
