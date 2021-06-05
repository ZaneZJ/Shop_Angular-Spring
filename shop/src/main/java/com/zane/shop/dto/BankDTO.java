package com.zane.shop.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class BankDTO {

    private String accountNo;

    @NotBlank(message = "beneficiary can not be null")
    private String beneficiary;

    @NotBlank(message = "bank can not be null")
    private String bank;


    public BankDTO() {}

    public String getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBeneficiary() {
        return beneficiary;
    }
    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getBank() {
        return bank;
    }
    public void setBank(String bank) {
        this.bank = bank;
    }

}
