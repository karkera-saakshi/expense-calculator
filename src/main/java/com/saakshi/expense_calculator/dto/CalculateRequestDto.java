package com.saakshi.expense_calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculateRequestDto {
    double totalAmount;
    List<PersonDto> people;
}
