package com.training.onlineeduplatform.service.impl;

import com.training.onlineeduplatform.mapper.UserMapper;
import com.training.onlineeduplatform.model.user.TeacherInf;
import com.training.onlineeduplatform.model.user.User;
import com.training.onlineeduplatform.model.user.UserChangeInf;
import com.training.onlineeduplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created on 2019/12/29.
 *
 * @author Yue Wu
 */
@Service
@Transactional
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

    @Override
    public String getUserId(String username) {
        return userMapper.getUserId(username);
    }

    @Override
    public int changeUserInf(UserChangeInf userChangeInf) {
        return userMapper.changeUserInf(userChangeInf);
    }

    @Override
    public String getUserIcon(String username) {
        return userMapper.getUserIcon(username);
    }

    @Override
    public int changeUserIcon(String username, String path) {
        return userMapper.changeUserIcon(username,path);
    }

    @Override
    public int changeUserPass(String username, String newpassword) {
        return userMapper.changeUserPass(username,newpassword);
    }

    @Override
    public int signUp(String username) {
        return userMapper.signUp(username);
    }

    @Override
    public Date getLastSign(String username) {
        return userMapper.getLastSign(username);
    }

    @Override
    public int getFrequency(String username) {
        return userMapper.getFrequency(username);
    }

    @Override
    public TeacherInf getTeacherInf(String username) {
        return userMapper.getTeacherInf(username);
    }

    @Override
    public int changeTeacherInf(TeacherInf teacherInf) {
        return userMapper.changeTeacherInf(teacherInf);
    }

    @Override
    public int getSignNumber() {
        return userMapper.getSignNumber();
    }
}
