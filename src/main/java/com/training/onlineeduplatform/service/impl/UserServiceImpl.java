package com.training.onlineeduplatform.service.impl;

import com.training.onlineeduplatform.mapper.UserMapper;
import com.training.onlineeduplatform.model.User;
import com.training.onlineeduplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2019/12/29.
 *
 * @author Yue Wu
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }
}
