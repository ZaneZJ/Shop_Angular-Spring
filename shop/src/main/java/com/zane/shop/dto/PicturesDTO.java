package com.zane.shop.dto;

import com.zane.shop.constants.LoyaltyType;
import com.zane.shop.model.Bank;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

public class PicturesDTO {

    private Long pictureId;

    @NotBlank(message = "picture can not be null")
    private String picture;


    public PicturesDTO() {}

    public Long getPictureId() {
        return pictureId;
    }
    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }

}
