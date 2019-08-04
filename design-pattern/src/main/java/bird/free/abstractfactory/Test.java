package bird.free.abstractfactory;

/**
 * @author freebird
 */
public class Test {

    public static void main(String[] args) {
        AbstractHumanFactory factory = new ChineseHumanFactory();
        Human human = factory.createHuman();
        human.eat();
    }
}
