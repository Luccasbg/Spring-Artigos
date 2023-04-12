package com.devocionais.devocionais.services;

import com.devocionais.devocionais.dto.UserDto;
import com.devocionais.devocionais.models.User;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    public User registerUser(UserDto userDAO){
        User user = new User();
        BeanUtils.copyProperties(userDAO, user);

        return user;
    }
}
