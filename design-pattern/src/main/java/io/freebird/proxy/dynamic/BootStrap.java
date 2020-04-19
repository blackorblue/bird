package io.freebird.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author freebird
 * @date 2020/4/19 13:42
 */
public class BootStrap {

    public static void main(String[] args) {
        BootStrap bootStrap = new BootStrap();
        RecruitmentService recruitmentService = new HeadHunterRecruitmentService();
        InvocationHandler delegateInvoker = new RecruitmentDelegate(recruitmentService);
        bootStrap.start(recruitmentService,delegateInvoker);
    }

    private void start(RecruitmentService recruitmentService, InvocationHandler delegateInvoker) {
        RecruitmentService proxyInstance = (RecruitmentService)Proxy.newProxyInstance(recruitmentService.getClass().getClassLoader(), recruitmentService.getClass().getInterfaces(), delegateInvoker);
        System.out.println(proxyInstance);
        System.out.println("==============");
        proxyInstance.recuitment("张三");
    }
}
