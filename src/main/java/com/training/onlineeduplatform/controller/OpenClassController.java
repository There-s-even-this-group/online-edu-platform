package com.training.onlineeduplatform.controller;

import com.training.onlineeduplatform.model.OpenClass;
import com.training.onlineeduplatform.service.OpenClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2020/2/22.
 *
 * @author Hongwe Xiong
 */
@RestController
public class OpenClassController {
    @Autowired
    OpenClassService openClassService;

    @GetMapping(value = "/getOpenClassByClassType")
    public Map<String, Object> getOpenClassByClassType(String public_classType){
        Map<String, Object> map = new HashMap<>();
        List<OpenClass> list = openClassService.getOpenClassByClassType(public_classType);
        map.put("openClass",list);
        return map;
    }

    @GetMapping(value = "/getOpenClassByID")
    public Map<String, Object> getOpenClassByClassID(int public_classID){
        Map<String, Object> map = new HashMap<>();
        List<OpenClass> list = openClassService.getOpenClassByClassID(public_classID);
        map.put("openClass",list);
        return map;
    }

    @PostMapping(value = "/deleteOpenClass")
    public int deleteOpenClass(int public_classID){
        int code = openClassService.deleteOpenClass(public_classID);
        return code;
    }

    @PostMapping(value = "/updateOpenClassByClassID")
    public int updateOpenClassByClassID(OpenClass openClass){
       int code = openClassService.updateOpenClassByClassID(openClass);
        return code;
    }

    @PostMapping(value = "/addOpenClass")
    public Map<String, Object> addOpenClass(OpenClass openClass){
        Map<String, Object> map = new HashMap<>();
        int code = openClassService.addOpenClass(openClass);
        int id = openClassService.getLAST_INSERT_ID();
        map.put("code",code);
        map.put("id",id);
        return map;
    }
}
