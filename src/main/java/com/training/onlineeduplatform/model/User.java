package com.training.onlineeduplatform.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2019/12/29.
 *
 * @author Yue Wu
 */
@Data
public class User implements Serializable {
    private String username;
    private String password;
}
