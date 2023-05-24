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
	//constructor
	public File(Long id, String filename) {
		super();
		this.id = id;
		this.filename = filename;
	}
	//constructor empty 
	public File()
	{}
	// G&S
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}

	
	
	
}
