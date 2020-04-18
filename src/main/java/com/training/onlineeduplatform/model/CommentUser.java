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

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getPLcount() {
        return PLcount;
    }

    public void setPLcount(int PLcount) {
        this.PLcount = PLcount;
    }
}
