package com.biel.loans.domain;

public class Loan {

    private Customer customer;

    public Loan(Customer customer) {
        this.customer = customer;
    }

    // Método auxiliar para verificar se o cliente é elegível para empréstimo pessoal
    public boolean isPersonalLoanEligible() {
        double income = customer.getIncome();
        int age = customer.getAge();

        return income <= 3000.0 || (income >= 5000.0 && age < 30);
    }

    // Método auxiliar para verificar se o cliente é elegível para empréstimo garantido
    public boolean isGuaranteedLoanEligible() {
        double income = customer.getIncome();
        return income >= 5000.0;
    }

    // Método auxiliar para verificar se o cliente é elegível para empréstimo consignado
    public boolean isConsignmentLoanEligible() {
        double income = customer.getIncome();
        int age = customer.getAge();
        return income <= 3000.0 && age >= 50;
    }

    // Método para obter a taxa de juros do empréstimo pessoal
    public double getPersonalLoanInterestRate() {
        String location = customer.getLocation();
        if (isPersonalLoanEligible()) {
            if (location.equals("SP"))
                return 3.0;
            return 4.0;
        } else {
            throw new RuntimeException("Personal loan not available for this customer.");
        }


    }

    // Método para obter a taxa de juros do empréstimo garantido
    public double getGuaranteedLoanInterestRate() {
        String location = customer.getLocation();
        if (isGuaranteedLoanEligible()) {
            if (location.equals("SP"))
                return 2.5;
            return 3.0;
        } else {
            throw new RuntimeException("Guaranteed loan not available for this customer.");
        }
    }

    // Método para obter a taxa de juros do empréstimo consignado
    public double getConsignmentLoanInterestRate() {
        String location = customer.getLocation();
        if (isConsignmentLoanEligible()) {
            if (location.equals("SP"))
                return 1.5;
            return 2.0;
        } else {
            throw new RuntimeException("Consignment loan not available for this customer.");
        }
    }
}

