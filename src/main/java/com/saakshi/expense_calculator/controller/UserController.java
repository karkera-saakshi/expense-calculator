package com.saakshi.expense_calculator.controller;

import com.saakshi.expense_calculator.dto.LoginDto;
import com.saakshi.expense_calculator.dto.PersonDto;
import com.saakshi.expense_calculator.models.User;
import com.saakshi.expense_calculator.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserRepo userRepo;

    @PostMapping("/register")
    public String register(@RequestBody User user)
    {
        userRepo.save(user);
        return "Signup Successful";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto)
    {
        User user = userRepo.findByUsername(loginDto.getUsername());
        if(user==null)
        {
            return "User not found";
        }
        if(!loginDto.getPassword().equals(user.getPassword()))
        {
            return "Password Incorrect";
        }
        return "Login SuccessFul...";
    }
    @PostMapping("/generate")
    public  void generate(@RequestBody PersonDto personDto)
    {

    }
}

