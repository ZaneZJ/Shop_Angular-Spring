package com.zane.shop.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "review")
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long review_id;
    @Column(name = "rated")
    private Integer rated;
    @Column(name = "review_text")
    private String review_text;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User review_from_user_id;


    public Long getReview_id() {
        return review_id;
    }
    public void setReview_id(Long review_id) {
        this.review_id = review_id;
    }

    public Integer getRated() {
        return rated;
    }
    public void setRated(Integer rated) {
        this.rated = rated;
    }

    public String getReview_text() {
        return review_text;
    }
    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    public User getReview_from_user_id() {
        return review_from_user_id;
    }
    public void setReview_from_user_id(User review_from_user_id) {
        this.review_from_user_id = review_from_user_id;
    }

}
