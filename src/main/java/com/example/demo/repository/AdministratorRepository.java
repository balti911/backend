package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entite.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

}
