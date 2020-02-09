package com.training.onlineeduplatform.service;

import com.training.onlineeduplatform.mapper.TfrArticleMapper;
import com.training.onlineeduplatform.model.TfrArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 2020/2/7.
 *
 * @author Hongwe Xiong
 */
@Service
@Transactional
public class TfrArticleService {
    @Autowired
    TfrArticleMapper tfrArticleMapper;
    public List<TfrArticle> getTfrArticle(String articleType){
        return tfrArticleMapper.getTfrArticle(articleType);
    }
    public void deleteTrfArticle(TfrArticle tfrArticle){
        tfrArticleMapper.deleteTrfArticle(tfrArticle);
    }
    public TfrArticle searchArticle(TfrArticle tfrArticle){
        return tfrArticleMapper.searchArticle(tfrArticle);
    }
    public int updateTfrArticle(TfrArticle tfrArticle){
        return tfrArticleMapper.updateTfrArticle(tfrArticle);
    }
    public List<TfrArticle> getCertainTfrArticle(int id){
        return tfrArticleMapper.getCertainTfrArticle(id);
    }
}
