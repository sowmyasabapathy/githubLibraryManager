/**
 * @author Sowmya Sabapathy
 *
 * Library Manager Project
 */
package com.librarymanager.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.librarymanager.model.Book;
import com.librarymanager.model.Librarian;
import com.librarymanager.model.User;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
	Optional<Librarian> findById(Long id);

	List<Librarian> findByUserId(Long user);

	 List<Librarian> findByBookId(Long book);

	//List<Librarian> findByBookId(Long bookid);
	 
	
	 @Query("select b from Book b where id= :book_id")
	 public Book getBook(long book_id);
	 
	 
	 @Query("select u from User u where id= :user_id")
	 public User getUser(long user_id);
	 

}
