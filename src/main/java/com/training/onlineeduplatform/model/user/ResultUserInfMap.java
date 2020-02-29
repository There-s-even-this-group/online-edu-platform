package com.training.onlineeduplatform.model.user;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created on 2020/2/19.
 *
 * 用户信息
 *
 * @author Yue Wu
 */
@Component
public class ResultUserInfMap extends HashMap<String, Object> {

    public ResultUserInfMap() {

    }

    public ResultUserInfMap username(String username) {
        this.put("username", username);
        return this;
    }

    public ResultUserInfMap email(String email) {
        this.put("email", email);
        return this;
    }

    public ResultUserInfMap role(List<String> role) {
        this.put("role", role);
        return this;
    }

    public ResultUserInfMap ban(int ban) {
        this.put("ban", ban);
        return this;
    }

    public ResultUserInfMap sex(String sex) {
        this.put("sex", sex);
        return this;
    }

    public ResultUserInfMap phone(String phone) {
        this.put("phone", phone);
        return this;
    }

    public ResultUserInfMap birthdata(Date birthdata) {
        this.put("birthdata", birthdata);
        return this;
    }

    public ResultUserInfMap sign(String sign) {
        this.put("sign", sign);
        return this;
    }
}
