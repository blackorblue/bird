package io.freebird.concurrent.utils;

import io.freebird.concurrent.exception.AssertException;

/**
 * @author: zhouziyan
 * @review:
 * @Date: 2019/6/14 10:41
 */
public class AssertUtils {


    public static boolean isTrue(boolean expression,String msg){
         if(!expression)
             throw new AssertException(msg);
         return expression;
    }
}
