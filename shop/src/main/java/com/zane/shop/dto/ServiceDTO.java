package com.zane.shop.dto;

import com.zane.shop.constants.LoyaltyType;
import com.zane.shop.model.Bank;
import com.zane.shop.model.Chat;
import com.zane.shop.model.Review;
import com.zane.shop.model.User;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

public class ServiceDTO {

    private Long serviceId;

    private Set<InstanceDTO> instancesDTOSet;

    @NotBlank(message = "title can not be null")
    private String title;

    @NotBlank(message = "description can not be null")
    private String description;

    private String theme;

    private Set<ReviewDTO> reviewsDTOSet;

    private Set<ChatDTO> chatsDTOSet;

    private User username;


    public ServiceDTO() {}

    public Long getServiceId() {
        return serviceId;
    }
    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Set<InstanceDTO> getInstancesDTOSet() {
        return instancesDTOSet;
    }
    public void setInstancesDTOSet(Set<InstanceDTO> instancesDTOSet) {
        this.instancesDTOSet = instancesDTOSet;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Set<ReviewDTO> getReviewsDTOSet() {
        return reviewsDTOSet;
    }
    public void setReviewsDTOSet(Set<ReviewDTO> reviewsDTOSet) {
        this.reviewsDTOSet = reviewsDTOSet;
    }

    public Set<ChatDTO> getChatsDTOSet() {
        return chatsDTOSet;
    }
    public void setChatsDTOSet(Set<ChatDTO> chatsDTOSet) {
        this.chatsDTOSet = chatsDTOSet;
    }

    public User getUsername() {
        return username;
    }
    public void setUsername(User username) {
        this.username = username;
    }

}
