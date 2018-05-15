package com.loveq.domain.constant;

import com.loveq.exception.CodeInterface;
import com.loveq.exception.EC;

public interface BusinessCode {

    interface System extends CodeInterface {
        /**
         * 请求ok
         */
        EC OK = EC.of(HttpStatusCode.OK.getCode(), HttpStatusCode.OK.getMessage());

        /**
         * 服务器成功处理了请求，但没有返回任何内容
         */
        EC NO_CONTENT = EC.of(HttpStatusCode.NO_CONTENT.getCode(), HttpStatusCode.NO_CONTENT.getMessage());

        /**
         * 服务未找到
         */
        EC NOT_FOUND = EC.of(HttpStatusCode.NOT_FOUND.getCode(), HttpStatusCode.NOT_FOUND.getMessage());

        /**
         * 参数错误
         */
        EC EXPECTATION_FAILED = EC.of(HttpStatusCode.EXPECTATION_FAILED.getCode(), HttpStatusCode.EXPECTATION_FAILED.getMessage());

        /**
         * 服务器内部错误
         */
        EC INTERNAL_SERVER_ERROR = EC.of(HttpStatusCode.INTERNAL_SERVER_ERROR.getCode(), HttpStatusCode.INTERNAL_SERVER_ERROR.getMessage());

        /**
         * 服务不可用
         */
        EC SERVICE_UNAVAILABLE = EC.of(HttpStatusCode.SERVICE_UNAVAILABLE.getCode(), HttpStatusCode.SERVICE_UNAVAILABLE.getMessage());

    }

}
