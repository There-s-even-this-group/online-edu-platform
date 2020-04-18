package com.training.onlineeduplatform.controller;

import com.training.onlineeduplatform.model.CommentUser;
import com.training.onlineeduplatform.service.CommentUserService;
import com.training.onlineeduplatform.util.JWTUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2020/2/26.
 *
 * @author Hongwe Xiong
 */
@RestController
public class CommentUserController {
    @Autowired
    CommentUserService commentUserService;

    @GetMapping(value = "/getCommentByArticle/{article_id}/{PLCount}")
    public Map<String, Object> getCommentByArticle(@PathVariable int article_id,@PathVariable int PLCount) {
        Map<String, Object> map = new HashMap<>();
        List<CommentUser> list = commentUserService.getCommentByArticle(article_id,PLCount);
        map.put("list",list);
        return map;
    }

    @GetMapping(value = "/getCommentByUser/{username}")
    public Map<String, Object> getCommentByUser(@PathVariable String username) {
        Map<String, Object> map = new HashMap<>();
        List<CommentUser> list = commentUserService.getCommentByUser(username);
        map.put("list",list);
        return map;
    }

    @PostMapping(value = "/addComment")
    @RequiresRoles(logical = Logical.OR,value = {"user","admin"})
    public int addComment(@RequestHeader String token, CommentUser commentUser){
        String username = JWTUtil.getUsername(token);
        commentUser.setUsername(username);
        return commentUserService.addComment(commentUser);
    }

}
