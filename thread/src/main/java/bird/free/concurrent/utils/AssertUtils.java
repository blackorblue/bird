package bird.free.concurrent.utils;

import bird.free.concurrent.exception.AssertException;

/**
 * @author: zhouziyan
 * @review:
 * @Date: 2019/6/14 10:41
 */
public class AssertUtils {


    public static void isTrue(boolean expression,String msg){
         if(!expression)
             throw new AssertException(msg);
    }
}