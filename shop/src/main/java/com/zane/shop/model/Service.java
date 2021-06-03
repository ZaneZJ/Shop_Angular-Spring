package com.zane.shop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "service")
public class Service implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long service_id;
    @OneToMany(mappedBy = "instance_id")
    private Set<Instance> instance_id;
    @Column(name = "title")
    private String title;
    @Column(name = "abstractt")
    private String abstractt;
    @Column(name = "theme")
    private String theme;
    @OneToMany(mappedBy = "review_id")
    private Set<Review> review_id;
    @OneToMany(mappedBy = "chat_id")
    private Set<Chat> chat_id;


    public Long getService_id() {
        return service_id;
    }
    public void setService_id(Long service_id) {
        this.service_id = service_id;
    }

    public Set<Instance> getInstance_id() {
        return instance_id;
    }
    public void setInstance_id(Set<Instance> instance_id) {
        this.instance_id = instance_id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstractt() {
        return abstractt;
    }
    public void setAbstractt(String abstractt) {
        this.abstractt = abstractt;
    }

    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Set<Review> getReview_id() {
        return review_id;
    }
    public void setReview_id(Set<Review> review_id) {
        this.review_id = review_id;
    }

    public Set<Chat> getChat_id() {
        return chat_id;
    }
    public void setChat_id(Set<Chat> chat_id) {
        this.chat_id = chat_id;
    }
}
