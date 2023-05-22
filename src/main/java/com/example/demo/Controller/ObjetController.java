package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Entite.Objet;
import com.example.demo.Repository.ObjectRepository;

@RestController
@RequestMapping("/api/v4/")
public class ObjetController {
	@Autowired
	private ObjectRepository objectrepo;
	@GetMapping("/find")
	public List<java.lang.Object> GetAlluser(){
		return objectrepo.findAll();
	}
	@PostMapping("/save")
	public Objet save(@RequestBody Objet ob) {
		return  objectrepo.save(ob);}
	@DeleteMapping("/delete")
	public void DeleteById(Long id )
	{
		objectrepo.deleteById(id);
	}

}
