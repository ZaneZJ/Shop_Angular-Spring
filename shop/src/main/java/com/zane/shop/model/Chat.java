package com.zane.shop.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "chat")
public class Chat {

    // TODO: figure out how to make chat

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chat_id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User from_user_id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User to_user_id;
    @OneToMany(mappedBy = "text_id")
    private Set<Text> text_id;


    public Long getChat_id() {
        return chat_id;
    }
    public void setChat_id(Long chat_id) {
        this.chat_id = chat_id;
    }

    public User getFrom_user_id() {
        return from_user_id;
    }
    public void setFrom_user_id(User from_user_id) {
        this.from_user_id = from_user_id;
    }

    public User getTo_user_id() {
        return to_user_id;
    }
    public void setTo_user_id(User to_user_id) {
        this.to_user_id = to_user_id;
    }

    public Set<Text> getText_id() {
        return text_id;
    }
    public void setText_id(Set<Text> text_id) {
        this.text_id = text_id;
    }

}

