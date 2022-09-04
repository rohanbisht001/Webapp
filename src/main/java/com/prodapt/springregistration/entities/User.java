package com.prodapt.springregistration.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

//	@NotNull(message = "Please enter your email addresss.")
//	@Email
	private String userName;

//	@NotNull(message = "Please enter your password.")
//	@Size(min = 6, max = 15)
	private String password;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "users_admin", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userId"), inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
	private Set<Admin> admin;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private UserDetails userDetails;

	public User(String userName, String password, Long userId, Set<Admin> admin, UserDetails userDetails) {
		super();
		this.userName = userName;
		this.password = password;
		this.userId = userId;
		this.admin = admin;
		this.userDetails = userDetails;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Set<Admin> getAdmin() {
		return admin;
	}

	public void setAdmin(Set<Admin> admin) {
		this.admin = admin;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", userId=" + userId + ", admin=" + admin
				+ ", userDetails=" + userDetails + "]";
	}

}
