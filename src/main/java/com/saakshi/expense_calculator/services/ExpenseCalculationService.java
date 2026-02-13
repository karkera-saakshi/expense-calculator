package com.saakshi.expense_calculator.services;

import com.saakshi.expense_calculator.dto.CalculateRequestDto;
import com.saakshi.expense_calculator.dto.PersonDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ExpenseCalculationService {
    public Map<String,Double> calculateSplit(CalculateRequestDto request)
    {
        double totalAmount = request.getTotalAmount();
        List<PersonDto> people = request.getPeople();
        Map<String, Double> result = new HashMap<>();
        double totalPercentage = 0;
        for(PersonDto x: people)
        {
            totalPercentage += x.getPercentage();
        }
        if (totalPercentage!=100)
        {
            throw new IllegalArgumentException("Total percentage must be 100");
        }
        for(PersonDto person : people)
        {
            if(person.getName() == null || person.getName().isBlank())
            {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            double amount = (person.getPercentage()/100)*totalAmount;
            result.put(person.getName(), amount);
        }
        return result;
    }
}
