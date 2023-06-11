package com.example.demo.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entite.ChatRoom;
import com.example.demo.Entite.File;
import com.example.demo.Entite.Report;
import com.example.demo.Entite.User;
import com.example.demo.Entite.VideoConference;
import com.example.demo.Repository.*;

@RestController
@RequestMapping("/api/user/")
public class UserController {
	@Autowired
	private UserRepository userrepository;
	
	@GetMapping("/find")
	public List<User> GetAlluser(){return userrepository.findAll();}
	@PostMapping("/save")
	public User save(@RequestBody User sr) {
		String mtp=sr.getPassword();
		BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
		String encryptedpassword=bcrypt.encode(mtp);
		sr.setPassword(encryptedpassword);
		return userrepository.save(sr);}
	@DeleteMapping("/delete")
	public void DeleteById(Long id )
	{
		userrepository.deleteById(id);
	}
	//repository
	@Autowired
	private  ChatRoomRepository chromrp;
	private UserRepository userrepo;
	private VideoConferenceRepository videoConfRepo;
	private FileRepository filerepo;
	private RepportRepository rprepository;
	//function join room
	@PostMapping("/{chatRoomId}/join/{userId}")
	public void joinRoom(Long idchatroom,Long iduser)
	{
		ChatRoom chtroom=chromrp.findById(idchatroom).orElseThrow(() -> new IllegalArgumentException("Chat room not found"));;
		User user= userrepo.findById(iduser).orElseThrow(() -> new IllegalArgumentException("User not found"));
	  chtroom.getParticipants().add(user);
	  chromrp.save(chtroom);
	}
		
	//Function CreateRoom
	@PostMapping("/{roomName}/create/{CreatorId}")
	public ChatRoom createRoom(String roomName, Long creatorId) {
        User creator = userrepo.findById(creatorId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setNom(roomName);
        chatRoom.getParticipants().add(creator);

        return chromrp.save(chatRoom);
    }
//function invite user
	@PostMapping("/{chatRoomId}/invite/{userId}")
	 public void inviteUser(Long chatRoomId, Long userId) {
	        ChatRoom chatRoom = chromrp.findById(chatRoomId)
	                .orElseThrow(() -> new IllegalArgumentException("Chat room not found"));

	        User invitedUser = userrepo.findById(userId)
	                .orElseThrow(() -> new IllegalArgumentException("User not found"));

	        chatRoom.getParticipants().add(invitedUser);
	        chromrp.save(chatRoom);
	

}
	 // function participate vedeoConf
	@PostMapping("/{videoid}/participate/{userId}")
	 public void participateVideoConference(Long videoConferenceId, Long userId) {
	        VideoConference videoConference = videoConfRepo.findById(videoConferenceId)
	                .orElseThrow(() -> new IllegalArgumentException("Video conference not found"));

	        User participant = userrepo.findById(userId)
	                .orElseThrow(() -> new IllegalArgumentException("User not found"));

	        videoConference.getParticipant().add(participant);
	        videoConfRepo.save(videoConference);
	    }
	// function sharefile
	@PostMapping("/{chatRoomId}/{userId}/share/{fileName}/{file_id}")
	 public void shareFile(Long chatRoomId, Long userId, String fileName,Long file_id) {
        ChatRoom chatRoom = chromrp.findById(chatRoomId)
                .orElseThrow(() -> new IllegalArgumentException("Chat room not found"));
        User user = userrepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        if (!chatRoom.getParticipants().contains(user)) {
            throw new IllegalArgumentException("User is not authorized to share files in this chat room");
        }
        File file = new File(file_id,fileName);
        filerepo.save(file);
        chatRoom.getSharedFile().add(file);
        chromrp.save(chatRoom);
    }
	 //function leaveRoom
	@PostMapping("/{chatRoomId}/leavRoom/{userId}")
	 public void leaveRoom(Long chatRoomId, Long userId) {
	        ChatRoom chatRoom = chromrp.findById(chatRoomId)
	                .orElseThrow(() -> new IllegalArgumentException("Chat room not found"));

	        User user = userrepo.findById(userId)
	                .orElseThrow(() -> new IllegalArgumentException("User not found"));

	        chatRoom.getParticipants().remove(user);
	        chromrp.save(chatRoom);
	    }
	
	 // function create report 
	public Report createReport(@RequestBody Report rp) {
		return rprepository.save(rp);
	}
}
