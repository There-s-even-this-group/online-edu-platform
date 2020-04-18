package com.training.onlineeduplatform.mapper;

import com.training.onlineeduplatform.model.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2020/4/13.
 *
 * @author Zhouyong Tan
 */

@Mapper
public interface AdminMapper {

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
     * 返回所有老师信息
     */
    List<User> getTeacherInf();

    /**
     * 获取全部信息
     */
    List<User> getAllUserInf();

    /**
     * 删除指定用户
     */
    int deleteUser(String username);
}
