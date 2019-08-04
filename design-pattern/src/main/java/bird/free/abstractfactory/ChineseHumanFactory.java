package bird.free.abstractfactory;

/**
 * @author freebird
 */
public class ChineseHumanFactory implements AbstractHumanFactory {

    public Human createHuman() {
        return new ChineseHuman();
    }
}
