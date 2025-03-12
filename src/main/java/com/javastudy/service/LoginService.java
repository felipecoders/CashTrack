package com.javastudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.javastudy.model.UserModel;
import com.javastudy.repository.UserRepository;

public class LoginService {
  
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public boolean verifyPassword(String email, String password) {
    UserModel userModel = userRepository.findByEmail(email);

    if (userModel == null) {
      return false;
    }

    return passwordEncoder.matches(password, userModel.getPassword());
  }

}
