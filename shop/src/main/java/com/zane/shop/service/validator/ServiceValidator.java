package com.zane.shop.service.validator;

import com.zane.shop.exception.EmailAlreadyExistsException;
import com.zane.shop.exception.EntityDoesNotExistsException;
import com.zane.shop.model.Service;
import com.zane.shop.model.User;
import com.zane.shop.repo.ServiceRepo;
import com.zane.shop.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ServiceValidator {

    private final ServiceRepo serviceRepo;

    @Autowired
    public ServiceValidator(ServiceRepo serviceRepo) {
        this.serviceRepo = serviceRepo;
    }

    public Service checkServiceExists(Long serviceId) {
        Optional<Service> serviceFromDBOpt = serviceRepo.findById(serviceId);
        return serviceFromDBOpt.orElseThrow(() ->
                new EntityDoesNotExistsException("Book: (" + serviceId
                        + ") not exists!"));
    }

}
