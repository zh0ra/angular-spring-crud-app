package org.zh0ra.micrositywebportalbackend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	private List<User> users = new ArrayList<>();

	public UserController() {
		this.users = createUsers();
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<User> getUsers() {
		if (this.users.size() == 0) {
			return Collections.emptyList();
		} else {
			return this.users;
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUser(int id) {
		return this.users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
	}

	@RequestMapping(method=RequestMethod.POST)
	public void userSave(@RequestBody User user) {
		Long 
	}

	List<User> createUsers() {
		List<User> users = new ArrayList<>();
		User u1 = createUser("zhora", "jsdlkfja", "Alex", "Zhorniak", "zhora@gmail.com");
		User u2 = createUser("mary", "jssdgaja", "Mery", "Zhorniak", "mery@gmail.com");
		User u3 = createUser("garry", "jeqrqfja", "Garry", "Trumen", "garry@gmail.com");
		users.add(u1);
		users.add(u2);
		users.add(u3);
		return users;
	}

	User createUser(String username, String password, String firstName, String lastName, String email) {
		User user = new User();
		user.setUsername(username);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);

		return user;
	}

}
