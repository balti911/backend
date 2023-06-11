package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entite.ChatRoom;
import com.example.demo.Entite.Report;
import com.example.demo.Entite.Statistics;
import com.example.demo.Entite.User;
import com.example.demo.Repository.ChatRoomRepository;
import com.example.demo.Repository.RepportRepository;
import com.example.demo.Repository.StaticsRepository;
import com.example.demo.Repository.UserRepository;

@RestController
@RequestMapping("/api/statistic/")
public class StatisticController {
	@Autowired
	private StaticsRepository statisticrepo;
	@GetMapping("/find")
	public List<Statistics> GetAllStatistic(){return statisticrepo.findAll();}
	@PostMapping("/save")
	public Statistics save(@RequestBody Statistics st) {
		
		return statisticrepo.save(st);}
	@DeleteMapping("/delete")
	public void DeleteById(Long id )
	{
		statisticrepo.deleteById(id);
	}
	// autowired
	private ChatRoomRepository chromrp;
	private UserRepository userrepo;
	// function calculate chatRoo Activate
	public int calculatechActive() {
	int nbchroomAct=0;
	List<ChatRoom> lschatrom;
	lschatrom=chromrp.findAll();
	for (ChatRoom chatRoom : lschatrom) {
		if(chatRoom.isEtat()==true)
			nbchroomAct=nbchroomAct+1;
		
	}
	return nbchroomAct;
	}
	//function calculate user conected
	public int calculateUserconected() {
		int nbuserconected=0;
		List<User> lsuser;
		lsuser=userrepo.findAll();
		for (User user : lsuser) {
			if(user.isEtat()==true)
				nbuserconected=nbuserconected+1;
			
		}
		return nbuserconected;
		}
}
