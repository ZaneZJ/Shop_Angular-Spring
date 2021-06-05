package com.zane.shop.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "text")
public class Text implements Serializable {

    // TODO: figure out how to make chat (can leave this to the end)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long textId;

    @Column
    private String body;

    @Column
    private Date createTime;

//    public Text(Long textId, String body, Date createTime) {
//        this.textId = textId;
//        this.body = body;
//        this.createTime = createTime;
//    }

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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("textId", textId)
                .append("body", body)
                .append("createTime", createTime)
                .toString();
    }
}
