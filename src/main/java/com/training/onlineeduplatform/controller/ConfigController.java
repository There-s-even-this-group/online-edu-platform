package com.training.onlineeduplatform.controller;

import com.training.onlineeduplatform.model.Menu;
import com.training.onlineeduplatform.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 2020/1/13.
 *
 * 配置Controller，用于获取菜单等
 *
 * @author Yue Wu
 */
@RestController
@RequestMapping(value = "/config")
public class ConfigController {

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "/sysmenu",method = RequestMethod.GET)
    public List<Menu> sysmenu() {
        return menuService.getMenusByHrId();
    }

}
