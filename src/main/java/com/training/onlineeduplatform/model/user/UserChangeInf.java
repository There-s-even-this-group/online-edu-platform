package com.training.onlineeduplatform.model.user;

import lombok.Data;

import java.sql.Date;

/**
 * Created on 2020/2/29.
 *
 * 用户信息修改部分
 *
 * @author Yue Wu
 */
@Data
public class UserChangeInf {
    public String username;
    public String email;
    public String sex;
    public String phone;
    public Date birthdata;
    public String sign;
}
