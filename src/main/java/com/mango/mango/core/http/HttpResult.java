package com.mango.mango.core.http;

import lombok.Data;

import static com.mango.mango.core.http.HttpStatus.*;

/**
 * @ClassName HttpResult
 * @Description TODO
 * @Autgor huang
 * @Date 2020-02-23 10:39
 */
@Data
public class HttpResult {

    private int code = 200;

    private String msg;

    private Object data;

    public static HttpResult error() {
        return error(SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static HttpResult error(String msg) {
        return error(SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static HttpResult error(int code, String msg) {
        HttpResult result = new HttpResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static HttpResult ok(Object data) {
        HttpResult result = new HttpResult();
        result.setData(data);
        return result;
    }

    public static HttpResult ok() {
        return  new HttpResult();
    }
}
