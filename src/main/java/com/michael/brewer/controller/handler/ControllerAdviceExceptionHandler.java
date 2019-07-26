package com.michael.brewer.controller.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.michael.brewer.service.exception.NomeEstiloJaCadastroException;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {

	@ExceptionHandler(NomeEstiloJaCadastroException.class)
	public ResponseEntity<String> handleNomeEstiloJaCadastroException(NomeEstiloJaCadastroException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
}
