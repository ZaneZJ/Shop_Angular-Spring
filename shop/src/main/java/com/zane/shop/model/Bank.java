package com.zane.shop.model;

import javax.persistence.*;

@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long account_no;
    @Column(name = "beneficiary")
    private String beneficiary;
    @Column(name = "bank")
    private String bank;


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

}
