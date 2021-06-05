package com.zane.shop.service;

import com.zane.shop.model.Service;
import com.zane.shop.model.User;
import com.zane.shop.service.validator.ServiceValidator;
import com.zane.shop.service.validator.UserValidator;
import com.zane.shop.repo.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceService {

    private final ServiceRepo serviceRepo;
    private final ServiceValidator serviceValidator;
    private final UserValidator userValidator;

    @Autowired
    public ServiceService(ServiceRepo serviceRepo, ServiceValidator serviceValidator, UserValidator userValidator) {
        this.serviceRepo = serviceRepo;
        this.serviceValidator = serviceValidator;
        this.userValidator = userValidator;
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

    public void addServiceToUser(String username, Long serviceId) {
        Service service = serviceValidator.checkServiceExists(serviceId);
        User user = userValidator.checkUserExists(username);
        service.setUsername(user);
        serviceRepo.save(service);
    }

    public void removeBookFromUser(String username, Long serviceId) {
        Service service = serviceValidator.checkServiceExists(serviceId);
        User user = userValidator.checkUserExists(username);
        userValidator.checkUserHaveService(user, bookId);
        book.setUser(null);
        bookRepository.save(book);
    }

}
