package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entite.Message;
import com.example.demo.Entite.User;
import com.example.demo.Repository.MessageReppository;

@RestController
@RequestMapping("/api/message/")
public class MessageController {
	@Autowired
	private MessageReppository messagereppo;
	@GetMapping("/find")
	public List<Message> GetAlluser(){return messagereppo.findAll();}
	@PostMapping("/save")
	public Message save(@RequestBody Message ms) {
		
		return messagereppo.save(ms);}
	@DeleteMapping("/delete")
	public void DeleteById(Long id )
	{
		messagereppo.deleteById(id);
	}
}
