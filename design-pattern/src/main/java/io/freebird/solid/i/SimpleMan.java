package io.freebird.solid.i;

/**
 * @author freebird
 * @date 2020/4/24 21:58
 */
public class SimpleMan implements Eatable,Walkable,Sleepable {
    @Override
    public void eat() {
        System.out.println("我吃粑粑...");
    }

    @Override
    public void walk() {
        System.out.println("我走不动...");
    }

    @Override
    public void sleep() {
        System.out.println("我只想睡觉，不想加班...");
    }
}
