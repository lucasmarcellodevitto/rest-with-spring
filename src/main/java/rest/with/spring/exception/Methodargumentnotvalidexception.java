package rest.with.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class Methodargumentnotvalidexception extends RuntimeException {

	private static final long serialVersionUID = -6753769983152550783L;
	
	public Methodargumentnotvalidexception(String message) {
		super("Fild validation error");
	}
}
