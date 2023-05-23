package com.example.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entite.ChatRoom;
import com.example.demo.Repository.*;

@RestController
@RequestMapping("/api/chatroom/")
public class ChatRoomController {
@Autowired
private ChatRoomRepository chatroomrpo;
@GetMapping("/find")
public List<ChatRoom> findAllrom()
{
	return chatroomrpo.findAll();
}
@PostMapping("/save")
public ChatRoom save(@RequestBody ChatRoom chr )
{return chatroomrpo.save(chr);}
}
