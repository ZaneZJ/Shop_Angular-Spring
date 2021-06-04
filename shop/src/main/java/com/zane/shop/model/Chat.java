package com.zane.shop.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "chat")
public class Chat implements Serializable {

    // TODO: figure out how to make chat

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long chatId;

    @OneToOne
    @JoinColumn
    private User fromUserId;

    @OneToOne
    @JoinColumn
    private User toUserId;

    @OneToMany(mappedBy = "textId")
    private Set<Text> texts;

    public Chat(Long chatId, User fromUserId, User toUserId, Set<Text> texts) {
        this.chatId = chatId;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.texts = texts;
    }

    public Long getChatId() {
        return chatId;
    }
    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public User getFromUserId() {
        return fromUserId;
    }
    public void setFromUserId(User fromUserId) {
        this.fromUserId = fromUserId;
    }

    public User getToUserId() {
        return toUserId;
    }
    public void setToUserId(User toUserId) {
        this.toUserId = toUserId;
    }

    public Set<Text> getTexts() {
        return texts;
    }
    public void setTexts(Set<Text> texts) {
        this.texts = texts;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("chatId", chatId)
                .append("fromUserId", fromUserId)
                .append("toUserId", toUserId)
                .append("texts", texts)
                .toString();
    }
}

