package bird.free.abstractfactory;

/**
 * @author freebird
 */
public class ChineseHumanFactory implements AbstractHumanFactory {


    public Human createChineseHuman() {
        System.out.println("中国制造中国人");
        return new ChineseHuman();
    }

    public Human createBritishHuman() {
        System.out.println("中国制造英国人");
        return new BritishHuman();
    }
}
