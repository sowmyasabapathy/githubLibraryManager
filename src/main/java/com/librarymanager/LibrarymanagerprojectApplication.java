/**
 * @author Sowmya Sabapathy
 *
 * Library Manager Project
 */
package com.librarymanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.librarymanager.repository")
public class LibrarymanagerprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarymanagerprojectApplication.class, args);
	}

}
