package com.zane.shop.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "service")
public class Service implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long serviceId;

    @OneToMany
    private Set<Instance> instances;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String theme;

    @OneToMany(mappedBy = "reviewId")
    private Set<Review> reviews;

    @OneToMany(mappedBy = "chatId")
    private Set<Chat> chats;

    public Service(Long serviceId, Set<Instance> instances, String title, String description, String theme, Set<Review> reviews, Set<Chat> chats) {
        this.serviceId = serviceId;
        this.instances = instances;
        this.title = title;
        this.description = description;
        this.theme = theme;
        this.reviews = reviews;
        this.chats = chats;
    }

    public Long getServiceId() {
        return serviceId;
    }
    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Set<Instance> getInstances() {
        return instances;
    }
    public void setInstances(Set<Instance> instances) {
        this.instances = instances;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Set<Review> getReviews() {
        return reviews;
    }
    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<Chat> getChats() {
        return chats;
    }
    public void setChats(Set<Chat> chats) {
        this.chats = chats;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("serviceId", serviceId)
                .append("instances", instances)
                .append("title", title)
                .append("description", description)
                .append("theme", theme)
                .append("reviews", reviews)
                .append("chats", chats)
                .toString();
    }
}
