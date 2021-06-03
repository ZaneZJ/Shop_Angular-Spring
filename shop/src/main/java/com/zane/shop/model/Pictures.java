package com.zane.shop.model;

import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class Pictures {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long picture_id;
    @Column(name = "picture")
    private String picture;


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

