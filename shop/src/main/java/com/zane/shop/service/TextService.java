package com.zane.shop.service;

import com.zane.shop.model.Service;
import com.zane.shop.model.Text;
import com.zane.shop.model.User;
import com.zane.shop.repo.TextRepo;
import com.zane.shop.repo.ServiceRepo;
import com.zane.shop.repo.TextRepo;
import com.zane.shop.service.validator.ServiceValidator;
import com.zane.shop.service.validator.TextValidator;
import com.zane.shop.service.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class TextService {

//    private final TextRepo textRepo;
//    private final TextValidator textValidator;

    @Autowired
    public TextService() {
    }

//    public List<Text> getAllTexts() {
//        return serviceRepo.findAll();
//    }
//
//    public List<Text> getAllTextsByDate(Date createTime) {
//        return textRepo.findByTheme(theme);
//    }

}
