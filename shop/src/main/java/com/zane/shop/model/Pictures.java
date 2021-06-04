package com.zane.shop.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pictures")
public class Pictures implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pictureId;

    @Column
    private String picture;

    public Pictures(Long pictureId, String picture) {
        this.pictureId = pictureId;
        this.picture = picture;
    }

    public Long getPictureId() {
        return pictureId;
    }
    public void setPictureId(Long id) {
        this.pictureId = pictureId;
    }

    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("pictureId", pictureId)
                .append("picture", picture)
                .toString();
    }
}

