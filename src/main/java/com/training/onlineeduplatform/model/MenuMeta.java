package com.training.onlineeduplatform.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2020/1/10.
 *
 * @author Yue Wu
 */
@Data
public class MenuMeta implements Serializable {
    private boolean keepAlive;
    private boolean requireAuth;
}
