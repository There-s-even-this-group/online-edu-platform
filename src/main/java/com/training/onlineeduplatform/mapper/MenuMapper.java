package com.training.onlineeduplatform.mapper;

import com.training.onlineeduplatform.model.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2020/1/10.
 *
 * 菜单操作
 *
 * @author Yue Wu
 */
@Mapper
public interface MenuMapper {
    List<Menu> getAllMenu();

    List<Menu> getMenusByHrId(Long hrId);

    List<Menu> menuTree();

    List<Long> getMenusByRid(Long rid);
}
