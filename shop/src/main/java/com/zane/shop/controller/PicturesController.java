package com.zane.shop.controller;

import com.zane.shop.model.Pictures;
import com.zane.shop.model.Service;
import com.zane.shop.service.ServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop/pictures")
public class PicturesController {

//    private final PicturesController picturesController;
//
//    public PicturesController(PicturesController picturesController) {
//        this.picturesController = picturesController;
//    }

//    @GetMapping("/all")
//    public ResponseEntity<List<Pictures>> getAllPicturesForService(@PathVariable("serviceId") Long serviceId) {
//        List<Pictures> pictures = picturesService.getAllPicturesByServiceId();
//        return new ResponseEntity<>(pictures, HttpStatus.OK);
//    }

}
