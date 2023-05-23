package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entite.VideoConference;

public interface VideoConferenceRepository extends JpaRepository<VideoConference, Long> {

}
