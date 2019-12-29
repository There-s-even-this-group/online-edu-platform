package com.training.onlineeduplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created on 2019/12/29.
 *
 * @author Yue Wu
 */
@Controller
public class UserController {

    @RequestMapping(value = "hello.do",method = RequestMethod.GET)
    public String hello() {
        return "test";
    }
}
