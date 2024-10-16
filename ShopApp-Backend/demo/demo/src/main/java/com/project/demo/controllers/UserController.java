package com.project.demo.controllers;

import com.project.demo.dtos.requests.UserDTO;
import com.project.demo.dtos.requests.UserLoginDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserDTO userDTO , BindingResult bindingResult){
        try{
            if(bindingResult.hasErrors()){
                List<String> errorMessages = bindingResult.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
            }
            if(!userDTO.getPassword().equals(userDTO.getRetypePassword())){
                List<String> errorMessagePassword = new ArrayList<>();
                errorMessagePassword.add("Passwords do not match");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessagePassword.get(0));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Register successfully");
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginDTO userLoginDTO){
        // check token
        return ResponseEntity.status(HttpStatus.CREATED).body("some token");
    }
}

