package com.zane.shop.controller;

import com.zane.shop.model.Service;
import com.zane.shop.model.User;
import com.zane.shop.service.ServiceService;
import com.zane.shop.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop/service")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Service>> getAllServices() {
        List<Service> services = serviceService.getAllServices();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/find/{theme}")
    public ResponseEntity<List<Service>> getServicesByTheme(@PathVariable("theme") String theme) {
        List<Service> services = serviceService.getAllServicesByTheme(theme);
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Service> addService(@RequestBody Service service) {
        Service newService = serviceService.addServiceToUser(service.getUser().getUsername(), service);
        return new ResponseEntity<>(newService, HttpStatus.CREATED);
    }

//    @PutMapping("/update")
//    public ResponseEntity<User> updateUser(@RequestBody User user) {
//        User updateUser = userService.updateUser(user);
//        return new ResponseEntity<>(updateUser, HttpStatus.OK);
//    }

    @DeleteMapping("/delete/{username}/{serviceId}")
    public ResponseEntity<?> deleteService(@PathVariable("username") String username, @PathVariable("serviceId") Long serviceId) {
        serviceService.removeServiceFromUser(username, serviceId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
