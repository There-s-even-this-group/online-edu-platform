package com.training.onlineeduplatform.controller;

import com.training.onlineeduplatform.model.User;
import com.training.onlineeduplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 2019/12/29.
 *
 * @author Yue Wu
 */
@RestController
public class UserRestController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAll.do" ,method = RequestMethod.GET)
    public List<User> getAllUser() {
        return userService.getAll();
    }
}
