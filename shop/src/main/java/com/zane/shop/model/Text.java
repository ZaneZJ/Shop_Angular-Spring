package com.zane.shop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "text")
public class Text implements Serializable {

    // TODO: figure out how to make chat (can leave this to the end)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long text_id;
    @Column(name = "body")
    private String body;
    @Column(name = "create_time")
    private Date create_time;


    public Long getText_id() {
        return text_id;
    }
    public void setText_id(Long text_id) {
        this.text_id = text_id;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreate_time() {
        return create_time;
    }
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

}
