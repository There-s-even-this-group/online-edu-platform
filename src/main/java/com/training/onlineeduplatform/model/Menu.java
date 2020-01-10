package com.training.onlineeduplatform.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 2020/1/10.
 *
 * @author Yue Wu
 */
@Data
public class Menu implements Serializable {
    private Long id;
    private String url;
    private String path;
    private Object component;
    private String name;
    private String iconCls;
    private Long parentId;
    private List<Role> roles;
    private List<Menu> children;
    private MenuMeta meta;
}
