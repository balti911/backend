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
import com.example.demo.Repository.FileRepository;

@RestController
@RequestMapping("/api/file/")
public class FileController {
	@Autowired
	private FileRepository filerepo;
	@GetMapping("/find")
	public List<File> GetAlluser(){return filerepo.findAll();}
	@PostMapping("/save")
	public File save(@RequestBody File fl) {
		
		return filerepo.save(fl);}
	@DeleteMapping("/delete")
	public void DeleteById(Long id )
	{
		filerepo.deleteById(id);
	}
	

}
