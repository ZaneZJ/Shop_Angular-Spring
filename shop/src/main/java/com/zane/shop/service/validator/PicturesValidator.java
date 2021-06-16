package com.zane.shop.service.validator;

import com.zane.shop.exception.EmailAlreadyExistsException;
import com.zane.shop.exception.EntityDoesNotExistsException;
import com.zane.shop.repo.PicturesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PicturesValidator {

    private final PicturesRepo picturesRepo;

    @Autowired
    public PicturesValidator(PicturesRepo picturesRepo) {
        this.picturesRepo = picturesRepo;
    }

}
