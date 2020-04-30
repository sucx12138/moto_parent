package com.soft.security.mapper;

import com.soft.security.model.SystemAuthority;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * 权限持久层
 * @author sucx
 */
@Repository
public interface AuthorityMapper {
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
    int insert(SystemAuthority record);

    /**
     * 新增
     * @param record
     * @return
     */
    int insertSelective(SystemAuthority record);

    /**
     * 查询
     * @param id
     * @return
     */
    SystemAuthority selectByPrimaryKey(String id);

    /**
     * 根据用户查询权限
     * @param userId
     * @return
     */
    Set<SystemAuthority> selectAuthorityByUser(String userId);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SystemAuthority record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(SystemAuthority record);
}