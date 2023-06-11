package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entite.File;
import com.example.demo.Entite.Report;
import com.example.demo.Repository.FileRepository;
import com.example.demo.Repository.RepportRepository;

@RestController
@RequestMapping("/api/Repport/")
public class RepportController {
	@Autowired
	private RepportRepository reportrepot;
	@GetMapping("/find")
	public List<Report> GetAlluser(){return reportrepot.findAll();}
	@PostMapping("/save")
	public Report save(@RequestBody Report rp) {
		
		return reportrepot.save(rp);}
	@DeleteMapping("/delete")
	public void DeleteById(Long id )
	{
		reportrepot.deleteById(id);
	}


}
