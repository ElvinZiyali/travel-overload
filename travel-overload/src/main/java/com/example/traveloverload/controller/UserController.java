package com.example.traveloverload.controller;

import com.example.traveloverload.entity.User;
import com.example.traveloverload.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> get_all() {
        List<User> all = service.getAll();
        if (all.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(all, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get_one(@PathVariable long id) {
        User user = service.getById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @PutMapping("/save")
    public ResponseEntity<User> saveOrUpdate(@RequestBody User user) {
        User u = service.saveOrUpdate(user);
        if (u == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Long id) {
        service.deleteById(id);
    }


}
