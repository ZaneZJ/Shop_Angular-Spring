package com.zane.shop.dto;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class InstanceDTO {

    private Long instanceId;

    @Length(min = 0)
    private Double price;

    @NotBlank(message = "time can not be null")
    private String time;

    @Length(min = 1, max = 5)
    private Integer listedAs;

    @NotBlank(message = "info can not be null")
    private String info;


    public InstanceDTO() {}

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

}
