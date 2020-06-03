package com.example.demo.po.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse implements Serializable {

    private Integer code;
    private String msg;
    private Object data;


}
