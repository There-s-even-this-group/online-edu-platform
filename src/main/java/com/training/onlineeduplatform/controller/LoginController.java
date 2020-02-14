package com.training.onlineeduplatform.controller;

import com.training.onlineeduplatform.model.ResultMap;
import com.training.onlineeduplatform.service.UserService;
import com.training.onlineeduplatform.util.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

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
    private UserService userService;

    private static String salt="1x2j3x4y5w6t";

    @GetMapping(value = "/notLogin")
    public ResultMap notLogin() {
        return resultMap.success().message("您尚未登陆！");
    }

    @GetMapping(value = "/notRole")
    public ResultMap notRole() {
        return resultMap.success().message("您没有权限！");
    }

    @GetMapping(value = "/logout")
    public ResultMap logout() {
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
        if (realPassword == null) {
            return resultMap.fail().code(401).message("用户名错误");
        } else if (!realPassword.equals(password)) {
            return resultMap.fail().code(401).message("密码错误");
        } else {
            return resultMap.success().code(200).message(JWTUtil.createToken(username,password));
        }
    }

    /**
     * 注册
     *
     * @param username 用户名
     * @param password 密码
     * @param role 权限
     * @return
     */
    @PostMapping("/register")
    public ResultMap register(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              @RequestParam("role") String role) {
        String md5Password = md5SaltEncode(password);
        userService.addUser(username,md5Password,role);
        return resultMap.success().code(200).message("注册成功！");
    }

    @RequestMapping(path = "/unauthorized/{message}")
    public ResultMap unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
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
