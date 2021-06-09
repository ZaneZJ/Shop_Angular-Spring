package com.zane.shop.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "bank")
public class Bank implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    @Column
    @NotBlank(message = "account number can not be null")
    private String accountNo;

    @Column
    @NotBlank(message = "beneficiary can not be null")
    private String beneficiary;

    @Column
    @NotBlank(message = "bank can not be null")
    private String bank;

//    public Bank(Long accountNo, String beneficiary, String bank) {
//        this.accountNo = accountNo;
//        this.beneficiary = beneficiary;
//        this.bank = bank;
//    }

    public Long getAccountId() {
        return accountId;
    }
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("accountId", accountId)
                .append("accountNo", accountNo)
                .append("beneficiary", beneficiary)
                .append("bank", bank)
                .toString();
    }
}
