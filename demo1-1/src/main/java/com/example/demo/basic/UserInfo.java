package com.example.demo.basic;

public class UserInfo  {
	private String frstName;
	private String lastName;

	public UserInfo(String frstName, String lastName) {
		this.frstName=frstName;
		this.lastName=lastName;
		
		
		// TODO Auto-generated constructor stub
	}

	public void setFrstName(String frstName) {
		this.frstName = frstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFrstName() {
		return frstName;
	}

	public String getLastName() {
		return lastName;
	}
	

}
