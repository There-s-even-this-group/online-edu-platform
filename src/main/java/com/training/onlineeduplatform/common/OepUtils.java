package com.training.onlineeduplatform.common;

import com.training.onlineeduplatform.model.Oep;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created on 2020/1/10.
 *
 * 用以获取登录表Oep中的用户信息
 * 以及全局变量的声明
 *
 * @author Yue Wu
 */
public class OepUtils {

    public static Oep getCurrentRm() {
        return (Oep) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
