package com.joaocarlos.aulasimple.model;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity 
@Table(name = "user")
public class User {
	
	public interface CreateUser {
		}
	
	public interface UpdateUser{
		}
	
 public static final String TABLE_NAME = "user";
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id", unique = true)
  private Long id;
 
 @Column(name = "username", length = 100, nullable = false, unique = true)
 @NotNull(groups = CreateUser.class)
 @NotEmpty(groups = CreateUser.class)
 @Size(groups = CreateUser.class, min = 4, max = 100)
 private  String username;
 
 
 @JsonProperty(access = Access.WRITE_ONLY)
 @Column(name = "password", length = 60, nullable =false )
 @NotNull(groups = {CreateUser.class, UpdateUser.class})
 @NotEmpty(groups = {CreateUser.class, UpdateUser.class})
 @Size(groups = {CreateUser.class, UpdateUser.class}, min = 8, max = 60)
 private String password;


 
 @OneToMany(mappedBy = "user")
 private List<Task> taskx  = new ArrayList<Task>();
 
 
 
 
 
 public User() {
		
 }


public User(Long id,
		@NotNull(groups = CreateUser.class) @NotEmpty(groups = CreateUser.class) @Size(groups = CreateUser.class, min = 4, max = 100) String username,
		@NotNull(groups = { CreateUser.class, UpdateUser.class }) @NotEmpty(groups = { CreateUser.class,
				UpdateUser.class }) @Size(groups = { CreateUser.class,
						UpdateUser.class }, min = 8, max = 60) String password) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getUsername() {
	return username;
}


public void setUsername(String username) {
	this.username = username;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public List<Task> getTaskx() {
	return taskx;
}


public void setTaskx(List<Task> taskx) {
	this.taskx = taskx;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return Objects.equals(id, other.id) && Objects.equals(password, other.password)
			&& Objects.equals(username, other.username);
}
  
  
}
