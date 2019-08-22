package com.springbootshiro.exception;

import com.springbootshiro.enums.AppResultCode;
import lombok.Data;

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
