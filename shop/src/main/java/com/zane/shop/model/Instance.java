package com.zane.shop.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "instance")
public class Instance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long instanceId;

    @Column
    private Double price;

    @Column
    private String time;

    @Column
    private Integer listedAs;

    @Column
    private String info;

    public Instance(Long instanceId, Double price, String time, Integer listedAs, String info) {
        this.instanceId = instanceId;
        this.price = price;
        this.time = time;
        this.listedAs = listedAs;
        this.info = info;
    }

    public Long getInstanceId() {
        return instanceId;
    }
    public void setInstanceId(Long instanceId) {
        this.instanceId = instanceId;
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

    public Integer getListedAs() {
        return listedAs;
    }
    public void setListedAs(Integer listedAs) {
        this.listedAs = listedAs;
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
                .append("instanceId", instanceId)
                .append("price", price)
                .append("time", time)
                .append("listedAs", listedAs)
                .append("info", info)
                .toString();
    }
}
