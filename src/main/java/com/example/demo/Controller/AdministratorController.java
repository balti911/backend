package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entite.Administrator;
import com.example.demo.Repository.*;

@RestController
@RequestMapping("/api/Administrator/")
public class AdministratorController {
	@Autowired
	private AdministratorRepository administratorrepository;
	@GetMapping ("/find")
	public List<Administrator> findAllAdministrator()
	{
		return administratorrepository.findAll();
	}
	@PostMapping("/save")
	public Administrator Save(@RequestBody Administrator adr) {
		String mtp=adr.getPassword();
		BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
		String encryptedpassword=bcrypt.encode(mtp);
		adr.setPassword(encryptedpassword);
		return administratorrepository.save(adr);
	}
	@DeleteMapping("/delete")
	public void deleteByid(Long id) {
		administratorrepository.deleteById(id);
	}

}
