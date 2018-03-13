package rest.with.spring.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import rest.with.spring.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	Object findByUsername(String username);

}
