package com.soft1851.springboot.aop.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @ClassName StingUtil
 * @Description 使用一个枚举全局管理API状态码，这对线上环境定位错误问题和后续接口文档的维护都是很有帮助
 * @Date 2019/12/1
 * @Version 1.0
 **/
public enum ResultCode {
    /* 成功状态码 */
    SUCCESS(1, "用户访问成功"),

    /* 参数错误：10001-19999 */
    USER_NOT_LOGIN(10001, "用户未登录"),
    USER_NOT_ACCESS(10002, "用户无权限"),
    USER_NOT_EXIST(10003, "用户不存在"),
    USER_PASSWORD_WRONG(10004,"用户密码错误");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }


    /**
     * 校验重复的code值
     *
     * @param args
     */
    public static void main(String[] args) {
        ResultCode[] ApiResultCodes = ResultCode.values();
        List<Integer> codeList = new ArrayList<Integer>();
        for (ResultCode ApiResultCode : ApiResultCodes) {
            if (codeList.contains(ApiResultCode.code)) {
                System.out.println(ApiResultCode.code);
            } else {
                codeList.add(ApiResultCode.code());
            }
        }
    }
}
