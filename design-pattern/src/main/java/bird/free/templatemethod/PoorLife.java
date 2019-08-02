package bird.free.templatemethod;

/**
 * @author zhouziyan
 * @date 2019/7/9 14:31
 */
public class PoorLife extends BaseLife {


    @Override
    protected void sleep() {
        System.out.println("今天只能睡4个小时...");
    }

    @Override
    protected void eat() {
        System.out.println("今天终于能吃肉了...");
    }
}
