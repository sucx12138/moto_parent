package com.soft.security.mapper;

import com.soft.security.model.SystemMenu;
import org.springframework.stereotype.Repository;

/**
 * 菜单持久层
 * @author sucx
 */
@Repository
public interface MenuMapper {
    /**
     * 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 新增
     * @param record
     * @return
     */
    int insert(SystemMenu record);

    /**
     * 新增
     * @param record
     * @return
     */
    int insertSelective(SystemMenu record);

    /**
     * 查询
     * @param id
     * @return
     */
    SystemMenu selectByPrimaryKey(String id);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SystemMenu record);

    /**
     *  更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(SystemMenu record);
}