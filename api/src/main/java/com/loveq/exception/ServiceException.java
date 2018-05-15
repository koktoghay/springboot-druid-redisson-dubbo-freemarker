package com.loveq.exception;

import lombok.Data;

import java.util.Map;

/**
 * @author tommy
 */
@Data
public class ServiceException extends GoldException {
    private int code;
    private String message;

    private Map<String, Object> extraInfo;

    public ServiceException(int code) {
        this(code, "", null);
    }

    public ServiceException(String message) {
        this(404, message, null);
    }

    public ServiceException(int code, String message) {
        this(code, message, null);
    }

    public ServiceException(int code, String message, Map<String, Object> extraInfo) {
        this.code = code;
        this.message = message;
        this.extraInfo = extraInfo;
    }

    public ServiceException(EC errorCode) {
        this(errorCode.getCode(), errorCode.getMessage(), null);
    }

}
