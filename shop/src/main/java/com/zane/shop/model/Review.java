package com.zane.shop.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "review")
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;

    @Column
    @Length(min = 1, max = 5)
    private Integer rated;

    @Column
    private String reviewText;

    @Column
    private String userReviewFrom;

    @Column
    private String userReviewTo;

//    public Review(Long reviewId, Integer rated, String reviewText, User user) {
//        this.reviewId = reviewId;
//        this.rated = rated;
//        this.reviewText = reviewText;
//        this.user = user;
//    }

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

    public String getUserReviewFrom() {
        return userReviewFrom;
    }
    public void setUserReviewFrom(String userReviewFrom) {
        this.userReviewFrom = userReviewFrom;
    }

    public String getUserReviewTo() {
        return userReviewTo;
    }
    public void setUserReviewTo(String userReviewTo) {
        this.userReviewTo = userReviewTo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("reviewId", reviewId)
                .append("rated", rated)
                .append("reviewText", reviewText)
                .append("userReviewFrom", userReviewFrom)
                .append("userReviewTo", userReviewTo)
                .toString();
    }
}
