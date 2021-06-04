package com.zane.shop.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "review")
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;

    @Column
    private Integer rated;

    @Column
    private String reviewText;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    public Review(Long reviewId, Integer rated, String reviewText, User user) {
        this.reviewId = reviewId;
        this.rated = rated;
        this.reviewText = reviewText;
        this.user = user;
    }

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

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("reviewId", reviewId)
                .append("rated", rated)
                .append("reviewText", reviewText)
                .append("user", user)
                .toString();
    }
}
