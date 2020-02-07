package com.training.onlineeduplatform.mapper;

import com.training.onlineeduplatform.model.TfrArticle;

import java.util.List;

/**
 * Created on 2020/2/7.
 *
 * @author Hongwe Xiong
 */
public interface TfrArticleMapper {
    List<TfrArticle> getTfrArticle(TfrArticle tfrArticle);
    void deleteTrfArticle(TfrArticle tfrArticle);
    TfrArticle searchArticle(TfrArticle tfrArticle);
    int updateTfrArticle(TfrArticle tfrArticle);
}
