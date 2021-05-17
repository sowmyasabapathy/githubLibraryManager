/**
 * @author Sowmya Sabapathy
 *
 * Library Manager Project
 */
package com.librarymanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.librarymanager.model.Book;



@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	Optional<Book> findById(Long id);

	List<Book> findByName(String name);

	String deleteBookById(Long bookId);
	
	//Optional<Book> findById(Long id, boolean libraryUserData);

}
