package rest.with.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestWithSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWithSpringApplication.class, args);
	}
}
