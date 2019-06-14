package bird.free.concurrent.demo;

import java.lang.reflect.Field;

/**
 * @author: zhouziyan
 * @review:
 * @Date: 2019/6/14 10:34
 */
public class StaticDemo {

    private static String staticField = "静态变量";

    private String field = "普通字段";

    public StaticDemo() {
        System.out.println("我是构造方法");
    }

    /**
     * 加载顺序 静态变量>静态代码块>普通字段>构造代码块>构造方法
     */
    static {
        try {
            Field filed = StaticDemo.class.getDeclaredField("field");
            filed.setAccessible(true);
            boolean real = filed.getType().getName().equals(String.class.getName());
            if (real) {
                System.out.println(filed.get(new StaticDemo()));
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(staticField);
        // 静态代码块在类加载的时候就会执行
        System.out.println("我是静态代码块...");
    }

    {
        System.out.println(field);
        field = "普通字段";
        // 构造代码块在对象初始化的之前执行
        System.out.println("我是构造代码块...");
    }


    public static void main(String[] args) {
        new StaticDemo();
    }
}


class Child extends StaticDemo {


    public Child() {
        System.out.println("我是儿子构造方法");
    }

    static {
        // 静态代码块在类加载的时候就会执行
        System.out.println("我是儿子静态代码块...");
    }

    {
        // 构造代码块在对象初始化的之前执行
        System.out.println("我是儿子构造代码块...");
    }


    public static void main(String[] args) {
        new Child();
    }
}
