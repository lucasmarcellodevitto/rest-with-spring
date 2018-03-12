package rest.with.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import rest.with.spring.model.User;
import rest.with.spring.service.UserService;

@SpringBootApplication
//@EnableEurekaClient
public class RestWithSpringApplication {

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		
		SpringApplication.run(RestWithSpringApplication.class, args);
	}
	
	@Bean
	public boolean setUser() {
		 userService.save(new User("Lucas", true, "lu_devitto", "123456"));
		return true;
	}
}
