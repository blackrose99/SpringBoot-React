package com.proyectomomgo1.app.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 6518669326214254361L;

	public NotFoundException(String message) {
		super(message);
	}

}