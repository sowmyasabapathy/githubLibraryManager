/**
 * @author Sowmya Sabapathy
 *
 * Library Manager Project
 */
package com.librarymanager.controller;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.librarymanager.model.Book;
import com.librarymanager.model.Librarian;
import com.librarymanager.model.User;
import com.librarymanager.repository.LibrarianRepository;




@RestController
public class LibrarianController {
	
	@Autowired
	LibrarianRepository librarianRepository;

	@PostMapping(value = "/librarian/book/user/{book_id}/{user_id}")
	public Librarian createLibrarian(@PathVariable ("book_id") long book_id, 
			@PathVariable("user_id") long user_id ,
			@RequestBody Librarian librarian) {
		
		Book book =librarianRepository.getBook(book_id);
		User user = librarianRepository.getUser(user_id);
		
		librarian.setBook(book);
		librarian.setUser(user);
		
		
		LocalDate issueDate = new LocalDate(librarian.getBook_issue_date());
		LocalDate returnDate =issueDate.plusDays(7);
		librarian.setBook_return_date(returnDate.toString());
				
		return librarianRepository.save(librarian);
	}
	
	@PutMapping(value="/librarian/update/{id}")
	public Librarian updateBookReturnDate(@PathVariable ("id") long id, 
			@RequestBody Librarian librarian ) {
		
		
		
		Librarian libraryDetails =  librarianRepository.findById(id).get();
		
		
		
		librarian.setBook(libraryDetails.getBook());
		librarian.setUser(libraryDetails.getUser());
		librarian.setBook_issue_date(libraryDetails.getBook_issue_date());
		librarian.setBook_return_date(librarian.getBook_return_date());
		
		librarianRepository.deleteById(id);
		return librarianRepository.save(librarian);
		
		}

	@GetMapping(value = "/librarian/all")
	public List<Librarian> getAll() {
		
		
		return librarianRepository.findAll();
	}

	@GetMapping(path = "/librarian/user/{id}")
	public List<Librarian> getUser(@PathVariable(value = "id") Long id) {
		return librarianRepository.findByUserId(id);
	}

	@GetMapping(path = "/librarian/books/{id}")
	public List<Librarian> getBooks(@PathVariable(value = "id") Long id) {
		return librarianRepository.findByBookId(id);
	}
	
	@DeleteMapping(path="/librarian/{id}")
	public String deleteLibrarians(@PathVariable(value="id") Long id){
		
		librarianRepository.deleteById(id);
		return "Deleted the entry from Library Manager";
		
		
		
	}

}
