package com.zane.shop.service.validator;

import com.zane.shop.exception.EntityDoesNotExistsException;
import com.zane.shop.model.Service;
import com.zane.shop.repo.ServiceRepo;
import com.zane.shop.repo.TextRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TextValidator {

    private final TextRepo textRepo;

    @Autowired
    public TextValidator(TextRepo textRepo) {
        this.textRepo = textRepo;
    }

}
