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
    public String getPassword(String username) {
        return userMapper.getPassword(username);
    }

    @Override
    public String getRole(String username) {
        return userMapper.getRole(username);
    }

    @Override
    public void updatePassword(String username, String newPassword) {
        userMapper.updatePassword(username,newPassword);
    }

    @Override
    public List<String> getUser() {
        return userMapper.getUser();
    }

    @Override
    public void banUser(String username) {
        userMapper.banUser(username);
    }

    @Override
    public int checkUserBanStatus(String username) {
        return userMapper.checkUserBanStatus(username);
    }

    @Override
    public String getRolePermission(String username) {
        return userMapper.getRolePermission(username);
    }

    @Override
    public String getPermission(String username) {
        return userMapper.getPermission(username);
    }

    @Override
    public void addUser(String username, String password, String email, String role) {
        userMapper.addUser(username,password, email,role);
    }

    @Override
    public User getUserInf(String username) {
        return userMapper.getUserInf(username);
    }
}
