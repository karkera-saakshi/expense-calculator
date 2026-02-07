package com.saakshi.expense_calculator.repositories;

import com.saakshi.expense_calculator.models.Owns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnsRepo extends JpaRepository<Owns,Integer> {
}
