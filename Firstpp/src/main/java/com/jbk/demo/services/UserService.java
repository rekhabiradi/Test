package com.jbk.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jbk.demo.model.User;
import com.jbk.demo.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	private final UserRepository repo;
	public UserService(UserRepository repo)
	{
		this.repo=repo;
	}
	public void saveMyUser(User user)
	{
		repo.save(user);
		
	}
	public List<User> showAllUsers()
	{
		List<User> l=new ArrayList<User>();
		for(User user:repo.findAll())
		{
			l.add(user);
		}
		return l;
		
	}
	public void deleteMyUser(int id)
	{
		repo.deleteById(id);;
		
	}
	public User editUser(int id)
	{
		return repo.findById(id);
		
	}
	public User findByUsernameAndPassword(String username, String password) {
		return repo.findByUsernameAndPassword(username, password);
	}

}
