package rest.with.spring.handler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import rest.with.spring.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?>handlerResourceNotFoundException(ResourceNotFoundException rfnException){
		
		ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.Builder
		 	.newBuilder()
		 	.title("Resource not found")
		 	.status(HttpStatus.NOT_FOUND.value())
		 	.detail(rfnException.getMessage())
		 	.timestamp(new Date().getTime())
		 	.developerMessage(rfnException.getClass().getName()).build();
		
		return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException manvException,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<FieldError> fieldsErrors = manvException.getBindingResult().getFieldErrors();
		String fields = fieldsErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
		String fieldsMessages = fieldsErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
		
		VadidationErrorDetails manvDetails = VadidationErrorDetails.Builder
		 	.newBuilder()
		 	.title("Fild Validation Error")
		 	.status(HttpStatus.BAD_REQUEST.value())
		 	.detail(manvException.getMessage())
		 	.timestamp(new Date().getTime())
		 	.developerMessage(manvException.getClass().getName())
		 	.field(fields)
		 	.fieldMessage(fieldsMessages).build();
		
		return new ResponseEntity<>(manvDetails, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.Builder
			 	.newBuilder()
			 	.title("Internal Exception")
			 	.status(status.value())
			 	.detail(ex.getMessage())
			 	.timestamp(new Date().getTime())
			 	.developerMessage(ex.getClass().getName()).build();
			
			return new ResponseEntity<>(rnfDetails, status);
	}
}
