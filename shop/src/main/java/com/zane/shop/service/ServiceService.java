package com.zane.shop.service;

import com.zane.shop.model.Service;
import com.zane.shop.model.User;
import com.zane.shop.repo.UserRepo;
import com.zane.shop.service.validator.ServiceValidator;
import com.zane.shop.service.validator.UserValidator;
import com.zane.shop.repo.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.logging.Logger;

@Component
public class ServiceService {

    private final UserRepo userRepo;
    private final ServiceRepo serviceRepo;
    private final ServiceValidator serviceValidator;
    private final UserValidator userValidator;
    private static Logger logger = Logger.getLogger("service");

    @Autowired
    public ServiceService(ServiceRepo serviceRepo, ServiceValidator serviceValidator, UserValidator userValidator, UserRepo userRepo) {
        this.serviceRepo = serviceRepo;
        this.serviceValidator = serviceValidator;
        this.userValidator = userValidator;
        this.userRepo = userRepo;
    }

    public List<Service> getAllServices() {
        return serviceRepo.findAll();
    }

    public List<Service> getAllServicesByTheme(String theme) {
        return serviceRepo.findByTheme(theme);
    }

    public List<Service> getAllServicesByTitle(String keyword) {
        return serviceRepo.findByTitleLike("%" + keyword + "%");
    }

    public Service saveService(Service service) {
        return serviceRepo.save(service);
    }

    public Service updateService(Service service) {
        serviceValidator.checkServiceExists(service.getServiceId());
        return serviceRepo.save(service);
    }

    public List<Service> filterService(Service service) {
        Example<Service> serviceExample = Example.of(service);
        return serviceRepo.findAll(serviceExample);
    }

    public Service addServiceToUser(String username, Service service) {
        User user = userValidator.checkUsernameExists(username);
        service.setUser(user);
        serviceRepo.save(service);
        return service;
    }

    public void removeServiceFromUser(String username, Long serviceId) {
        Service service = serviceValidator.checkServiceExists(serviceId);
        User user = userValidator.checkUsernameExists(username);
        user.getServices().remove(service);
        serviceRepo.delete(service);
        userRepo.save(user);
    }
}
