package com.saakshi.expense_calculator.controller;

import com.saakshi.expense_calculator.dto.CalculateRequestDto;
import com.saakshi.expense_calculator.dto.LoginDto;
import com.saakshi.expense_calculator.dto.PersonDto;
import com.saakshi.expense_calculator.models.User;
import com.saakshi.expense_calculator.repositories.UserRepo;
import com.saakshi.expense_calculator.services.ExpenseCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) throws Exception {
        User user = userRepo.findByUsername(loginDto.getUsername());
        if (user == null) {
            // Return plain text message, status 401
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        }

        if (!user.getPassword().equals(loginDto.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password");
        }

        return ResponseEntity.ok("Login successful");
    }
    @Autowired
    ExpenseCalculationService expenseCalculationService;
    @PostMapping("/calculate")
    public Map<String, Double> generate(@RequestBody CalculateRequestDto requestDto)
    {
        return expenseCalculationService.calculateSplit(requestDto);
    }
}

