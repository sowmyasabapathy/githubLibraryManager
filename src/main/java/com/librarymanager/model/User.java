/**
 * @author Sowmya Sabapathy
 *
 * Library Manager Project
 */
package com.librarymanager.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity


public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	private Long id;
	private String name;
	@Column(unique = true)
	private String email;
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
		super();
	}

	public User(Long id) {
		super();
		this.id = id;
	}

	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
