package com.biel.loans.controller.dto;

import com.biel.loans.domain.LoanType;

public record LoanResponse(LoanType type, Double interestRate) {
}
