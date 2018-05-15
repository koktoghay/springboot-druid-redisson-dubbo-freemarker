package com.loveq.domain.constant;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author tommy
 */
@Data
@AllArgsConstructor
public class HttpStatusCode {

    private int code;
    private String message;

    // 参照：http://www.cnblogs.com/DeasonGuan/articles/Hanami.html
    // HTTP Status 2xx (成功)
    /**
     * 处理成功
     */
    public static HttpStatusCode OK = new HttpStatusCode(0, "处理成功");

    /**
     * 服务器成功处理了请求，但没有返回任何内容
     */
    public static HttpStatusCode NO_CONTENT = new HttpStatusCode(HttpStatus.NO_CONTENT.value(), "服务器成功处理了请求，但没有返回任何内容");

    // HTTP Status 4xx (请求错误)
    /**
     * 服务未找到
     */
    public static HttpStatusCode NOT_FOUND = new HttpStatusCode(HttpStatus.NOT_FOUND.value(), "服务未找到");

    /**
     * 参数错误
     */
    public static HttpStatusCode EXPECTATION_FAILED = new HttpStatusCode(HttpStatus.EXPECTATION_FAILED.value(), "参数错误");

    // HTTP Status 5xx （服务器错误)
    /**
     * 服务器内部错误
     */
    public static HttpStatusCode INTERNAL_SERVER_ERROR = new HttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误");

    /**
     * 服务不可用
     */
    public static HttpStatusCode SERVICE_UNAVAILABLE = new HttpStatusCode(HttpStatus.SERVICE_UNAVAILABLE.value(), "服务不可用");

    /**
     * 服务器不接受重复请求
     */
    public static HttpStatusCode NOT_ACCEPTABLE = new HttpStatusCode(HttpStatus.NOT_ACCEPTABLE.value(), "服务器不接受重复请求");

    // public static void main(String[] args) {
    // System.out.println(HttpStatusCode.OK);
    // System.out.println(HttpStatusCode.NO_CONTENT);
    // System.out.println(HttpStatusCode.NOT_FOUND);
    // System.out.println(HttpStatusCode.EXPECTATION_FAILED);
    // System.out.println(HttpStatusCode.INTERNAL_SERVER_ERROR);
    // System.out.println(HttpStatusCode.SERVICE_UNAVAILABLE);
    // }
}
