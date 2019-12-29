package com.training.onlineeduplatform.mapper;

import com.training.onlineeduplatform.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2019/12/29.
 *
 * @author Yue Wu
 */
@Mapper
public interface UserMapper {
    List<User> getAll();
}
