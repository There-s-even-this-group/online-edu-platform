package com.training.onlineeduplatform.model;

import lombok.Data;

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
}