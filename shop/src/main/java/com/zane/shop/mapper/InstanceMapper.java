package com.zane.shop.mapper;

import com.zane.shop.dto.InstanceDTO;
import com.zane.shop.model.Instance;
import org.springframework.stereotype.Component;

@Component
public class InstanceMapper {

    public Instance fromDTO(InstanceDTO instanceDTO){
        Instance instance = new Instance();
        instance.setInstanceId(instanceDTO.getInstanceId());
        instance.setPrice(instanceDTO.getPrice());
        instance.setTime(instanceDTO.getTime());
        instance.setListedAs(instanceDTO.getListedAs());
        instance.setInfo(instanceDTO.getInfo());
        return instance;
    }

    public InstanceDTO toDTO(Instance instance){
        InstanceDTO instanceDTO = new InstanceDTO();
        instanceDTO.setInstanceId(instance.getInstanceId());
        instanceDTO.setPrice(instance.getPrice());
        instanceDTO.setTime(instance.getTime());
        instanceDTO.setListedAs(instance.getListedAs());
        instanceDTO.setInfo(instance.getInfo());
        return instanceDTO;
    }
}
