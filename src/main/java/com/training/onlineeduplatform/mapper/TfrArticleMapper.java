package com.training.onlineeduplatform.mapper;

import com.training.onlineeduplatform.model.TfrArticle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2020/2/7.
 *
 * @author Hongwe Xiong
 */
@Mapper
public interface TfrArticleMapper {
    List<TfrArticle> getTfrArticle(String articleType);
    void deleteTrfArticle(TfrArticle tfrArticle);
    TfrArticle searchArticle(TfrArticle tfrArticle);
    int updateTfrArticle(TfrArticle tfrArticle);
    List<TfrArticle> getCertainTfrArticle(int id);
}
