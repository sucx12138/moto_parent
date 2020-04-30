package com.soft.security.service;


import com.soft.security.model.SystemRole;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

/**
 * @author sucx
 * @projectName moto
 * @description:
 * @date 2020/4/2216:26
 */
@CacheConfig(cacheNames = "role")
public interface RoleService {
    /**
     * 查询角色树
     * @param role
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    List<SystemRole> selectRoleList(SystemRole role);

    /**
     *查询Map
     * @param role
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    Map<SystemRole, SystemRole> selectRoleMap(SystemRole role);
}
