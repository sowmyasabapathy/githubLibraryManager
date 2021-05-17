/**
 * @author Sowmya Sabapathy
 *
 * Library Manager Project
 */
package com.librarymanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.librarymanager.model.Book;
import com.librarymanager.model.Librarian;
import com.librarymanager.model.User;
import com.librarymanager.repository.BookRepository;
import com.librarymanager.repository.LibrarianRepository;

@RestController
public class BookController {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	LibrarianRepository librarianRepository;

	// save books
	@PostMapping(value = "/book/save")
	public List<Book> createBook(@RequestBody Book book) {
		bookRepository.save(book);
		return bookRepository.findAll();
	}

	// update books
	@PutMapping(value = "/book/save")
	public List<Book> updateBook(@RequestBody Book incomingBook) {
		bookRepository.save(incomingBook);
		return bookRepository.findAll();
	}

	// get all books
	@GetMapping(value = "/book/all")
	public List<Book> getAllBooks() {
		return bookRepository.findAll();

	}

	//get books by id
	@GetMapping(value = "/book/{id}")
	public Book findBookById(@PathVariable(value = "id") Long id) {
	 return bookRepository.findById(id).get();

	}

	// get book by name
	@GetMapping(value = "/book/bookname/{name}")
	public List<Book> findBookByName(@PathVariable(value = "name") String name) {
		return bookRepository.findByName(name);
	}

	// delete books
	@DeleteMapping(value = "/book/{bookId}")
	public String deleteBookById(@PathVariable Long bookId) {
		bookRepository.deleteById(bookId);
		return "Deleted Successfully";
	}

	
}
