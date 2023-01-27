package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.IUser;
import model.User;

@RestController
public class UserController {

	@Autowired
	IUser user;
	
	@PostMapping("signup")
	public String singingup(@RequestBody User u) {
		try {
			
			user.save(u);
			return "true";
			
		} catch (Exception e) {
			return "false";
		} 
	}
	
	@PostMapping("login")
	public String loginuser(@RequestBody User u) {
		
		if(user.findById(u.getUsername()).get().getPassword().contains(u.getPassword())) {
			return "true";
		}else return "false";
		
	}
}

