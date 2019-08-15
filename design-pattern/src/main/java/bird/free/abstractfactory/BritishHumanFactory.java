package bird.free.abstractfactory;

/**
 * @author freebird
 */
public class BritishHumanFactory implements AbstractHumanFactory {


    public Human createChineseHuman() {
        System.out.println("英国制造中国人");
        return new ChineseHuman();
    }

    public Human createBritishHuman() {
        System.out.println("英国制造英国人");
        return new BritishHuman();
    }
}
