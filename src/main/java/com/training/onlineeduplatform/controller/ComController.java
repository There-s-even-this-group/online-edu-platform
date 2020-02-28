package com.training.onlineeduplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.FileNotFoundException;

/**
 * Created on 2020/2/27.
 *
 * @author Hongwe Xiong
 */
@Controller
public class ComController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index() throws FileNotFoundException {
        String path = ResourceUtils.getURL("classpath:").getPath();
        System.out.println(path);
        return "/index.html";
    }
}
