package com.zane.shop.dto;

import com.zane.shop.model.Text;
import com.zane.shop.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

public class ChatDTO {

    private Long chatId;

    @NotBlank(message = "from user code can not be null")
    private User fromUserId;

    @NotBlank(message = "to user can not be null")
    private User toUserId;

    @NotBlank(message = "texts can not be null")
    private Set<TextDTO> textsDTOSet;

    public ChatDTO() {}

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

    public Set<TextDTO> getTextsDTOSet() {
        return textsDTOSet;
    }
    public void setTextsDTOSet(Set<TextDTO> textsDTOSet) {
        this.textsDTOSet = textsDTOSet;
    }

}
