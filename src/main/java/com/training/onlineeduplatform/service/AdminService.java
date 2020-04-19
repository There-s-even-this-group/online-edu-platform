package com.training.onlineeduplatform.service;

import com.training.onlineeduplatform.model.TfrArticle;
import com.training.onlineeduplatform.model.user.User;

import java.util.List;

/**
 * Created on 2020/4/13.
 *
 * @author Zhouyong Tan
 */
public interface AdminService {
    /**
     * 解冻课程
     */
    int ThawArticle(String article_title);


    /**
     * 冻结课程
     */
    int FrozenArticle(String article_title);

    /**
     * 返回全部托福人课程信息
     */
    List<TfrArticle> getAllTfrArticleInf();

    /**
     * 管理员添加用户
     */
    int adminAddUser(String username, String password, String email, String role,String sex,String phone);

    /**
     * 解冻用户
     */
    int ThawUser(String username);

    /**
     * 冻结用户
     */
    int FrozenUser(String username);

    /**
     * 查询用户
     * @param username
     * @return
     */
    List<User> getSearchUserInf(String username);

    /**
     * 获取全部信息
     */
    List<User> getAllUserInf();

    /**
     * 获取老师信息
     */
    List<User> getTeacherInf();

    /**
     * 删除用户
     */
    int deleteUser(String username);
}
