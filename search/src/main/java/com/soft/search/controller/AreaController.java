package com.soft.search.controller;

import com.soft.common.model.ResponseModel;
import com.soft.search.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 地区查询
 * @author sucx
 * @projectName moto_parent
 * @description:
 * @date 2020/5/915:48
 */
@RestController
@RequestMapping("area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("all")
    public ResponseModel searchArea(){
        return ResponseModel.ok("查询成功",areaService.selectArea());
    }
}
