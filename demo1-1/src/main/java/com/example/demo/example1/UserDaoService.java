package com.example.demo.example1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Component;


@Component
public class UserDaoService {
	
	private static List <Userpojo> users=new ArrayList<Userpojo>();
	
	private static int usercount =3;
	static {
		
		users.add(new Userpojo(1 , "vaibhav", new Date()));
		users.add(new Userpojo(2 , "vishavas", new Date()));

		users.add(new Userpojo(3 , "ganediwal", new Date()));

	}
	
	public List <Userpojo> getAll (){
		return users;
		
	}
	
	public Userpojo saveUser(Userpojo user) {
		System.out.print("fristtine"+user.getUserId());
		if(user.getUserId() ==  null) {
			user.setUserId(++usercount);
		}
		System.out.print("second"+user.getUserId());

		users.add(user);
		return user;
	} 
	
	public  Userpojo getuserbyId(Integer userId) {
		
		for(Userpojo user :users)
		{
			if(user.getUserId()==userId) {
				return user;
			}
		}
		return null;
	}
	
	
	public  Boolean deleteUderById(Integer id) {
	Iterator<Userpojo>	user=users.iterator();
	
	while (user.hasNext()) {
		Userpojo userPozo = (Userpojo) user.next();
		
		if(userPozo.getUserId()==id) {
			user.remove();
			return true;
		}
		
	}
	return  false;
		
	}

}
