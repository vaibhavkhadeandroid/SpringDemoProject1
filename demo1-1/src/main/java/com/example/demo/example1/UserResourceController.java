package com.example.demo.example1;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

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

@RestController
public class UserResourceController {
	
	

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UserDaoService service;
	
	
	@GetMapping("getallusers")
	private List<UserPozo> getAllUser(){
		return service.getAll();
	
	}
	
	
	@GetMapping("getUserbyid/userid={userid}")
	private UserPozo getuserbyid(@PathVariable Integer userid){
		UserPozo user =service.getuserbyId(userid);
		if(user==null) {
			throw new UserNotFoundException("userd - "+ userid);
		}
		return user ;
	}
	
	@PostMapping ("ctrateuser")
	private ResponseEntity<Object> createuser(@Valid @RequestBody UserPozo userpozo) {
	UserPozo user=	service.saveUser(userpozo);
	URI location	=ServletUriComponentsBuilder.
		fromCurrentRequest()
		.path("/{userid}")
		.buildAndExpand(userpozo.getUserId())
		.toUri();
		
return ResponseEntity.created(location).build()	;	
		
	}
	
	
	@DeleteMapping("deleteuser/id={userid}")
	private void deleteUser(@PathVariable Integer userid){
		
	Boolean status=	service.deleteUderById(userid);
	
	if(status) {
		
	}else {
		throw new UserNotFoundException("userd - "+ userid);
	}
		
		
	}
	
	
	
	
	@GetMapping ("getjbhjjh")
	private String getInterlizationgoodmsg(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		
		
		return messageSource.getMessage("googd.morning.message", null,locale );
		
	}
	
	

}
