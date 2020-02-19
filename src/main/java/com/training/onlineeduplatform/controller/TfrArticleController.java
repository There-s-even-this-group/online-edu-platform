package com.training.onlineeduplatform.controller;

import com.training.onlineeduplatform.model.TfrArticle;
import com.training.onlineeduplatform.service.impl.TfrArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2020/2/9.
 *
 * @author Hongwe Xiong
 */
@RestController
@RequestMapping(value = "/tfrArticle")
public class TfrArticleController {
    @Autowired
    TfrArticleService tfrArticleService;

    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public Map<String,Object> getTfrHomeData(String articleType) {
        Map<String, Object> map = new HashMap<>();
        List<TfrArticle> list = tfrArticleService.getTfrArticle(articleType);
        map.put("list",list);
        return map;
    }

    @RequestMapping(value = "/ArticleDetail",method = RequestMethod.POST)
    public Map<String,Object> getTfrCertainArticle(int id) {
        Map<String, Object> map = new HashMap<>();
        List<TfrArticle> list = tfrArticleService.getCertainTfrArticle(id);
        map.put("list",list);
        return map;
    }

    @RequestMapping(value = "/addArticle",method = RequestMethod.POST)
    public int addArticle(TfrArticle tfrArticle){
        return tfrArticleService.addTfrArticle(tfrArticle);
    }
//    public List<TfrArticle> formatArticleDate(List<TfrArticle> list){
//        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
//
//        for(TfrArticle r : list) {
//        }
//    }
}
