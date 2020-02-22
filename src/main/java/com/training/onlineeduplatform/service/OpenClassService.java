package com.training.onlineeduplatform.service;

import com.training.onlineeduplatform.model.OpenClass;

import java.util.List;

/**
 * Created on 2020/2/22.
 *
 * @author Hongwe Xiong
 */
public interface OpenClassService {
    List<OpenClass> getOpenClassByClassType(String public_classType);
    List<OpenClass> getOpenClassByClassID(int public_classID);
    int deleteOpenClass(int public_classID);
    int updateOpenClassByClassID(OpenClass openClass);
    int addOpenClass(OpenClass openClass);
    int getLAST_INSERT_ID();
}
