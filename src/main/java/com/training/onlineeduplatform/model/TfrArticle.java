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
    private int ban;
}
