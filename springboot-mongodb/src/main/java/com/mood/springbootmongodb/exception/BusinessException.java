package com.mood.springbootmongodb.exception;

import com.mood.springbootmongodb.enums.AppResultCode;
import lombok.Data;

/**
 * @Created by mood321
 * @Date 2019/8/22 0022
 * @Description 自定义异常
 */
@Data
public class BusinessException extends RuntimeException {

    private int code;

    private String msg;

    private AppResultCode appResultCode;

    public BusinessException() {
        super();
    }

    public BusinessException(AppResultCode appResultCode) {
        super(appResultCode.getMsg());
        this.code = appResultCode.getCode();
        this.msg = appResultCode.getMsg();
        this.appResultCode = appResultCode;
    }
}
