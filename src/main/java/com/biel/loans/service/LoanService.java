package com.biel.loans.service;

import com.biel.loans.controller.dto.CostumerLoanRequest;
import com.biel.loans.controller.dto.CostumerLoanResponse;
import com.biel.loans.controller.dto.LoanResponse;
import com.biel.loans.domain.Loan;
import com.biel.loans.domain.LoanType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    public CostumerLoanResponse checkAvailability(CostumerLoanRequest costumerLoanRequest) {
        var customer = costumerLoanRequest.toCustomer();
        var loan = new Loan(customer);
        List<LoanResponse> loans = new ArrayList<>();

        addLoanIfEligible(loan, LoanType.PERSONAL, loans);
        addLoanIfEligible(loan, LoanType.GUARANTEED, loans);
        addLoanIfEligible(loan, LoanType.CONSIGNMENT, loans);

        return new CostumerLoanResponse(costumerLoanRequest.name(), loans);
    }

    private void addLoanIfEligible(Loan loan, LoanType loanType, List<LoanResponse> loans) {
        switch (loanType) {
            case PERSONAL:
                if (loan.isPersonalLoanEligible()) {
                    loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate()));
                }
                break;
            case GUARANTEED:
                if (loan.isGuaranteedLoanEligible()) {
                    loans.add(new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteedLoanInterestRate()));
                }
                break;
            case CONSIGNMENT:
                if (loan.isConsignmentLoanEligible()) {
                    loans.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsignmentLoanInterestRate()));
                }
                break;
        }
    }
}
