package com.training.onlineeduplatform.service.impl;

import com.training.onlineeduplatform.common.OepUtils;
import com.training.onlineeduplatform.mapper.MenuMapper;
import com.training.onlineeduplatform.model.Menu;
import com.training.onlineeduplatform.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 2020/1/10.
 *
 * @author Yue Wu
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    //@Cacheable(key = "#root.methodName")
    public List<Menu> getAllMenu(){
        return menuMapper.getAllMenu();
    }

    public List<Menu> getMenusByHrId() {
        return menuMapper.getMenusByHrId(Long.valueOf(OepUtils.getCurrentRm().getId()));
    }

    public List<Menu> menuTree() {
        return menuMapper.menuTree();
    }

    public List<Long> getMenusByRid(Long rid) {
        return menuMapper.getMenusByRid(rid);
    }
}
