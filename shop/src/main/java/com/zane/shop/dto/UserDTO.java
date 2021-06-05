package com.zane.shop.dto;

import com.zane.shop.constants.LoyaltyType;
import com.zane.shop.model.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

public class UserDTO {

    @Length(min = 4, max = 20)
    private String username;
    @NotBlank(message = "name can not be null")
    private String name;
    @NotBlank(message = "surname can not be null")
    private String surname;
    @Length(min = 8, max = 15)
    private String phoneNo;
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "address can not be null")
    private String address;
    @NotBlank(message = "postal code can not be null")
    private String postalCode;
    private String pictureMain;
    private Set<PicturesDTO> picturesDTOSet;
    @NotBlank(message = "account number can not be null")
    private Bank accountNo;
    private Set<ServiceDTO> serviceDTOSet;
    private LoyaltyType loyaltyType;


    public UserDTO() {}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPictureMain() {
        return pictureMain;
    }
    public void setPictureMain(String pictureMain) {
        this.pictureMain = pictureMain;
    }

    public Set<PicturesDTO> getPicturesDTOSet() {
        return picturesDTOSet;
    }
    public void setPicturesDTOSet(Set<PicturesDTO> picturesDTOSet) {
        this.picturesDTOSet = picturesDTOSet;
    }

    public Bank getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(Bank accountNo) {
        this.accountNo = accountNo;
    }

    public Set<ServiceDTO> getServiceDTOSet() {
        return serviceDTOSet;
    }
    public void setServiceDTOSet(Set<ServiceDTO> serviceDTOSet) {
        this.serviceDTOSet = serviceDTOSet;
    }

    public LoyaltyType getLoyaltyType() {
        return loyaltyType;
    }
    public void setLoyaltyType(LoyaltyType loyaltyType) {
        this.loyaltyType = loyaltyType;
    }
}
