package com.training.onlineeduplatform.util;

import org.springframework.util.DigestUtils;

/**
 * Created on 2020/2/29.
 *
 * @author Yue Wu
 */
public class Md5Encoding {
    private final static String salt="1x2j3x4y5w6t";

    /**
     * md5加盐加密算法
     * 固定盐值
     * @param password
     * @return
     */
    public static String md5SaltEncode(String password){
        String str = "" + salt.charAt(3) + salt + salt.charAt(7) + password + salt.charAt(9);
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
}
