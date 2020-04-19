package io.freebird.strategy;

/**
 * @author zhouziyan
 * @date 2019/6/24 14:43
 */
public class Pet {

    private Daily daily;

    public void setDaily(Daily daily){
        this.daily = daily;
    }

    public void eat(){
        daily.eat();
    }
}
