package com.training.onlineeduplatform.controller.mainPage;

import com.training.onlineeduplatform.model.common.ResultMap;
import com.training.onlineeduplatform.service.UserService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2020/4/19.
 *
 * @author Yue Wu
 */
@RestController
public class MainPageController {

    @Autowired
    UserService userService;
    @Autowired
    private ResultMap resultMap;

    @GetMapping(value = "/getNewArticle")
    @RequiresRoles(logical = Logical.OR, value = {"user","admin"})
    public Map<String, Object> getNewArticle() {
        Map<String, Object> map = new HashMap<>();
        return resultMap.code(200).success().message(userService.getNewArticle());
    }
}
