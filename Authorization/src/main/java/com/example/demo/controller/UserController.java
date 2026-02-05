package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.JwtRequest;
import com.example.demo.JwtResponse;
import com.example.demo.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins="*")
public class UserController {

	@Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;



	 @RequestMapping(value = "/getToken", method = RequestMethod.POST)
	 public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
	    	
	        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
	        
	        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
	        final String jwttoken = jwtTokenUtil.generateToken(userDetails);
	        System.out.println("Received request to generate token for "+authenticationRequest);
	        return ResponseEntity.ok(new JwtResponse(jwttoken));
	    }

	 

	    private void authenticate(String username, String password) throws Exception {
	        try {
	   
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	            
	        } catch (DisabledException e) {
	            throw new Exception("USER_DISABLED", e);
	        } catch (BadCredentialsException e) {
	            throw new Exception("INVALID_CREDENTIALS", e);
	        }
	    }
	    
	    @GetMapping("/getuname")
	    public String getUname(@RequestHeader("Authorization") String authorization) {
	        String token =authorization.substring(7);

	        return jwtTokenUtil.getUsernameFromToken(token);
	    }
}
