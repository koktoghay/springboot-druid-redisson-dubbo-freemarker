package com.loveq.exception;

import lombok.Data;

import java.util.Map;

/**
 * @author tommy
 */
@Data
public class FrontendException extends GoldException {
    private int code;
    private String message;

    private Map<String, Object> extraInfo;

    public FrontendException(int code) {
        this(code, "", null);
    }

    public FrontendException(ServiceException e) {
        this(e.getCode(), e.getMessage());
    }

    public FrontendException(int code, String message) {
        this(code, message, null);
    }

    public FrontendException(int code, String message, Map<String, Object> extraInfo) {
        this.code = code;
        this.message = message;
        this.extraInfo = extraInfo;
    }

    public FrontendException(EC errorCode) {
        this(errorCode.getCode(), errorCode.getMessage(), null);
    }
}
