package rest.with.spring.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import rest.with.spring.model.Book;

public interface BookRepository extends PagingAndSortingRepository<Book, Long>{

}
