package io.freebird.solid.i;

/**
 * @author freebird
 * @date 2020/4/24 22:05
 */
public class DisabledMan implements Eatable,Sleepable {
    @Override
    public void eat() {
        System.out.println("我能吃莽莽");
    }

    @Override
    public void sleep() {
        System.out.println("我能睡觉觉");
    }
}
