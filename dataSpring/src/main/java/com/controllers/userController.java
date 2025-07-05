package com.controllers;

import java.lang.classfile.ClassFile.Option;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.repositories.UserRepository;
import com.models.Inventory;
import com.models.User;

  @CrossOrigin(origins = "*")
@RestController
public class userController {

  // ...

  private final UserRepository userRepository;

  public userController(UserRepository userRepository) {
    this.userRepository = userRepository;  
  }

  @GetMapping("/users")
  public Iterable<User> getAllUsers() {
    return this.userRepository.findAll();
  }

  @GetMapping("perms/{email}")
  public String getUserPerms(@PathVariable String email) {
    Optional<User> target = this.userRepository.findByEmail(email);
    String perms = "";
    if (target.isPresent()) {
      User foundTarget = target.get();
      perms = foundTarget.getUserType();

    }
    return perms;
  }

  @GetMapping("/userCount")
  public long getUserBase() {
    return this.userRepository.count();
  }

  @PostMapping("/users")
  public User addOneEmployee(@RequestBody User entity) {
    return userRepository.save(entity);
  }
}