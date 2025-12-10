package com.Tasker.Tasker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Tasker.Tasker.service.AuthenticationService;
import com.Tasker.Tasker.service.dto.LoginDto;
import com.Tasker.Tasker.service.dto.RegistrationDto;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationService service;

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions(){
        return ResponseEntity.ok().build();
    }

    @PostMapping("/registration")
    public String registration(@RequestBody RegistrationDto dto){
        return service.registration(dto);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto dto){
        return service.login(dto);
    }
}