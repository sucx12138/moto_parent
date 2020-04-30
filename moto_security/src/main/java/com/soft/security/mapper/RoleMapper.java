package com.soft.security.mapper;

import com.soft.security.model.SystemRole;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author sucx
 */
@Repository
public interface RoleMapper {
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
    int insert(SystemRole record);

    /**
     * 新增
     * @param record
     * @return
     */
    int insertSelective(SystemRole record);

    /**
     * 查询
     * @param id
     * @return
     */
    SystemRole selectByPrimaryKey(String id);

    /**
     * 根据用户查询角色
     * @param userId
     * @return
     */
    Set<SystemRole> selectRoleByUser(String userId);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SystemRole record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(SystemRole record);

    /**
     * 组合条件查询角色列表
     * @param role
     * @return
     */
    List<SystemRole> selectRoleList(SystemRole role);
}