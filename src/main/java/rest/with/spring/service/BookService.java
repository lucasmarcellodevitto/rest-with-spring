package rest.with.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.with.spring.model.Book;
import rest.with.spring.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public Iterable<Book> findAll() {
		return this.bookRepository.findAll();
	}

	public Book save(Book book) {
		return this.bookRepository.save(book);
	}

	public Book update(Book book) {
		return save(book);
	}

	public void delete(Long id) {
		this.bookRepository.delete(id);;
	}
	
	public Book findOne(Long id) {
		return this.bookRepository.findOne(id);
	}
}
