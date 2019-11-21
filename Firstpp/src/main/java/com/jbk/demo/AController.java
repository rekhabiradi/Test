package com.jbk.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jbk.demo.model.User;
import com.jbk.demo.repository.UserRepository;
import com.jbk.demo.services.UserService;

@Controller
public class AController {
	@Autowired
	private UserService userservice;
	@RequestMapping("home")
	public String home(HttpServletRequest request)
	{
	request.setAttribute("mode", "MODE_HOME");
	
		return "abc";
	}
	@RequestMapping("register")
	public String register(HttpServletRequest request)
	{
	request.setAttribute("mode", "MODE_REGISTER");
	
		return "abc";
	}
	@PostMapping("/save-user")
	public String registeruser(@ModelAttribute User user,BindingResult result,HttpServletRequest request)
	{
	
	userservice.saveMyUser(user);
	request.setAttribute("mode","MODE_HOME");
		return "abc";
	}
	
	@RequestMapping("/show-users")
	public String showAllUsers(HttpServletRequest request)
	{
		request.setAttribute("l", userservice.showAllUsers());
		request.setAttribute("mode","MODE_SHOW");
		
		return "abc";
	}
	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id,HttpServletRequest request )	
	{
		userservice.deleteMyUser(id);
		request.setAttribute("l", userservice.showAllUsers());
		request.setAttribute("mode","MODE_SHOW");
		return "abc";
		
	}
	@RequestMapping("/edit-user")
	public String editUser(@RequestParam int id,HttpServletRequest request )	
	{
		
		request.setAttribute("user", userservice.editUser(id));
		request.setAttribute("mode","MODE_UPDATE");
		return "abc";
		
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request)
	{
		request.setAttribute("mode","MODE_LOGIN");
		return "abc";
	}
	   
	
	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping("/login-user")
	public String loginUser(@ModelAttribute User user,HttpServletRequest request)
	{
	User admin=null;
	if(userservice.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null)
	{	
		return "homepage";
	}
	else {
		request.setAttribute("error", "invalid username and password");
		request.setAttribute("mode","MODE_LOGIN");
		return "abc";
		
	}
	
		
	}
	@RequestMapping("/forgot")
	public String forgot(HttpServletRequest request)
	{
		request.setAttribute("mode","MODE_FORGOT");
		return "abc";
	}
	   


}
