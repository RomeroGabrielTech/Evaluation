package com.bci.peopledata.entitys;


import java.util.UUID;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="persons")
public class Peoples{


	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="id", updatable = false, nullable = false)
	private UUID id;


	@Column(name="name")
	private String name;
	
	@Column(name="email")	
	private String email;
	
	@Column(name="password")	
	private String password;

	@Column(name="created")	
	private Date created;

	private String token;
	
	private Boolean isactive;
	
	///////////////////////////////////////
	
	
	

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	@Column(name="modified")	
	private Date modified;
	
	@Column(name="last_login")	
	private Date last_login;
	

	
	@PrePersist
	private void onCreated() {
		last_login = modified = created = new Date();
	}

	@PreUpdate
	private void onLastLogin() {
		last_login = new Date();
	}




	

	


	
	
	
	
	

}
