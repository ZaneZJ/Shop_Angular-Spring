package com.zane.shop.mapper;

import com.zane.shop.dto.TextDTO;
import com.zane.shop.model.Text;
import org.springframework.stereotype.Component;

@Component
public class TextMapper {

    public Text fromDTO(TextDTO textDTO){
        Text text = new Text();
        text.setTextId(textDTO.getTextId());
        text.setBody(textDTO.getBody());
        text.setCreateTime(textDTO.getCreateTime());
        return text;
    }

    public TextDTO toDTO(Text text){
        TextDTO textDTO = new TextDTO();
        textDTO.setTextId(text.getTextId());
        textDTO.setBody(text.getBody());
        textDTO.setCreateTime(text.getCreateTime());
        return textDTO;
    }
}
