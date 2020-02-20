package com.training.onlineeduplatform.model;

import lombok.Data;

/**
 * Created on 2020/2/19.
 *
 * 权限实体类
 *
 * @author Yue Wu
 */
@Data
public class Role {
    public int id;
    public String role;
    public String permission;
}
