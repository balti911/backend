package com.example.demo.Entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="file")
public class File {
	@Id
    private Long id;
	@Column(name="file_name")
    private String filename;

	
}
