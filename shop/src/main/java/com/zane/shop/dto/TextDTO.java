package com.zane.shop.dto;

import com.zane.shop.model.User;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

public class TextDTO {

    private Long textId;

    @NotBlank(message = "body can not be null")
    private String body;

    @NotBlank(message = "createTime can not be null")
    private Date createTime;

    public TextDTO() {}

    public Long getTextId() {
        return textId;
    }
    public void setTextId(Long textId) {
        this.textId = textId;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
