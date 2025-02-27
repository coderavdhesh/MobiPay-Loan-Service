package com.mobipay.loanserivce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobipay.loanserivce.model.LoanAccount;

@Repository
public interface LoanAccountRepository extends JpaRepository<LoanAccount, String> {
}