package rest.with.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rest.with.spring.model.User;
import rest.with.spring.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Iterable<User> findAll(Pageable pageable) {
		return this.userRepository.findAll(pageable);
	}

	public User save(User book) {
		return this.userRepository.save(book);
	}

	public User update(User user) {
		return save(user);
	}

	public void delete(Long id) {
		this.userRepository.delete(id);;
	}
	
	public User findOne(Long id) {
		return this.userRepository.findOne(id);
	}

	public User findByUsername(String username) {
		
		return (User) this.userRepository.findByUsername(username);
	}
}
