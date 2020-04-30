package com.soft.security.controller;

import com.soft.common.model.ResponseModel;
import com.soft.security.model.SystemRole;
import com.soft.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author sucx
 * @projectName moto
 * @description:
 * @date 2020/4/2216:02
 */
@RestController
@RequestMapping("/system")
public class RoleController {


    @Autowired
    private RoleService roleService;
    @GetMapping("/roleList")
    @PreAuthorize("hasAuthority('code_1')")
    public ResponseModel selectRoleList(SystemRole role){
        final List<SystemRole> roles = roleService.selectRoleList(role);
        return ResponseModel.ok(ResponseModel.SELECT_SUCCESS,roles);
    }

    @GetMapping("/roleMap")
    @PreAuthorize("hasAuthority('code_1')")
    public ResponseModel selectRoleMap(SystemRole role){
        final Map<SystemRole, SystemRole> roles = roleService.selectRoleMap(role);
        return ResponseModel.ok(ResponseModel.SELECT_SUCCESS,roles);
    }
}
