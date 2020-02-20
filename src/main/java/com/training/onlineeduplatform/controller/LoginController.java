package com.training.onlineeduplatform.controller;

import com.training.onlineeduplatform.model.ResultMap;
import com.training.onlineeduplatform.model.ResultUserInfMap;
import com.training.onlineeduplatform.model.User;
import com.training.onlineeduplatform.service.UserService;
import com.training.onlineeduplatform.util.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020/2/13.
 *
 * @author Yue Wu
 */
@RestController
public class LoginController {
    @Autowired
    private ResultMap resultMap;
    @Autowired
    private final ResultUserInfMap resultUserInfMap;
    @Autowired
    private UserService userService;

    private final static String salt="1x2j3x4y5w6t";

    public LoginController(ResultUserInfMap resultUserInfMap) {
        this.resultUserInfMap = resultUserInfMap;
    }

    @GetMapping(value = "/notLogin")
    public ResultMap notLogin() {
        resultMap.clear();
        return resultMap.success().message("您尚未登陆！");
    }

    @GetMapping(value = "/notRole")
    public ResultMap notRole() {
        resultMap.clear();
        return resultMap.success().message("您没有权限！");
    }

    @GetMapping(value = "/logout")
    public ResultMap logout() {
        resultMap.clear();
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        return resultMap.success().message("成功注销！");
    }

    /**
     * 登陆
     *
     * @param username 用户名
     * @param password 密码
     */
    @PostMapping("/login")
    public ResultMap login(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        String realPassword = userService.getPassword(username);
        password = md5SaltEncode(password);
        resultMap.clear();
        if (realPassword == null) {
            return resultMap.fail().code(401).message("用户名错误");
        } else if (!realPassword.equals(password)) {
            return resultMap.fail().code(401).message("密码错误");
        } else {
            return resultMap.success().code(200).token(JWTUtil.createToken(username,userService.getUserId(username)));
        }
    }

    /**
     * 注册
     *
     * @param username 用户名
     * @param password 密码
     * @param email 邮箱
     * @param role 权限
     * @return
     */
    @PostMapping("/register")
    public ResultMap register(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              @RequestParam("email") String email,
                              @RequestParam("role") String role) {
        resultMap.clear();
        String md5Password = md5SaltEncode(password);
        userService.addUser(username,md5Password,email,role);
        return resultMap.success().code(200).message("注册成功！");
    }

    /**
     * 获取用户信息
     * @param token 凭证
     * @return
     */
    @GetMapping("/getInf")
    @RequiresRoles(logical = Logical.OR, value = {"user","admin"})
    public ResultUserInfMap getUser(@RequestHeader String token){
        String username = JWTUtil.getUsername(token);
        User user = userService.getUserInf(username);
        List<String> list = new ArrayList<>();
        list.add(user.getRole().getRole());
        list.add(user.getRole().getPermission());
        resultUserInfMap.clear();
        return resultUserInfMap.username(user.getUsername()).email(user.getEmail()).role(list).ban(user.getBan());
    }

    @RequestMapping(path = "/unauthorized/{message}")
    public ResultMap unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
        resultMap.clear();
        return resultMap.success().code(401).message(message);
    }

    /**
     * md5加盐加密算法
     * @param password
     * @return
     */
    private String md5SaltEncode(String password){
        String str = "" + salt.charAt(3) + salt + salt.charAt(7) + password + salt.charAt(9);
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
}
