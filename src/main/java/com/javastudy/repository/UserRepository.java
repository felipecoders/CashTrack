package com.javastudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javastudy.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
  UserModel findByUsername(String username);
  UserModel findByEmail(String email);
}
