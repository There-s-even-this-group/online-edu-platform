package com.training.onlineeduplatform.controller.user;

import com.training.onlineeduplatform.model.common.ResultMap;
import com.training.onlineeduplatform.model.user.User;
import com.training.onlineeduplatform.service.UserService;
import com.training.onlineeduplatform.util.JWTUtil;
import com.training.onlineeduplatform.util.Md5Encoding;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
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
        password = Md5Encoding.md5SaltEncode(password);
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
        User user = userService.getUserInf(username);
        if (user != null) {
            return resultMap.fail().code(1000).message("该用户名已被注册！");
        }
        String md5Password = Md5Encoding.md5SaltEncode(password);
        userService.addUser(username,md5Password,email,role);
        return resultMap.success().code(200).message("注册成功！");
    }

    @RequestMapping(path = "/unauthorized/{message}")
    public ResultMap unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
        resultMap.clear();
        return resultMap.success().code(401).message(message);
    }
}
