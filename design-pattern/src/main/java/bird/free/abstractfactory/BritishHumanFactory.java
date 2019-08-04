package bird.free.abstractfactory;

/**
 * @author freebird
 */
public class BritishHumanFactory implements AbstractHumanFactory {


    public Human createHuman() {
        return new BritishHuman();
    }
}
