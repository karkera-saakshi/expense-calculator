package com.saakshi.expense_calculator.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owns {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
            @JoinColumn(name="user_id",nullable = false)
    User user;
    @Column(nullable = false)
    double amount;
    @Column(nullable = false)
    String category;
    @Column(nullable = false)
    boolean paid;
}
