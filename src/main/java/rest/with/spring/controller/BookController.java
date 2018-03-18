package rest.with.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.with.spring.exception.ResourceNotFoundException;
import rest.with.spring.model.Book;
import rest.with.spring.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public ResponseEntity<?> findAll(Pageable pageable) {

		return new ResponseEntity<>(this.bookService.findAll(pageable), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {

		verifyIfBookExist(id);

		Book book = this.bookService.findOne(id);

		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Book book) {

		return new ResponseEntity<>(this.bookService.save(book), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> update(@Valid @RequestBody Book book) {

		return new ResponseEntity<>(this.bookService.update(book), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> datele(@PathVariable("id") Long id) {

		verifyIfBookExist(id);

		this.bookService.delete(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	private void verifyIfBookExist(Long id) {

		if (this.bookService.findOne(id) == null)
			throw new ResourceNotFoundException("Resource Not FoundException ID:" + id);

	}
}
