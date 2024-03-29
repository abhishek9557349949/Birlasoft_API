package com.example.demo.controller;

import com.example.demo.entity.LoginData;
import com.example.demo.exceptions.ControllerException;
import com.example.demo.exceptions.ServiceException;
import com.example.demo.lookupservices.LookupServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/session")
public class UserController {

    @Autowired
    private LookupServicesImpl lookupServices;

    @PostMapping("/login")
    public LoginData sessionLogin(@RequestBody LoginData loginData) {
        try {
            return lookupServices.getLoginDetails(loginData);
        } catch (Exception e) {
            throw new ControllerException("Error processing login request: " + e.getMessage());
        }
    }

    @PostMapping("/signup")
    public LoginData sessionSignup(@RequestBody LoginData loginData) {
        try {
            return lookupServices.signupRequest(loginData);
        } catch (Exception e) {
            throw new ControllerException("Error processing signup request: " + e.getMessage());
        }
    }
}
