package com.example.demo.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entite.User;
import com.example.demo.Repository.*;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
	@Autowired
	private UserRepository userrepository;
	@GetMapping("/find")
	public List<User> GetAlluser(){return userrepository.findAll();}
	@PostMapping("/save")
	public User save(@RequestBody User sr) {
		return userrepository.save(sr);}
	@DeleteMapping("/delete")
	public void DeleteById(Long id )
	{
		userrepository.deleteById(id);
	}
		
	
	

}
