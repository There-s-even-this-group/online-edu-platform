package com.training.onlineeduplatform.controller.user;

import com.training.onlineeduplatform.model.common.ResultMap;
import com.training.onlineeduplatform.service.UserService;
import com.training.onlineeduplatform.util.JWTUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created on 2020/3/8.
 *
 * 签到 Controller
 *
 * @author Yue Wu
 */
@RestController
@RequestMapping(value = "/op")
public class SignInController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResultMap resultMap;

    /**
     * 签到功能
     *
     * 状态码说明：
     * code : 20010 & message : 今日已签到 => 防止重复签到导致触发opSignIn触发器
     * code : 20011 & message : 连续签到十天，获得100托福币 => 连续签到奖励（增加货币功能交由触发器执行）
     * code : 200 & message : 签到成功 => 签到基础功能（剩余逻辑交由触发器执行）
     *
     * @param token 凭证
     * @return
     */
    @GetMapping("/signIn")
    @RequiresRoles(logical = Logical.OR, value = {"user","admin"})
    public ResultMap signIn(@RequestHeader String token) {
        resultMap.clear();
        String username = JWTUtil.getUsername(token);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(date);
        String target = dateFormat.format(userService.getLastSign(username));
        int frequency = userService.getFrequency(username);
        if (today.equals(target)) {
            if (frequency % 10 == 0) {
                return resultMap.success().code(20011).message("连续签到"+ frequency +"天，获得100托福币");
            } else {
                return resultMap.success().code(20010).message("今日已签到");
            }
        } else {
            userService.signUp(username);
            return resultMap.success().code(200).message("签到成功");
        }
    }

    /**
     * 判断当前用户是否签到
     *
     * 状态码说明：
     * code : 20010 & message : Yes => 当前已经签到
     * code : 200 & message : No => 当前还未进行签到
     *
     * @param token 凭证
     * @return
     */
    @GetMapping("/ifSignIn")
    @RequiresRoles(logical = Logical.OR, value = {"user","admin"})
    public ResultMap getLastSign(@RequestHeader String token) {
        resultMap.clear();
        String username = JWTUtil.getUsername(token);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(date);
        String target = dateFormat.format(userService.getLastSign(username));
        if (today.equals(target)) {
            return resultMap.success().code(20010).message("Yes");
        } else {
            return resultMap.success().code(200).message("No");
        }
    }

    /**
     * 获取连续签到天数，为显示奖励倒计时预留
     * @param token 凭证
     * @return 天数
     */
    @GetMapping("/getFrequency")
    @RequiresRoles(logical = Logical.OR, value = {"user","admin"})
    public ResultMap getFrequency(@RequestHeader String token) {
        resultMap.clear();
        String username = JWTUtil.getUsername(token);
        return resultMap.success().message(userService.getFrequency(username));
    }
}
