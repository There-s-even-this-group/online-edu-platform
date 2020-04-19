package com.training.onlineeduplatform.service.impl;

import com.training.onlineeduplatform.mapper.AdminMapper;
import com.training.onlineeduplatform.model.TfrArticle;
import com.training.onlineeduplatform.model.user.User;
import com.training.onlineeduplatform.service.AdminService;
import com.training.onlineeduplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 2020/4/13.
 *
 * @author Zhouyong Tan
 */

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int ThawArticle(String article_title) {
        return adminMapper.ThawArticle(article_title);
    }

    @Override
    public int FrozenArticle(String article_title) {
        return adminMapper.FrozenArticle(article_title);
    }

    @Override
    public List<TfrArticle> getAllTfrArticleInf() {
        return adminMapper.getAllTfrArticleInf();
    }

    @Override
    public int adminAddUser(String username, String password, String email, String role,String sex,String phone) {
        return adminMapper.adminAddUser(username,password,email,role,sex,phone);
    }

    @Override
    public int ThawUser(String username) {
        return adminMapper.ThawUser(username);
    }

    @Override
    public int FrozenUser(String username) {
        return adminMapper.FrozenUser(username);
    }

    @Override
    public List<User> getSearchUserInf(String username){
        return adminMapper.getSearchUserInf(username);
    }

    @Override
    public List<User> getAllUserInf() {
        return adminMapper.getAllUserInf();
    }

    @Override
    public List<User> getTeacherInf() {
        return adminMapper.getTeacherInf();
    }

    @Override
    public int deleteUser(String username) {
        return adminMapper.deleteUser(username);
    }
}
