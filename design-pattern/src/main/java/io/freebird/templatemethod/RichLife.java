package io.freebird.templatemethod;

/**
 * @author zhouziyan
 * @date 2019/7/9 14:29
 */
public class RichLife extends BaseLife {

    @Override
    protected void sleep() {
        System.out.println("今天和哪个妹子睡觉呢...?");
    }

    @Override
    protected void eat() {
        System.out.println("今天吃哪家米其林餐厅呢..?");
    }
}
