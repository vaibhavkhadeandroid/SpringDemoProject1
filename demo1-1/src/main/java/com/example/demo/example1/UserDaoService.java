package com.example.demo.example1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Component;


@Component
public class UserDaoService {
	
	private static List <UserPozo> users=new ArrayList<UserPozo>();
	
	private static int usercount =3;
	static {
		
		users.add(new UserPozo(1 , "vaibhav", new Date()));
		users.add(new UserPozo(2 , "vishavas", new Date()));

		users.add(new UserPozo(3 , "ganediwal", new Date()));

	}
	
	public List <UserPozo> getAll (){
		return users;
		
	}
	
	public UserPozo saveUser(UserPozo user) {
		System.out.print("fristtine"+user.getUserId());
		if(user.getUserId() ==  null) {
			user.setUserId(++usercount);
		}
		System.out.print("second"+user.getUserId());

		users.add(user);
		return user;
	} 
	
	public  UserPozo getuserbyId(Integer userId) {
		
		for(UserPozo user :users)
		{
			if(user.getUserId()==userId) {
				return user;
			}
		}
		return null;
	}
	
	
	public  Boolean deleteUderById(Integer id) {
	Iterator<UserPozo>	user=users.iterator();
	
	while (user.hasNext()) {
		UserPozo userPozo = (UserPozo) user.next();
		
		if(userPozo.getUserId()==id) {
			user.remove();
			return true;
		}
		
	}
	return  false;
		
	}

}
