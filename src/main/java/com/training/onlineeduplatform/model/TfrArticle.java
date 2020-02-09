package com.training.onlineeduplatform.model;

import lombok.Data;

import java.io.File;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created on 2020/2/7.
 *
 * @author Hongwe Xiong
 */
@Data
public class TfrArticle  implements Serializable {
    private long article_id;
    private String article_title;
    private String article_sort;
    private String article_author;
    private Date article_date;
    private String article_content;
    private String article_picture;
    private int article_visit;
    private int article_comment;
    private int article_collect;

    public long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(long article_id) {
        this.article_id = article_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_sort() {
        return article_sort;
    }

    public void setArticle_sort(String article_sort) {
        this.article_sort = article_sort;
    }

    public String getArticle_author() {
        return article_author;
    }

    public void setArticle_author(String article_author) {
        this.article_author = article_author;
    }

    public Date getArticle_date() {
        return article_date;
    }

    public void setArticle_date(Date article_date) {
        this.article_date = article_date;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public String getArticle_picture() {
        return article_picture;
    }

    public void setArticle_picture(String article_picture) {
        this.article_picture = article_picture;
    }

    public int getArticle_visit() {
        return article_visit;
    }

    public void setArticle_visit(int article_visit) {
        this.article_visit = article_visit;
    }

    public int getArticle_comment() {
        return article_comment;
    }

    public void setArticle_comment(int article_comment) {
        this.article_comment = article_comment;
    }

    public int getArticle_collect() {
        return article_collect;
    }

    public void setArticle_collect(int article_collect) {
        this.article_collect = article_collect;
    }
}
