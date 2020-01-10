package com.training.onlineeduplatform.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2020/1/10.
 *
 * @author Yue Wu
 */
@Data
public class Role implements Serializable {
    private Long id;
    private String name;
    private String nameZh;
}
