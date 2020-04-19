package io.freebird.util;

import io.freebird.exception.AssertException;

/**
 * @author: zhouziyan
 * @review:
 * @date: 2019/6/14 10:41
 */
public final class AssertUtils {


    public static boolean isTrue(boolean expression,String msg){
         if(!expression)
             throw new AssertException(msg);
         return expression;
    }
}
