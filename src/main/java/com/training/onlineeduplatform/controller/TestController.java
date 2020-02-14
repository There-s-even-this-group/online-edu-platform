package com.training.onlineeduplatform.controller;

import com.training.onlineeduplatform.model.ResultMap;
import com.training.onlineeduplatform.service.UserService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2020/2/13.
 *
 * 权限测试controller
 *
 * @author Yue Wu
 */
@RestController
@RequestMapping("/user")
public class TestController {
    @Autowired
    private final ResultMap resultMap;

    @Autowired
    private UserService userService;

    public TestController(ResultMap resultMap) {
        this.resultMap = resultMap;
    }

    /**
     * 拥有 user, admin 角色的用户可以访问下面的页面
     */
    @GetMapping("/getMessage")
    @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
    public ResultMap getMessage() {
        return resultMap.success().code(200).message("成功获得信息！");
    }

    /**
     * 拥有 vip 权限可以访问该页面
     */
    @GetMapping("/getVipMessage")
    @RequiresRoles(logical = Logical.OR, value = {"user","admin"})
    @RequiresPermissions("teacher")
    public ResultMap getVipMessage() {
        return resultMap.success().code(200).message("成功获得 teacher 信息！");
    }
}
