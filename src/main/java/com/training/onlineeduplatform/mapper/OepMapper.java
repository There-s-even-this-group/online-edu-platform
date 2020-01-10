package com.training.onlineeduplatform.mapper;

import com.training.onlineeduplatform.model.Oep;
import com.training.onlineeduplatform.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2020/1/10.
 *
 * 登录注册用
 * 注册功能暂未实现
 *
 * @author Yue Wu
 */
@Mapper
public interface OepMapper {
    Oep loadUserByUsername(String username);
    List<Role> getUserRolesByUid(Integer id);
    int saveNewRm(String name,String username,String password,String role);
}
