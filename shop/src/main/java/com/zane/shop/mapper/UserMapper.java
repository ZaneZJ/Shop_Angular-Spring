package com.zane.shop.mapper;

import com.zane.shop.dto.UserDTO;
import com.zane.shop.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User fromDTO(UserDTO userDTO){
        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setPhoneNo(userDTO.getPhoneNo());
        user.setAddress(userDTO.getAddress());
        user.setEmail(userDTO.getEmail());
        user.setPostalCode(userDTO.getPostalCode());
        user.setPictureMain(userDTO.getPictureMain());
        user.setAccountNo(userDTO.getAccountNo());
        return user;
    }

    public UserDTO toDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setPhoneNo(user.getPhoneNo());
        userDTO.setAddress(user.getAddress());
        userDTO.setEmail(user.getEmail());
        userDTO.setPostalCode(user.getPostalCode());
        userDTO.setPictureMain(user.getPictureMain());
        userDTO.setAccountNo(user.getAccountNo());
        return userDTO;
    }
}
