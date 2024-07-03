package com.mobipay.loanserivce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mobipay.loanserivce.model.LoanAccount;
import com.mobipay.loanserivce.repository.LoanAccountRepository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Service
public class LoanAccountService {

    @Autowired
    private LoanAccountRepository loanAccountRepository;

    public LoanAccount getLoanAccountDetails(String loanAccountNumber) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://demo0951179.mockable.io/loanaccount/" + loanAccountNumber;
        LoanAccountDTO loanAccountDTO = restTemplate.getForObject(url, LoanAccountDTO.class);
        
        LoanAccount loanAccount = new LoanAccount(
                loanAccountDTO.getLoanAccountNumber(),
                loanAccountDTO.getDueDate(),
                loanAccountDTO.getEmiAmount()
        );
        loanAccountRepository.save(loanAccount);
        return loanAccount;
    }

    @Data
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class LoanAccountDTO {
        private String loanAccountNumber;
        private String dueDate;
        private int emiAmount;

        // getters and setters
        public String getLoanAccountNumber() {
            return loanAccountNumber;
        }

        public void setLoanAccountNumber(String loanAccountNumber) {
            this.loanAccountNumber = loanAccountNumber;
        }

        public String getDueDate() {
            return dueDate;
        }

        public void setDueDate(String dueDate) {
            this.dueDate = dueDate;
        }

        public int getEmiAmount() {
            return emiAmount;
        }

        public void setEmiAmount(int emiAmount) {
            this.emiAmount = emiAmount;
        }
    }
}