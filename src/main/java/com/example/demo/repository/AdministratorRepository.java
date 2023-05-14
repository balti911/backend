package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entite.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

}
