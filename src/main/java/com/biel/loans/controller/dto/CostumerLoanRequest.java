package com.biel.loans.controller.dto;

import com.biel.loans.domain.Customer;

public record CostumerLoanRequest(Integer age, String cpf, String name, Double income, String location) {
    public Customer toCustomer() {
        return new Customer(age, cpf, name, income, location);
    }
}
