package com.saakshi.expense_calculator.models;

import com.saakshi.expense_calculator.enums.Direction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

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
    @Enumerated(EnumType.STRING)
    Direction direction;
    String otherPartyName;
    @Column(nullable = false)
    double amount;
    @Column(nullable = false)
    boolean isPaid;
    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    LocalDateTime createdAt;
}
