package com.training.onlineeduplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created on 2020/2/27.
 *
 * @author Hongwe Xiong
 */
@Controller
public class ComController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "/index.html";
    }
}
