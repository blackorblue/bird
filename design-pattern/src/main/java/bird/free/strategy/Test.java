package bird.free.strategy;

/**
 * @author zhouziyan
 * @date 2019/6/24 14:46
 */
public class Test {

    public static void main(String[] args) {
        /**
         * 策略模式赋予对象一种行为状态或者特征,
         * 对象会根据不同的状态做出不同的行为.
         * 例如:人 开心和伤心做同样一件事的过程或者结果是可能有所差异的.
         * 主要是为了遵循开闭原则而出现的设计模式.
         */
        Pet dog = new Pet();
        dog.setDaily(new DogDaily());
        dog.eat();
        Pet cat = new Pet();
        cat.setDaily(new CatDaily());
        cat.eat();
    }
}
