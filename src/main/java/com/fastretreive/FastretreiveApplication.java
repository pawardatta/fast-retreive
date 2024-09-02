package com.fastretreive;

import com.fastretreive.entity.User;
import com.fastretreive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FastretreiveApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(FastretreiveApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Adding sample data
		userService.addUser(new User("Alice", "alice@example.com",25));
		userService.addUser(new User("Bob", "bob@example.com",30));
		userService.addUser(new User("Mark", "mark@example.com",27));
	}

}
