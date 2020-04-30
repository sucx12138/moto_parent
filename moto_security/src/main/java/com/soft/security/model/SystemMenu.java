package com.soft.security.model;

import com.soft.common.model.BaseModel;
import lombok.Data;

/**
 * @author sucx
 */
@Data
public class SystemMenu extends BaseModel {

    private String code;

    private String name;

    private Integer type;

    private String url;

    private String icon;

}