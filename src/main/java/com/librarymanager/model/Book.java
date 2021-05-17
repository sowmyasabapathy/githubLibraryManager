/**
 * @author Sowmya Sabapathy
 *
 * Library Manager Project
 */


package com.librarymanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor

public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	private Long id;
	private String name;
	private String author;
	@Column(unique=true)
	private String isbn;
	
	public Book(Long id) {
		super();
		this.id=id;
		
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
	
}
