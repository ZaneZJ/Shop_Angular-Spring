package com.zane.shop.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pictures")
public class Pictures implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long picture_id;
    @Column(name = "picture")
    private String picture;

    public Pictures(Long picture_id, String picture) {
        this.picture_id = picture_id;
        this.picture = picture;
    }

    public Long getPicture_id() {
        return picture_id;
    }
    public void setPicture_id(Long id) {
        this.picture_id = picture_id;
    }

    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }

}

