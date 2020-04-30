package com.soft.security.model;

import com.soft.common.model.BaseModel;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * @author sucx
 */
@Data
public class SystemUser extends BaseModel implements UserDetails {

    private String userCode;

    private String userName;

    private String password;

    private String phone;

    private String idCard;

    private Set<SystemRole> roles;

    private Set<SystemAuthority> systemAuthorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return systemAuthorities;
    }

    @Override
    public String getUsername() {
        return userCode;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}