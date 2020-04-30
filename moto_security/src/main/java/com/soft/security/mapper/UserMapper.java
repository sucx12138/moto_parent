package com.soft.security.mapper;


import com.soft.security.model.SystemUser;
import org.springframework.stereotype.Repository;

/**
 *  用户持久层
 * @author sucx
 */
@Repository
public interface UserMapper {
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
    int insert(SystemUser record);

    /**
     * 新增
     * @param record
     * @return
     */
    int insertSelective(SystemUser record);

    /**
     * 查询
     * @param id
     * @return
     */
    SystemUser selectByPrimaryKey(String id);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SystemUser record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(SystemUser record);

    /**
     * 根据用户账户查询
     * @param userCode
     * @return
     */
    SystemUser selectUserByUserCode(String userCode);
}