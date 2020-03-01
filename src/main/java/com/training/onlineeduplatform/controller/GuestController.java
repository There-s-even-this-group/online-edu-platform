package com.training.onlineeduplatform.controller;

import com.training.onlineeduplatform.model.common.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2020/2/13.
 *
 * 游客/未登录时可以访问的内容
 * 公开的Controller
 * @author Yue Wu
 */
@RestController
@RequestMapping("/guest")
public class GuestController {
    @Autowired
    private final ResultMap resultMap;

    public GuestController(ResultMap resultMap) {
        this.resultMap = resultMap;
    }

    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public ResultMap login() {
        return resultMap.success().message("欢迎进入，您的身份是游客");
    }

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public ResultMap submitLogin() {
        return resultMap.success().message("您拥有获得该接口的信息的权限！");
    }
}
