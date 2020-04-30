package com.soft.security.model;

import com.soft.common.model.BaseModel;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author sucx
 */
@Data
public class SystemAuthority extends BaseModel  implements GrantedAuthority {

    private String code;

    private String name;

    @Override
    public String getAuthority() {
        return code;
    }
}