/**
 * @author Sowmya Sabapathy
 *
 * Library Manager Project
 */
package com.librarymanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarymanager.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findById(Long id);

	List<User> findByName(String name);

}
