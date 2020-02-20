package com.training.onlineeduplatform.model;

import org.springframework.stereotype.Component;

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
        this.put("emali", email);
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
}
