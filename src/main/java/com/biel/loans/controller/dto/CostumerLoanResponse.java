package com.biel.loans.controller.dto;

import java.util.List;

public record CostumerLoanResponse(String customer, List<LoanResponse> loans) {

}
