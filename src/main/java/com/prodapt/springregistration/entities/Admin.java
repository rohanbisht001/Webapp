package com.prodapt.springregistration.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Admin(Long id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}

	public Admin() {
		super();
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", userName=" + userName + "]";
	}

}
