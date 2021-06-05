package com.zane.shop.model;

import com.zane.shop.constants.LoyaltyType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {

    // TODO: add hidden password
    // TODO: set upp roles

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String phoneNo;

    @Column
    private String address;

    @Column
    private String email;

    @Column
    private String postalCode;

    @Column
    private String pictureMain;

    @OneToMany(mappedBy = "pictureId")
    private Set<Pictures> pictures;

    @OneToOne
    @JoinColumn
    private Bank accountNo;

    @OneToMany(mappedBy = "serviceId")
    private Set<Service> services;

    @Column
    @Enumerated(EnumType.STRING)
    private LoyaltyType loyaltyType;

    @Column
    private String status;


//    public User(String username, String name, String surname, String phoneNo, String address, String email, String postalCode, String pictureMain, Set<Pictures> pictures, Bank accountNo, Set<Service> services, LoyaltyType type) {
//        this.username = username;
//        this.name = name;
//        this.surname = surname;
//        this.phoneNo = phoneNo;
//        this.address = address;
//        this.email = email;
//        this.postalCode = postalCode;
//        this.pictureMain = pictureMain;
//        this.pictures = pictures;
//        this.accountNo = accountNo;
//        this.services = services;
//        this.type = type;
//    }

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

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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

    public Set<Pictures> getPictures() {
        return pictures;
    }
    public void setPictures(Set<Pictures> pictures) {
        this.pictures = pictures;
    }

    public Bank getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(Bank accountNo) {
        this.accountNo = accountNo;
    }

    public Set<Service> getServices() {
        return services;
    }
    public void setServices(Set<Service> services) {
        this.services = services;
    }

    public LoyaltyType getLoyaltyType() {
        return loyaltyType;
    }
    public void setLoyaltyType(LoyaltyType loyaltyType) {
        this.loyaltyType = loyaltyType;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang.builder.ToStringBuilder(this)
                .append("username", username)
                .append("name", name)
                .append("surname", surname)
                .append("phoneNo", phoneNo)
                .append("address", address)
                .append("email", email)
                .append("postalCode", postalCode)
                .append("pictureMain", pictureMain)
                .append("pictures", pictures)
                .append("accountNo", accountNo)
                .append("services", services)
                .append("loyaltyType", loyaltyType)
                .append("status", status)
                .toString();
    }
}
