package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entite.File;

public interface FileRepository extends JpaRepository<File, Long> {

}
