package com.mood.springbootmongodb.enums;

/**
 * @Created by mood321
 * @Date 2019/8/22 0022
 * @Description TODO
 */
public enum AppResultCode {

    SUCCESS(200,"成功"),

    FAIL(-1, "操作失败,请稍候再试!"),

    USER_NOT_EXIST(100, "用户不存在!");

    private final int code;

    private final String msg;

    AppResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
