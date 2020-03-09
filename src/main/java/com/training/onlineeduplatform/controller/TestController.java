package com.training.onlineeduplatform.controller;

import com.training.onlineeduplatform.model.common.ResultMap;
import com.training.onlineeduplatform.model.user.ResultUserInfMap;
import com.training.onlineeduplatform.model.user.User;
import com.training.onlineeduplatform.service.UserService;
import com.training.onlineeduplatform.util.FastdfsUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    private final ResultUserInfMap resultUserInfMap;

    @Autowired
    private final FastdfsUtils fastdfsUtils;

    @Autowired
    private UserService userService;

    public TestController(ResultMap resultMap, ResultUserInfMap resultUserInfMap, FastdfsUtils fastdfsUtils) {
        this.resultMap = resultMap;
        this.resultUserInfMap = resultUserInfMap;
        this.fastdfsUtils = fastdfsUtils;
    }

    @GetMapping("/getInf/{username}")
    public ResultUserInfMap getUser(@PathVariable String username){
        User user = userService.getUserInf(username);
        List<String> list = new ArrayList<>();
        list.add(user.getRole().getRole());
        list.add(user.getRole().getPermission());
        return resultUserInfMap.username(user.getUsername()).email(user.getEmail()).role(list).ban(user.getBan());
    }

    /**
     * 拥有 user, admin 角色的用户可以访问下面的页面
     */
    @GetMapping("/getMessage")
    public ResultMap getMessage(HttpServletResponse response) throws IOException {
        resultMap.clear();
        fastdfsUtils.download("group1/M00/00/00/rBDDUl5edEqAYyTPAACeCD1VRqk233.jpg",response);
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
