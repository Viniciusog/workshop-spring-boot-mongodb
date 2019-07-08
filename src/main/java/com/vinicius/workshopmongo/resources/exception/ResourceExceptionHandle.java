package com.vinicius.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vinicius.workshopmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandle {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

		HttpStatus stats = HttpStatus.NOT_FOUND;
		StandartError err = new StandartError(System.currentTimeMillis(), stats.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(stats).body(err);
	}
}
