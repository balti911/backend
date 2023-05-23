package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entite.Message;

public interface MessageReppository extends JpaRepository<Message, Long> {

}
