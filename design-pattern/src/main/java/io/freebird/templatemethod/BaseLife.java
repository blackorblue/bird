package io.freebird.templatemethod;

/**
 * @author zhouziyan
 * @date 2019/7/9 14:26
 */
public abstract class BaseLife {


    public void daily(){
        eat();
        sleep();
    }

    protected abstract void sleep();

    protected abstract void eat();
}
