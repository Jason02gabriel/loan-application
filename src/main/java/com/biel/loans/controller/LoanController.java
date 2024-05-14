package com.biel.loans.controller;
import com.biel.loans.service.LoanService;
import com.biel.loans.controller.dto.CostumerLoanRequest;
import com.biel.loans.controller.dto.CostumerLoanResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/loans")
    public CostumerLoanResponse loan(@RequestBody CostumerLoanRequest costumerLoanRequest) {
        var loanResponse = loanService.checkAvailability(costumerLoanRequest);
        return loanResponse;
    }
}
