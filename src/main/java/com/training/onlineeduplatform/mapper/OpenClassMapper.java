package com.training.onlineeduplatform.mapper;

import com.training.onlineeduplatform.model.OpenClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2020/2/22.
 *
 * @author Hongwe Xiong
 */
@Mapper
public interface OpenClassMapper {
    List<OpenClass> getOpenClassByClassType(String public_classType);
    List<OpenClass> getOpenClassByClassID(int public_classID);
    int deleteOpenClass(int public_classID);
    int updateOpenClassByClassID(OpenClass openClass);
    int addOpenClass(OpenClass openClass);
    int getLAST_INSERT_ID();
    int baoming(int public_id);
    List<OpenClass> getOpenClassByClassAll(String username);
}
