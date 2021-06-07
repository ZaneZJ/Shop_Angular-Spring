package com.zane.shop.model;

import com.zane.shop.constants.LoyaltyType;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {

    // TODO: add hidden password
    // TODO: set upp roles

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

    @Length(min = 4, max = 20)
    private String username;

    @Column
    @NotBlank(message = "name can not be null")
    private String name;

    @Column
    @NotBlank(message = "surname can not be null")
    private String surname;

    @Column
    @Length(min = 8, max = 15)
    private String phoneNo;

    @Column
    @NotBlank(message = "address can not be null")
    private String address;

    @Column
    @Email(message = "Email should be valid")
    private String email;

    @Column
    @NotBlank(message = "postal code can not be null")
    private String postalCode;

    @Column
    private String pictureMain;

    @OneToMany(mappedBy = "pictureId")
    private Set<Pictures> pictures;

    @OneToOne
    @JoinColumn
    @NotBlank(message = "account number can not be null")
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

    public Long getUser_id() {
        return user_id;
    }
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

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
                .append("user_id", user_id)
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
