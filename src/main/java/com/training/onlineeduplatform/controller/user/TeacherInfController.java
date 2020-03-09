package com.training.onlineeduplatform.controller.user;

import com.training.onlineeduplatform.model.common.ResultMap;
import com.training.onlineeduplatform.model.user.TeacherInf;
import com.training.onlineeduplatform.service.UserService;
import com.training.onlineeduplatform.util.JWTUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2020/3/9.
 *
 * 老师信息 Controller
 *
 * @author Yue Wu
 */
@RestController
@RequestMapping(value = "/teacher")
public class TeacherInfController {

    @Autowired
    private ResultMap resultMap;

    @Autowired
    private UserService userService;

    @GetMapping("/getInf")
    @RequiresRoles(logical = Logical.OR, value = {"user","admin"})
    @RequiresPermissions("teacher")
    public Map<String, Object> getInf(@RequestHeader String token) {
        Map<String, Object> map = new HashMap<>();
        String username = JWTUtil.getUsername(token);
        TeacherInf teacherInf = userService.getTeacherInf(username);
        map.put("teacherInf",teacherInf);
        return map;
    }

    @PostMapping("/changeInf")
    @RequiresRoles(logical = Logical.OR, value = {"user","admin"})
    @RequiresPermissions("teacher")
    public ResultMap changeInf(@RequestBody TeacherInf teacherInf) {
        System.out.println(teacherInf);
        if (userService.changeTeacherInf(teacherInf) == 1) {
            return resultMap.success().message("修改成功");
        } else {
            return resultMap.fail().message("修改失败，请再次尝试");
        }
    }
}
