package com.soft.search.service.impl;

import com.soft.search.mapper.OauthCodeMapper;
import com.soft.search.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sucx
 * @projectName moto_parent
 * @description:
 * @date 2020/5/129:49
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private OauthCodeMapper oauthCodeMapper;

    @Override
    public String selectArea() {
        return oauthCodeMapper.selectById("1");
    }
}
