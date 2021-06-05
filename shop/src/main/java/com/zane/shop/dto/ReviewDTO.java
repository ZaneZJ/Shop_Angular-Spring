package com.zane.shop.dto;

import com.zane.shop.model.User;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

public class ReviewDTO {

    private Long reviewId;

    @Length(min = 1, max = 5)
    private Integer rated;

    private String reviewText;

    @NotBlank(message = "username can not be null")
    private User username;


    public ReviewDTO() {}

    public Long getReviewId() {
        return reviewId;
    }
    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getRated() {
        return rated;
    }
    public void setRated(Integer rated) {
        this.rated = rated;
    }

    public String getReviewText() {
        return reviewText;
    }
    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public User getUsername() {
        return username;
    }
    public void setUsername(User username) {
        this.username = username;
    }

}
