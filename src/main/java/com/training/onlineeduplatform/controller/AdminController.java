package com.training.onlineeduplatform.controller;

import com.training.onlineeduplatform.mapper.AdminMapper;
import com.training.onlineeduplatform.model.common.ResultMap;
import com.training.onlineeduplatform.model.user.User;
import com.training.onlineeduplatform.service.AdminService;
import com.training.onlineeduplatform.service.UserService;
import com.training.onlineeduplatform.util.JWTUtil;
import com.training.onlineeduplatform.util.Md5Encoding;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.training.onlineeduplatform.util.FastdfsUtils;
import java.util.*;

/**
 * Created on 2020/4/13.
 *
 * @author Zhouyong Tan
 */
@RestController
public class AdminController {

    @Autowired
    private FastdfsUtils fastdfsUtils;

    @Autowired
    private AdminService adminService;

    @Autowired
    private  UserService userService;

    /**
     * 修改用户头像
     * @param file 用户头像
     * @return
     * @throws Exception
     */
    @PostMapping("/adminChangeIcon")
    public int changeUserIcon(@RequestParam("file") MultipartFile file, @RequestHeader String username) throws Exception {
        String path = "";
        String pastIcon = userService.getUserIcon(username);
        if (file.isEmpty()) {
            return 0;
        } else {
            if (!"group1/M00/00/00/rBDDUl5bcO2ANCAWAAAGsa4U3Is409.png".equals(pastIcon)) {
                fastdfsUtils.delete(pastIcon);
            }
            try {
                path = fastdfsUtils.upload(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            userService.changeUserIcon(username,path);
            return 1;
        }
    }

    /**
     * 管理员添加用户
     */
    @PostMapping("/adminAddUser")
    public int adminAddUser(@RequestParam("username")String username,@RequestParam("password")String password,
                             @RequestParam("email")String email,@RequestParam("role")String role,
                            @RequestParam("sex")String sex,@RequestParam("phone")String phone
                            ) {
        User user=userService.getUserInf(username);
        if (user!=null){
            return 400;
        }else {
            String newPassword= Md5Encoding.md5SaltEncode(password);
            return adminService.adminAddUser(username,newPassword,email,role,sex,phone);
        }
    }

    /**
     * 解冻用户
     */
    @PostMapping("/ThawUser")
    public int ThawUser(@RequestParam("username")String username){
        System.out.println(username);
        int code=adminService.ThawUser(username);
        if (code==1){
            return code;
        }else {
            return 0;
        }
    }

    /**
     * 冻结用户
     */
    @PostMapping("/FrozenUser")
    public int FrozenUser(@RequestParam("username")String username){
        System.out.println(username);
        int code=adminService.FrozenUser(username);
        if (code==1){
            return code;
        }else {
            return 0;
        }
    }

    /**
     * 查询用户
     */
    @PostMapping("/searchUser")
    public Map<String,Object> getSearchUserInf(@RequestParam("username")String username){
        List<User> user=adminService.getSearchUserInf(username);
        Map<String,Object> list=new HashMap<>();
        list.put("tableDataSearch",user);
        return list;

    }

    /**
     * 获取全部用户信息
     *
     * @return
     */
    @GetMapping("/AllUserInfo")
    public Map<String,Object> getAllUserInf(){
        List<User> AllUser=adminService.getAllUserInf();
        Map<String,Object> list=new HashMap<>();
        list.put("tableData1",AllUser);
        return list;
    }

    /**
     * 获取全部老师信息
     *
     * @return
     */
    @GetMapping("/AllTeacherInfo")
    public Map<String,Object> getTeacherInf(){
        List<User> AllUser=adminService.getTeacherInf();
        Map<String,Object> list=new HashMap<>();
        list.put("tableData1",AllUser);
        return list;
    }

    /**
     * 删除用户信息
     *
     * @return
     */
    @GetMapping("/deleteUser")
    public int deleteUser(@RequestParam("username")String username){
        int code=adminService.deleteUser(username);
            if(code==0){
                return 200;
            }else {
                return 401;
            }

    }
}
