package com.training.onlineeduplatform.model;

import lombok.Data;

import java.sql.Date;

/**
 * Created on 2020/2/26.
 *
 * @author Hongwe Xiong
 */

@Data
public class CommentUser {
    private int commentId;
    private String username;
    private int articleID;
    private Date commentDate;
    private String commentContent;
    private int PLcount;
}
