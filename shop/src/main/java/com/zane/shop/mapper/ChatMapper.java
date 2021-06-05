package com.zane.shop.mapper;

import com.zane.shop.dto.ChatDTO;
import com.zane.shop.model.Chat;
import org.springframework.stereotype.Component;

@Component
public class ChatMapper {

    public Chat fromDTO(ChatDTO chatDTO){
        Chat chat = new Chat();
        chat.setChatId(chatDTO.getChatId());
        chat.setFromUserId(chatDTO.getFromUserId());
        chat.setToUserId(chatDTO.getToUserId());
        return chat;
    }

    public ChatDTO toDTO(Chat chat){
        ChatDTO chatDTO = new ChatDTO();
        chatDTO.setChatId(chat.getChatId());
        chatDTO.setFromUserId(chat.getFromUserId());
        chatDTO.setToUserId(chat.getToUserId());
        return chatDTO;
    }
}
