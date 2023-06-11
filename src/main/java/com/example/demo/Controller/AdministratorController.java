package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

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
import com.example.demo.Entite.ChatRoom;
import com.example.demo.Entite.Report;
import com.example.demo.Entite.Statistics;
import com.example.demo.Entite.User;
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
	//repository
	private  ChatRoomRepository chromrp;
	private UserRepository userrepo;
	private RepportRepository reportrepo;
	private StaticsRepository strepo;
//function create chatRoom
	@PostMapping("/createChatroom")
	 public void createChatRoom(ChatRoom chatRoom) {
		 chromrp.save(chatRoom);
	    }
	
 //edite chatRoom
	@GetMapping("/editChatRoom")
    public void editChatRoom(Long chatRoomId, ChatRoom updatedChatRoom) {
        ChatRoom existingChatRoom = chromrp.findById(chatRoomId)
                .orElseThrow(() -> new IllegalArgumentException("Chat room not found"));

        // Update the existing chat room with the new details
        existingChatRoom.setNom(updatedChatRoom.getNom());
        existingChatRoom.setDecsription(updatedChatRoom.getDecsription());
        existingChatRoom.setDate(updatedChatRoom.getDate());
        chromrp.save(existingChatRoom);
	}
	//delete ChatRoom
	@DeleteMapping("/deleteChatroom")

    public void deleteChatRoom(Long chatRoomId) {
		chromrp.deleteById(chatRoomId);
    } 
	//add user to existing chatRoom
	@PostMapping("/{idchatroom}/addotherUser/{iduser}")
	public void addotherUser(Long chatRoomId, Long userId) {
        ChatRoom chatRoom = chromrp.findById(chatRoomId)
                .orElseThrow(() -> new IllegalArgumentException("Chat room not found"));

        User user = userrepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        chatRoom.getParticipants().add(user);
        chromrp.save(chatRoom);
    }
	//function remouve user 
	@PostMapping("/removeAuthorizedUser")
	  public void removeAuthorizedUser(Long chatRoomId, Long userId) {
	        ChatRoom chatRoom = chromrp.findById(chatRoomId)
	                .orElseThrow(() -> new IllegalArgumentException("Chat room not found"));

	        User user = userrepo.findById(userId)
	                .orElseThrow(() -> new IllegalArgumentException("User not found"));

	        chatRoom.getParticipants().remove(user);
	        chromrp.save(chatRoom);
	    }
	//function create user 
	@PostMapping("/createUser")
	 public void createUser(User user) {
		 userrepo.save(user);
	    }
// function EditUser
	@PostMapping("/editUser")
	    public void editUser(Long userId, User updatedUser) {
	        User existingUser = userrepo.findById(userId)
	                .orElseThrow(() -> new IllegalArgumentException("User not found"));

	       
	        existingUser.setNom(updatedUser.getNom());
	        existingUser.setPrenom(updatedUser.getPrenom());
	        existingUser.setEmail(updatedUser.getEmail());
	        existingUser.setNomUtil(updatedUser.getNomUtil());
	       	        userrepo.save(existingUser);
	    }
@DeleteMapping("/{userid} /deleteUser")
	    public void deleteUser(Long userId) {
	    	userrepo.deleteById(userId);
	    }
//function checkReports
public void checkReports(List<Long> reportIds) {
    for (Long reportId : reportIds) {
        Report report = reportrepo.findById(reportId)
                .orElseThrow(() -> new IllegalArgumentException("Report not found"));

     }
}
// fonction chekstatistic 
@GetMapping("/chekStatistic")
public Optional<Statistics> chekStatistic (Long idstatistic) {
	
return	strepo.findById(idstatistic);
}

}
