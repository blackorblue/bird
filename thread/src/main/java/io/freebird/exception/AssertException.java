package io.freebird.exception;

/**
 * @author: zhouziyan
 * @review:
 * @date: 2019/6/14 10:45
 */
public class AssertException extends RuntimeException {

    private  String msg;

    public AssertException(String msg) {
        this.msg = msg;
    }



}
