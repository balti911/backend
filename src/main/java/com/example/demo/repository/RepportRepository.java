package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entite.Report;

public interface RepportRepository extends JpaRepository<Report, Long> {

}
