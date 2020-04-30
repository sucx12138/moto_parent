package com.soft.security.model;

import com.soft.common.model.BaseModel;
import lombok.Data;

/**
 * @author sucx
 */
@Data
public class SystemRole extends BaseModel {
    private String code;

    private String name;
}