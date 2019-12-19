package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.basic.UserInfo;


@RestController
public class HellowWorldcontroller {
	//old way to get method
	@RequestMapping(method = RequestMethod.GET,path = "/hello-world")
	public String hellowwprld(){
		return "Hellow world";
	}
	//new way to get method
	@GetMapping(path="/getuser")
	
	public String getUser() {
		return  "vaibhav" ;
	}
	
@GetMapping(path="/getuserone")
	
	public UserInfo getUser_one() {
		return  new UserInfo("vaibhav", "Khade") ;
	}
//this is how u create path variable
@GetMapping(path="/getuserid/{userid}/ name/{username}")

public String getUser_one(@PathVariable String userid,@PathVariable String username) {
	return String.format("Hello $s u r user id is %s", username,userid);
}

}
