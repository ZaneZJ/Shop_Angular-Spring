package com.zane.shop.model;

import com.zane.shop.constants.LoyaltyType;
import com.zane.shop.constants.UserRole;
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
    private Long userId;

    @Column(unique = true)
    @Length(min = 4, max = 20)
    private String username;

    @Column
    @NotBlank(message = "name can not be null")
    private String name;

    @Column
    @NotBlank(message = "surname can not be null")
    private String surname;

    @Column(unique = true)
    @Length(min = 8, max = 15)
    private String phoneNo;

    @Column
    @NotBlank(message = "address can not be null")
    private String address;

    @Column(unique = true)
    @Email(message = "Email should be valid")
    private String email;

    @Column
    @NotBlank(message = "postal code can not be null")
    private String postalCode;

    @Column
    private String pictureMain;

//    adds new bank with the details
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Bank bank;

    @OneToMany(mappedBy = "serviceId")
    private Set<Service> services;

    @Column
    @Enumerated(EnumType.STRING)
    private LoyaltyType loyaltyType;

    @Column
    private String status;

    @Column
    @NotBlank(message = "password can not be null")
    private String password;

    @Column(length = 32, columnDefinition = "varchar(32) default 'USER'")
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

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

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Bank getBank() {
        return bank;
    }
    public void setBank(Bank bank) {
        this.bank = bank;
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

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() { return role; }
    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang.builder.ToStringBuilder(this)
                .append("userId", userId)
                .append("username", username)
                .append("name", name)
                .append("surname", surname)
                .append("phoneNo", phoneNo)
                .append("address", address)
                .append("email", email)
                .append("postalCode", postalCode)
                .append("pictureMain", pictureMain)
                .append("bank", bank)
                .append("services", services)
                .append("loyaltyType", loyaltyType)
                .append("status", status)
                .append("password", password)
                .append("role", role)
                .toString();
    }
}
