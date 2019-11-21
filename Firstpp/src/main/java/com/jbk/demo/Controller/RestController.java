package com.jbk.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jbk.demo.model.User;
import com.jbk.demo.services.UserService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	private UserService userservice;
	
	
	@GetMapping("/")
	public String hello()
	{
		return "this is the home page";
	}
	@GetMapping("/saveuser")
public String saveUser(@RequestParam String username,@RequestParam String firstname,@RequestParam String lastname,@RequestParam int age,@RequestParam String password)
{
		System.out.println("here");
		User user=new User(username,firstname,lastname,age,password);
		userservice.saveMyUser(user);
	return "user is saved";
			}
}
