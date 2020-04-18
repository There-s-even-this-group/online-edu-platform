package com.training.onlineeduplatform.model.user;

import com.training.onlineeduplatform.model.Role;
import lombok.Data;

import java.sql.Date;

/**
 * Created on 2020/2/19.
 *
 * 用户实体类
 *
 * @author Yue Wu
 */
@Data
public class User {
    public int id;
    public String username;
    public String password;
    public String email;
    public Role role;
    public int ban;
    public String sex;
    public String phone;
    public Date birthdata;
    public String sign;
    public String icon;
    public int article;
    public int curriculum;
}