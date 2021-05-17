/**
 * @author Sowmya Sabapathy
 *
 * Library Manager Project
 */
package com.librarymanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.librarymanager.model.User;
import com.librarymanager.repository.UserRepository;



@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	// save users
	@PostMapping(value = "/user/save")
	public List<User> createUsers(@RequestBody User user) {
		userRepository.save(user);
		return userRepository.findAll();

	}
	
	@GetMapping(value = "/user/all")
    public List<User> getAll() {
        return userRepository.findAll();
    }
    
    
    @GetMapping(path = "/user/{id}")
    public User getOneUser(@PathVariable(value = "id") Long id) {
        return userRepository.findById(id).get();
    }
    
    @GetMapping(path = "/user/username/{name}")
    public List<User> getByName(@PathVariable(name="name") String name) {
        return userRepository.findByName(name);
    }

}
