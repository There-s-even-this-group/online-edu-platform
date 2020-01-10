package com.training.onlineeduplatform.controller;

import com.training.onlineeduplatform.service.OepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2020/1/10.
 *
 * 公共Controller
 *
 * @author Yue Wu
 */
@RestController
public class CommomRestController {

    @Autowired
    OepService oepService;

    @RequestMapping(value = "/register.do",method = RequestMethod.GET)
    public String newUser(HttpServletRequest httpServletRequest) {
        String name = httpServletRequest.getParameter("name");
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        String role = httpServletRequest.getParameter("role");
        System.out.println(name);
        oepService.addRm(name,username,password,role);
        return "注册成功！";
    }
}
