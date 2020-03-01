package com.training.onlineeduplatform.mapper;

import com.training.onlineeduplatform.model.user.User;
import com.training.onlineeduplatform.model.user.UserChangeInf;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created on 2019/12/29.
 *
 * @author Yue Wu
 */
@Mapper
public interface UserMapper {
    /**
     * 获得密码
     * @param username 用户名
     */
    String getPassword(String username);

    /**
     * 获得角色权限
     * @param username 用户名
     * @return user/admin
     */
    String getRole(String username);

    /**
     * 修改密码
     */
    void updatePassword(@Param("username") String username, @Param("newPassword") String newPassword);

    /**
     * 获得存在的用户
     */
    List<String> getUser();

    /**
     * 封号
     */
    void banUser(String username);

    /**
     * 检查用户状态
     */
    int checkUserBanStatus(String username);

    /**
     * 获得用户角色默认的权限
     */
    String getRolePermission(String username);

    /**
     * 获得用户的权限
     */
    String getPermission(String username);

    /**
     * 添加用户
     */
    void addUser(String username,String password,String email,String role);

    /**
     * 获取用户信息
     */
    User getUserInf(String username);

    /**
     * 获取用户id
     */
    String getUserId(String username);

    /**
     * 修改用户信息
     */
    int changeUserInf(UserChangeInf userChangeInf);

    /**
     * 获取用户头像
     */
    String getUserIcon(String username);

    /**
     * 设置用户头像
     */
    int changeUserIcon(String username,String path);

    /**
     * 修改用户密码
     */
    int changeUserPass(String username,String newpassword);
}
