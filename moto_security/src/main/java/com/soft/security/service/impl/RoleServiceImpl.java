package com.soft.security.service.impl;

import com.soft.security.mapper.RoleMapper;
import com.soft.security.model.SystemRole;
import com.soft.security.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sucx
 * @projectName moto
 * @description:
 * @date 2020/4/2216:26
 */
@Slf4j
@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<SystemRole> selectRoleList(SystemRole role) {
        return roleMapper.selectRoleList(role);
    }

    @Override
    public Map<SystemRole, SystemRole> selectRoleMap(SystemRole role) {
        final List<SystemRole> roles = roleMapper.selectRoleList(role);
        Map<SystemRole, SystemRole> result = new HashMap<>(0);
        roles.forEach(item -> result.put(item,item));
        return result;
    }
}
