package com.training.onlineeduplatform.model.user;

import lombok.Data;

import java.util.Date;

/**
 * Created on 2020/3/9.
 *
 * 教师信息实体类
 *
 * @author Yue Wu
 */
@Data
public class TeacherInf {
    public String username;
    public String realname;
    public String sex;
    public String education;
    public String email;
    public String phone;
    public Date birthdata;
    public String introduction;
}
