package com.zane.shop.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "instance")
public class Instance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long insance_id;
    @Column(name = "price")
    private Double price;
    @Column(name = "time")
    private String time;
    @Column(name = "listed_as")
    private Integer listed_as;
    @Column(name = "info")
    private String info;

    public Instance(Long insance_id, Double price, String time, Integer listed_as, String info) {
        this.insance_id = insance_id;
        this.price = price;
        this.time = time;
        this.listed_as = listed_as;
        this.info = info;
    }

    public Long getInsance_id() {
        return insance_id;
    }
    public void setInsance_id(Long insance_id) {
        this.insance_id = insance_id;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public Integer getListed_as() {
        return listed_as;
    }
    public void setListed_as(Integer listed_as) {
        this.listed_as = listed_as;
    }

    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("insance_id", insance_id)
                .append("price", price)
                .append("time", time)
                .append("listed_as", listed_as)
                .append("info", info)
                .toString();
    }
}
