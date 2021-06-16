package com.zane.shop.service;

import com.zane.shop.exception.UsernameNotFoundException;
import com.zane.shop.model.Service;
import com.zane.shop.model.User;
import com.zane.shop.repo.PicturesRepo;
import com.zane.shop.repo.ServiceRepo;
import com.zane.shop.repo.UserRepo;
import com.zane.shop.service.validator.PicturesValidator;
import com.zane.shop.service.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class PicturesService {

    private final PicturesRepo picturesRepo;
    private final ServiceRepo serviceRepo;
    private final PicturesValidator picturesValidator;

    @Autowired
    public PicturesService(PicturesRepo picturesRepo, PicturesValidator picturesValidator, ServiceRepo serviceRepo) {
        this.picturesRepo = picturesRepo;
        this.picturesValidator = picturesValidator;
        this.serviceRepo = serviceRepo;
    }

    @Transactional

    public Service getAllPicturesByServiceId(Long serviceId) {
        return serviceRepo.getOne(serviceId);
    }

}
