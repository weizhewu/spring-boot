package com.soft1851.springboot.aop.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 田震
 * @ClassName Result
 * @Description 返回给客户端的结果对象
 * @Date 2019/12/1
 * @Version 1.0
 **/
@Data
public class ResponseBean implements Serializable {

    private static final long serialVersionUID = -3948389268046368059L;

    private Integer code;

    private String msg;

    private Object data;

    private ResponseBean() {
    }

    public ResponseBean(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseBean success() {
        ResponseBean result = new ResponseBean();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static ResponseBean success(Object data) {
        ResponseBean result = new ResponseBean();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static ResponseBean failure(ResultCode resultCode) {
        ResponseBean result = new ResponseBean();
        result.setResultCode(resultCode);
        return result;
    }

    public static ResponseBean failure(ResultCode resultCode, Object data) {
        ResponseBean result = new ResponseBean();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    public void setResultCode(ResultCode code) {
        this.code = code.code();
        this.msg = code.message();
    }
}