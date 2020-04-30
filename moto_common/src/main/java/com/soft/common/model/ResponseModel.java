package com.soft.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * @author sucx
 * @projectName moto
 * @description: 简单的响应体
 * @date 2020/4/2115:30
 */
@Data
@EqualsAndHashCode
public class ResponseModel {
    public static final String SELECT_SUCCESS = "select success";
    private ResponseModel(int status, Object content, String message) {
        this.content = content;
        this.status = status;
        this.message = message;
    }
    private ResponseModel(int status, String message) {
        this.message = message;
        this.status = status;
    }

    /**
     * 请求成功
     * @param message
     * @return
     */
    static public ResponseModel ok(String message,Object content){
        return new ResponseModel(HttpStatus.OK.value(),content,message);
    }
    static public ResponseModel unauthorized(String message,Object content){
        return new ResponseModel(HttpStatus.UNAUTHORIZED.value(),content,message);
    }
    static public ResponseModel customize(int status,Object content,String message){
        return new ResponseModel(status,content,message);
    }
    private Object content;
    private int status;
    private String message;
}
