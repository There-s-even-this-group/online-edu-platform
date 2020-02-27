package com.training.onlineeduplatform.mapper;

import com.training.onlineeduplatform.model.CommentUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2020/2/26.
 *
 * @author Hongwe Xiong
 */

@Mapper
public interface CommentUserMapper {
    int addComment(CommentUser commentUser);
    int deleteComment(CommentUser commentUser);
    List<CommentUser> getCommentByArticle(int article_id,int PLCount);
    List<CommentUser> getCommentByUser(String username);
}
