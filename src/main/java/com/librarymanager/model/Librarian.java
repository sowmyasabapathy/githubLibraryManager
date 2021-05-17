/**
 * @author Sowmya Sabapathy
 *
 * Library Manager Project
 */
package com.librarymanager.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name="Librarian")
public class Librarian {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="book_id", referencedColumnName = "id")
	private Book book;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id", referencedColumnName = "id")
	private User user;
	
	String book_issue_date;
	
	String book_return_date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBook_issue_date() {
		return book_issue_date;
	}

	public void setBook_issue_date(String book_issue_date) {
		this.book_issue_date = book_issue_date;
	}

	public String getBook_return_date() {
		return book_return_date;
	}

	public void setBook_return_date(String book_return_date) {
		this.book_return_date = book_return_date;
	}

	

	

	
	
	
}
