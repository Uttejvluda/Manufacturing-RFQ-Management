package com.example.demo.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.JwtResponse;
import com.example.demo.model.User;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class MainControllerAdvice {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@ExceptionHandler
	public ResponseEntity<JwtResponse> loginException(BadCredentialsException e){
		log.info("Bad Credential Exceptions");
		return ResponseEntity.badRequest().body(new JwtResponse("Invalid"));
	}
	
	@ExceptionHandler
	public ResponseEntity<User> loginException(SQLIntegrityConstraintViolationException e){
		log.info("SQL Integrity Constraints Violations Exception");
		return ResponseEntity.badRequest().body(null);
	}

}
