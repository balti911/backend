package com.example.demo.entite;

import org.hibernate.annotations.ValueGenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="object")
public class Object {
@Id 
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Long id ;
@Column(name ="type_object")
private String type ;
public Object(Long id, String type) {
	super();
	this.id = id;
	this.type = type;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

}
