package rest.with.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rest.with.spring.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
