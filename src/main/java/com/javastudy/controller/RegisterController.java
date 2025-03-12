package com.javastudy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javastudy.dto.LoginRequest;
import com.javastudy.dto.RegisterRequest;
import com.javastudy.model.UserModel;
import com.javastudy.repository.UserRepository;
import com.javastudy.service.LoginService;

@RestController
@RequestMapping("/api/auth")
@Validated
public class RegisterController {
  
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private LoginService loginService;

  @PostMapping("/register")
  public ResponseEntity<Map<String, String>> register(@Validated @RequestBody RegisterRequest registerRequest, BindingResult bindingResult) {
    Map<String, String> response = new HashMap<>();
    
    if (bindingResult.hasErrors()) {
      bindingResult.getAllErrors().forEach(error -> response.put(error.getCode(), error.getDefaultMessage()));
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    if (userRepository.findByUsername(registerRequest.getUsername()) != null) {
      response.put("username", "Username is already taken.");
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    if (userRepository.findByEmail(registerRequest.getEmail()) != null) {
      response.put("email", "Email is already in use.");
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    String password = passwordEncoder.encode(registerRequest.getPassword());

    UserModel userModel = new UserModel();
    userModel.setEmail(registerRequest.getEmail());
    userModel.setUsername(registerRequest.getUsername());
    userModel.setPassword(password);

    userRepository.save(userModel);

    response.put("message", "User registred successfully.");
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @PostMapping("/login")
  public ResponseEntity<Map<String, String>> login(@Validated @RequestBody LoginRequest loginRequest, BindingResult bindingResult) {
    Map<String, String> response = new HashMap<>();
    
    if (bindingResult.hasErrors()) {
      bindingResult.getAllErrors().forEach(error -> response.put(error.getCode(), error.getDefaultMessage()));
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    boolean isAuthenticated = loginService.verifyPassword(loginRequest.getEmail(), loginRequest.getPassword());

    if (!isAuthenticated) {
      response.put("message", "Email or password is invalid.");
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
  }
}
