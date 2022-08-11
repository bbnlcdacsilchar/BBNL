package com.bbnl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(generator = "userId")
	@GenericGenerator(name = "userId",strategy = "com.bbnl.entity.generator.UserIdGenerator")
	@Column(name = "user_id", length = 100)
	private String userId;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false, length = 100)
	private String role;
	@Column(name = "sec_question")
	private String secQuestion;
	@Column(name = "sec_answer")
	private String secAnswer;
	@Column(name = "first_name", nullable = false, length = 100)
	private String firstName;
	@Column(name = "middle_name", length = 100)
	private String middleName;
	@Column(name = "last_name", nullable = false, length = 100)
	private String lastName;
	@Column(name = "email_id", nullable = false, length = 100)
	private String email;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false, length = 100)
	private String city;
	private boolean status;
	@Column(name = "mobile_number")
	private Long mobileNumber;
	
	@Column(name = "account_non_locked")
	private boolean accountNonLocked = true;
	
	@Column(name = "unsuccessful_attempt")
	private long unsuccessfulAttempt;
	
	@Column(name = "lock_time")
	private Date lockTime;
	
	 public User() 
	  {
		  super(); 
		  this.status = false;
	  }
	
	public User(String password, String role, String secQuestion, String secAnswer, String firstName, String middleName,
			String lastName, String email, String address, String city, boolean status, Long mobileNumber,
			boolean accountNonLocked, long unsuccessfulAttempt, Date lockTime) {
		super();
		this.password = password;
		this.role = role;
		this.secQuestion = secQuestion;
		this.secAnswer = secAnswer;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.city = city;
		this.status = status;
		this.mobileNumber = mobileNumber;
		this.accountNonLocked = accountNonLocked;
		this.unsuccessfulAttempt = unsuccessfulAttempt;
		this.lockTime = lockTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSecQuestion() {
		return secQuestion;
	}

	public void setSecQuestion(String secQuestion) {
		this.secQuestion = secQuestion;
	}

	public String getSecAnswer() {
		return secAnswer;
	}

	public void setSecAnswer(String secAnswer) {
		this.secAnswer = secAnswer;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public long getUnsuccessfulAttempt() {
		return unsuccessfulAttempt;
	}

	public void setUnsuccessfulAttempt(long unsuccessfulAttempt) {
		this.unsuccessfulAttempt = unsuccessfulAttempt;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}
	
}
