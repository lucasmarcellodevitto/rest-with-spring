package rest.with.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.with.spring.exception.ResourceNotFoundException;
import rest.with.spring.model.User;
import rest.with.spring.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<?> findAll(Pageable pageable) {

		return new ResponseEntity<>(this.userService.findAll(pageable), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{username}")
	public ResponseEntity<?> findByUsername(@PathVariable("username") String username) {

		verifyIfUserExist(username);
		
		User user = this.userService.findByUsername(username);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody User user) {

		return new ResponseEntity<>(this.userService.save(user), HttpStatus.OK);
	}

	private void verifyIfUserExist(String username) {

		if (this.userService.findByUsername(username) == null)
			throw new ResourceNotFoundException("Resource Not FoundException ID:" + username);

	}
	
}
