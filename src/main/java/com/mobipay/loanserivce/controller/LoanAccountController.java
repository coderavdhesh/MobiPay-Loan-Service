package com.mobipay.loanserivce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobipay.loanserivce.model.LoanAccount;
import com.mobipay.loanserivce.service.LoanAccountService;

@RestController
@RequestMapping("/loanaccount")
public class LoanAccountController {

    @Autowired
    private LoanAccountService loanAccountService;

    @GetMapping("/{loanAccountNumber}")
    public LoanAccount getLoanAccount(@PathVariable String loanAccountNumber) {
        return loanAccountService.getLoanAccountDetails(loanAccountNumber);
    }
}