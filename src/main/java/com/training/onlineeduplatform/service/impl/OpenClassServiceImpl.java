package com.training.onlineeduplatform.service.impl;

import com.training.onlineeduplatform.mapper.OpenClassMapper;
import com.training.onlineeduplatform.model.OpenClass;
import com.training.onlineeduplatform.service.OpenClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2020/2/22.
 *
 * @author Hongwe Xiong
 */
@Service
public class OpenClassServiceImpl implements OpenClassService {
    @Autowired
    OpenClassMapper openClassMapper;

    @Override
    public List<OpenClass> getOpenClassByClassType(String public_classType){
        return openClassMapper.getOpenClassByClassType(public_classType);
    }

    @Override
    public List<OpenClass> getOpenClassByClassID(int public_classID) {
        return openClassMapper.getOpenClassByClassID(public_classID);
    }

    @Override
    public int deleteOpenClass(int public_classID) {
        return openClassMapper.deleteOpenClass(public_classID);
    }

    @Override
    public int updateOpenClassByClassID(OpenClass openClass) {
        return openClassMapper.updateOpenClassByClassID(openClass);
    }

    @Override
    public int addOpenClass(OpenClass openClass) {
        return openClassMapper.addOpenClass(openClass);
    }

    @Override
    public int getLAST_INSERT_ID() {
        return openClassMapper.getLAST_INSERT_ID();
    }

    @Override
    public int baoming(int public_id){
        return openClassMapper.baoming(public_id);
    }

    @Override
    public List<OpenClass> getOpenClassByClassAll(String username){
        return openClassMapper.getOpenClassByClassAll(username);
    }
}
