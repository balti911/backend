package com.example.demo.Entite;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.ValueGenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="videoConfirence")
public class VideoConference {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name="start_time")
    private LocalDateTime startTime;
	@Column(name="end_time")
    private LocalDateTime endTime;
	@Column(name="participant")
	private List<User> participant;
	//const
	public VideoConference(Long id, LocalDateTime startTime, LocalDateTime endTime , List<User> participant) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.participant=participant;
	}
	//G&S
	
	public Long getId() {
		return id;
	}
	public List<User> getParticipant() {
		return participant;
	}

	public void setParticipant(List<User> participant) {
		this.participant = participant;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	

}
