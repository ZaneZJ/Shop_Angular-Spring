package com.zane.shop.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bank")
public class Bank implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long account_no;
    @Column(name = "beneficiary")
    private String beneficiary;
    @Column(name = "bank")
    private String bank;

    public Bank(Long account_no, String beneficiary, String bank) {
        this.account_no = account_no;
        this.beneficiary = beneficiary;
        this.bank = bank;
    }

    public Long getAccount_no() {
        return account_no;
    }
    public void setAccount_no(Long account_no) {
        this.account_no = account_no;
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
                .append("account_no", account_no)
                .append("beneficiary", beneficiary)
                .append("bank", bank)
                .toString();
    }
}
