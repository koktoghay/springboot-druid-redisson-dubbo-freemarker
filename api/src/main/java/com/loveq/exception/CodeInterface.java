package com.loveq.exception;

/**
 * @author tommy
 */
public interface CodeInterface {
    default int code() {
        return -1;
    }
}
