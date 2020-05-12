package com.soft.security.model;

import com.soft.common.model.BaseModel;
import lombok.Data;

import java.util.Set;

/**
 * @author sucx
 */
@Data
public class SystemUser extends BaseModel{

    protected String userCode;

    protected String userName;

    protected String password;

    protected String phone;

    protected String idCard;

    protected Set<SystemRole> roles;

    protected Set<SystemAuthority> systemAuthorities;
}