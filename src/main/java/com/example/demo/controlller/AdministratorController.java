package com.example.demo.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entite.Administrator;
import com.example.demo.repository.AdministratorRepository;

@RestController
@RequestMapping("/api/v2/")
public class AdministratorController {
	@Autowired
	private AdministratorRepository administratorreposit;
	@GetMapping ("/find")
	public List<Administrator> findAllAdministrator()
	{
		return administratorreposit.findAll();
	}
	@PostMapping("/save")
	public Administrator Save(@RequestBody Administrator adr) {
		return administratorreposit.save(adr);
	}
	@DeleteMapping("/delete")
	public void deleteByid(Long id) {
		administratorreposit.deleteById(id);
	}

}
