package com.prodapt.springregistration.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String firstName;
	private String lastName;
	private Integer age;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public UserDetails(Long userId, String firstName, String lastName, Integer age) {
		super();
		this.userId = userId;

		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public UserDetails() {
		super();
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ",  firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ "]";
	}

}
