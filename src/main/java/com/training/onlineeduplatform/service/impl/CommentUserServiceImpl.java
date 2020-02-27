package com.training.onlineeduplatform.service.impl;

import com.training.onlineeduplatform.mapper.CommentUserMapper;
import com.training.onlineeduplatform.model.CommentUser;
import com.training.onlineeduplatform.service.CommentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2020/2/26.
 *
 * @author Hongwe Xiong
 */
@Service
public class CommentUserServiceImpl implements CommentUserService {
    @Autowired
    CommentUserMapper commentUserMapper;
    @Override
    public int addComment(CommentUser commentUser) {
        return commentUserMapper.addComment(commentUser);
    }

    @Override
    public int deleteComment(CommentUser commentUser) {
        return commentUserMapper.deleteComment(commentUser);
    }

    @Override
    public List<CommentUser> getCommentByArticle(int article_id,int PLCount) {
        return commentUserMapper.getCommentByArticle(article_id,PLCount);
    }

    @Override
    public List<CommentUser> getCommentByUser(String username) {
        return commentUserMapper.getCommentByUser(username);
    }
}
