package com.example.demo.example1;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;


@ApiModel("All details about user")
@Entity
public class Userpojo {
	@Size(min = 2,message = "Min size must be grater than 2")
	private String userName;
	
	@Id
	@GeneratedValue
	private Integer userId;
	@Past
	private Date dob;
	public Userpojo() {}
	
	public Userpojo(int userId, String userName, Date date) {
		this.userName=userName;
		this.userId=userId;
		this.dob=date;
		
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	//jdbc:h2:~/test
	

}
