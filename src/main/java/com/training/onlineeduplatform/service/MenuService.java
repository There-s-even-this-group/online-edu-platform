package com.training.onlineeduplatform.service;

import com.training.onlineeduplatform.model.Menu;

import java.util.List;

/**
 * Created on 2020/1/10.
 *
 * @author Yue Wu
 */
public interface MenuService {

    List<Menu> getAllMenu();
    List<Menu> getMenusByHrId();
    List<Menu> menuTree();
    List<Long> getMenusByRid(Long rid);
}
