package com.training.onlineeduplatform.service;

import com.training.onlineeduplatform.model.CommentUser;

import java.util.List;

/**
 * Created on 2020/2/26.
 *
 * @author Hongwe Xiong
 */

public interface CommentUserService {
    int addComment(CommentUser commentUser);
    int deleteComment(CommentUser commentUser);
    List<CommentUser> getCommentByArticle(int article_id,int PLCount);
    List<CommentUser> getCommentByUser(String username);
}
