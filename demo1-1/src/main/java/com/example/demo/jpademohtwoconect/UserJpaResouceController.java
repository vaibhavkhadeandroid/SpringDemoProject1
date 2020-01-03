package com.example.demo.jpademohtwoconect;


import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.example1.UserDaoService;
import com.example.demo.example1.UserNotFoundException;
import com.example.demo.example1.Userpojo;






@RestController
public class UserJpaResouceController {
	
	

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UserDaoService service;
	
	@Autowired
	private  UserRepository userrepository ;
	
	@GetMapping("jpa/getallusers")
	private List<Userpojo> getAllUser(){
		
		System.out.print("jbjkdvkj");
		return userrepository.findAll();
	
	}
	
	
	@GetMapping("jpa/getUserbyid/userid={userid}")
	private Userpojo getuserbyid(@PathVariable Integer userid){
		Userpojo user =userrepository.getOne(userid);
		if(user==null) {
			throw new UserNotFoundException("userd - "+ userid);
		}
		return user ;
	}
	
	@PostMapping ("jpa/ctrateuser")
	private ResponseEntity<Object> createuser(@Valid @RequestBody Userpojo userpozo) {
	Userpojo user=	service.saveUser(userpozo);
	URI location	=ServletUriComponentsBuilder.
		fromCurrentRequest()
		.path("/{userid}")
		.buildAndExpand(userpozo.getUserId())
		.toUri();
		
return ResponseEntity.created(location).build()	;	
		
	}
	
	
	@DeleteMapping("jpa/deleteuser/id={userid}")
	private void deleteUser(@PathVariable Integer userid){
		
	Boolean status=	service.deleteUderById(userid);
	
	if(status) {
		
	}else {
		throw new UserNotFoundException("userd - "+ userid);
	}
		
		
	}
	
	
	
	
	@GetMapping ("jpa/getjbhjjh")
	private String getInterlizationgoodmsg(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		
		
		return messageSource.getMessage("googd.morning.message", null,locale );
		
	}
	
	

}
