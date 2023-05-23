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

import com.example.demo.Entite.User;
import com.example.demo.Entite.VideoConference;
import com.example.demo.Repository.VideoConferenceRepository;

@RestController
@RequestMapping("/api/videoConference")
public class VideoConferenceController {
	@Autowired
	private VideoConferenceRepository videoconfrepo;
	@GetMapping("/find")
	public List<VideoConference> GetAllVideo(){
		return videoconfrepo.findAll();}
	@PostMapping("/save")
	public VideoConference save(@RequestBody VideoConference vdc) {
		
		return videoconfrepo.save(vdc);}
	@DeleteMapping("/delete")
	public void DeleteById(Long id )
	{
		videoconfrepo.deleteById(id);
	}
}
