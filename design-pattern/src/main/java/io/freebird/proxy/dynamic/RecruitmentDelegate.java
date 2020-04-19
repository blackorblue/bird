package io.freebird.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author freebird
 * @date 2020/4/19 16:04
 */
public class RecruitmentDelegate implements InvocationHandler {
    private Object target;

    public RecruitmentDelegate(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object invokeResult = method.invoke(target, args);
        return invokeResult;
    }
}
