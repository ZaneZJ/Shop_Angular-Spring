package com.zane.shop.mapper;

import com.zane.shop.dto.BankDTO;
import com.zane.shop.model.Bank;
import org.springframework.stereotype.Component;

@Component
public class BankMapper {

    public Bank fromDTO(BankDTO bankDTO){
        Bank bank = new Bank();
        bank.setAccountNo(bankDTO.getAccountNo());
        bank.setBeneficiary(bankDTO.getBeneficiary());
        bank.setBank(bankDTO.getBank());
        return bank;
    }

    public BankDTO toDTO(Bank bank){
        BankDTO bankDTO = new BankDTO();
        bankDTO.setAccountNo(bank.getAccountNo());
        bankDTO.setBeneficiary(bank.getBeneficiary());
        bankDTO.setBank(bank.getBank());
        return bankDTO;
    }
}
