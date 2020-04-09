package br.com.ogawadev.bluetasks.web;

import org.springframework.data.rest.core.RepositoryConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.ogawadev.bluetasks.domain.task.DuplicatedTaskException;

@RestControllerAdvice
public class WebRequestExceptionHandler {
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public RestResponseError handlerException(RepositoryConstraintViolationException e) {
		return RestResponseError.fromValidationError(e.getErrors());
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public RestResponseError handlerException(DuplicatedTaskException e) {
		return RestResponseError.fromMessage(e.getMessage());
	}
}
