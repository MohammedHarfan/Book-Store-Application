package com.store.controller;

import com.store.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class InternalApiController {

    private UserService userService;

    public InternalApiController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/internal/make-admin/{username}")
    public ResponseEntity<?> makeAdmin(@PathVariable String username) {
        userService.makeAdmin(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
