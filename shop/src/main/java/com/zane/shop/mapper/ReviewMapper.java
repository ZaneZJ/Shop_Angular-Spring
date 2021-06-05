package com.zane.shop.mapper;

import com.zane.shop.dto.ReviewDTO;
import com.zane.shop.model.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public Review fromDTO(ReviewDTO reviewDTO){
        Review review = new Review();
        review.setReviewId(reviewDTO.getReviewId());
        review.setRated(reviewDTO.getRated());
        review.setReviewText(reviewDTO.getReviewText());
        review.setUsername(reviewDTO.getUsername());
        return review;
    }

    public ReviewDTO toDTO(Review review){
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setReviewId(review.getReviewId());
        reviewDTO.setRated(review.getRated());
        reviewDTO.setReviewText(review.getReviewText());
        reviewDTO.setUsername(review.getUsername());
        return reviewDTO;
    }
}
