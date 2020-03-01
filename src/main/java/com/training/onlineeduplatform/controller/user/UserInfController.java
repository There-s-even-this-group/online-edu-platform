package com.training.onlineeduplatform.controller.user;

import com.training.onlineeduplatform.controller.UploadController;
import com.training.onlineeduplatform.model.common.ResultMap;
import com.training.onlineeduplatform.model.user.ResultUserInfMap;
import com.training.onlineeduplatform.model.user.User;
import com.training.onlineeduplatform.model.user.UserChangeInf;
import com.training.onlineeduplatform.service.UserService;
import com.training.onlineeduplatform.util.JWTUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020/2/29.
 *
 * 用户信息相关Controller
 *
 * @author Yue Wu
 */
@RestController
public class UserInfController {

    @Autowired
    private ResultMap resultMap;
    @Autowired
    private final ResultUserInfMap resultUserInfMap;
    @Autowired
    private UserService userService;
    @Autowired
    UploadController uploadController;

    public UserInfController(ResultUserInfMap resultUserInfMap) {
        this.resultUserInfMap = resultUserInfMap;
    }

    /**
     * 获取用户信息
     * @param token 凭证
     * @return
     */
    @GetMapping("/getInf")
    @RequiresRoles(logical = Logical.OR, value = {"user","admin"})
    public ResultUserInfMap getUser(@RequestHeader String token){
        String username = JWTUtil.getUsername(token);
        User user = userService.getUserInf(username);
        List<String> list = new ArrayList<>();
        list.add(user.getRole().getRole());
        list.add(user.getRole().getPermission());
        resultUserInfMap.clear();
        System.out.println(user);
        return resultUserInfMap.username(user.getUsername())
                .email(user.getEmail())
                .role(list)
                .ban(user.getBan())
                .sex(user.getSex())
                .phone(user.getPhone())
                .birthdata(user.getBirthdata())
                .sign(user.getSign());
    }

    /**
     * 修改用户信息
     * 个人中心页
     * @param userChangeInf 封装实体类（仅包含修改属性）
     * @return
     */
    @PostMapping("/changInf")
    @RequiresRoles(logical = Logical.OR, value = {"user","admin"})
    public ResultMap changeUser(UserChangeInf userChangeInf) {
        if (userService.changeUserInf(userChangeInf) == 1) {
            return resultMap.success().code(200).message("修改成功！");
        } else {
            return resultMap.fail().code(401).message("修改失败！");
        }
    }

    /**
     * 获取用户头像
     * @param token 凭证
     * @return
     */
    @GetMapping("/getIcon")
    @RequiresRoles(logical = Logical.OR, value = {"user","admin"})
    public ResultMap getUserIcon(@RequestHeader String token){
        String username = JWTUtil.getUsername(token);
        return resultMap.success().code(200).icon(userService.getUserIcon(username));
    }

    /**
     * 修改用户头像
     * @param file 用户头像
     * @param token 凭证
     * @return
     * @throws Exception
     */
    @PostMapping("/changeIcon")
    @RequiresRoles(logical = Logical.OR, value = {"user","admin"})
    public ResultMap changeUserIcon(@RequestParam("file") MultipartFile file,@RequestHeader String token) throws Exception {
        String path = "";
        String username = JWTUtil.getUsername(token);
        String pastIcon = userService.getUserIcon(username);
        if (!"http://120.27.241.26/group1/M00/00/00/rBDDUl5bcO2ANCAWAAAGsa4U3Is409.png".equals(pastIcon)) {
            String past = "";
            for (int i = 31;i < pastIcon.length(); i++) {
                past += pastIcon.charAt(i);
            }
            uploadController.deleteFile("group1",past);
        }
        if (file.isEmpty()) {
            return resultMap.fail().code(401).message("修改失败");
        }
        try {
            path = uploadController.saveFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        userService.changeUserIcon(username,path);
        return resultMap.success().code(200).message("修改成功");
    }
}
