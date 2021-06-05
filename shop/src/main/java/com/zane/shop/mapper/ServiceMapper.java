package com.zane.shop.mapper;

import com.zane.shop.dto.ServiceDTO;
import com.zane.shop.model.Service;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapper {

    public Service fromDTO(ServiceDTO serviceDTO){
        Service service = new Service();
        service.setServiceId(serviceDTO.getServiceId());
        service.setTitle(serviceDTO.getTitle());
        service.setDescription(serviceDTO.getDescription());
        service.setTheme(serviceDTO.getTheme());
        service.setUsername(serviceDTO.getUsername());
        return service;
    }

    public ServiceDTO toDTO(Service service){
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setServiceId(service.getServiceId());
        serviceDTO.setTitle(service.getTitle());
        serviceDTO.setDescription(service.getDescription());
        serviceDTO.setTheme(service.getTheme());
        serviceDTO.setUsername(service.getUsername());
        return serviceDTO;
    }
}
