package com.zane.shop;

import com.zane.shop.model.User;
import com.zane.shop.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopResourceController {

    @GetMapping("/")
    public String index() {
        return "Greetings!";
    }

}
