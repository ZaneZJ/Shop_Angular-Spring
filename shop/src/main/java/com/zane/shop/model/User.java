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
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "phone_no")
    private String phone_no;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "postal_code")
    private String postal_code;
    @Column(name = "picture_main")
    private String picture_main;
    @OneToMany(mappedBy = "picture_id")
    private Set<Pictures> picture_id;
    @OneToOne
    @JoinColumn(name = "account_no")
    private Bank account_no;
    @OneToMany(mappedBy = "service_id")
    private Set<Service> service_id;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private LoyaltyType type;
    @OneToOne
    @JoinColumn(name = "from_user_id")
    private Chat from_chat;
    @OneToOne
    @JoinColumn(name = "to_user_id")
    private Chat to_chat;
    @OneToOne
    @JoinColumn(name = "review_user_id")
    private Review review;

    public User(String username, String name, String surname, String phone_no, String address, String email, String postal_code, String picture_main, Set<Pictures> picture_id, Bank account_no, Set<Service> service_id, LoyaltyType type, Chat from_chat, Chat to_chat, Review review) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.phone_no = phone_no;
        this.address = address;
        this.email = email;
        this.postal_code = postal_code;
        this.picture_main = picture_main;
        this.picture_id = picture_id;
        this.account_no = account_no;
        this.service_id = service_id;
        this.type = type;
        this.from_chat = from_chat;
        this.to_chat = to_chat;
        this.review = review;
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

    public String getPhone_no() {
        return phone_no;
    }
    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
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

    public String getPostal_code() {
        return postal_code;
    }
    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getPicture_main() {
        return picture_main;
    }
    public void setPicture_main(String picture_main) {
        this.picture_main = picture_main;
    }

    public Set<Pictures> getPicture_id() {
        return picture_id;
    }
    public void setPicture_id(Set<Pictures> picture_id) {
        this.picture_id = picture_id;
    }

    public Bank getAccount_no() {
        return account_no;
    }
    public void setAccount_no(Bank account_no) {
        this.account_no = account_no;
    }

    public Set<Service> getService_id() {
        return service_id;
    }
    public void setService_id(Set<Service> service_id) {
        this.service_id = service_id;
    }

    public Chat getFrom_chat() {
        return from_chat;
    }
    public void setFrom_chat(Chat from_chat) {
        this.from_chat = from_chat;
    }

    public Chat getTo_chat() {
        return to_chat;
    }
    public void setTo_chat(Chat to_chat) {
        this.to_chat = to_chat;
    }

    public Review getReview() {
        return review;
    }
    public void setReview(Review review) {
        this.review = review;
    }

    public LoyaltyType getType() {
        return type;
    }
    public void setType(LoyaltyType type) {
        this.type = type;
    }
}
