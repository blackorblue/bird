package bird.free.chain;

/**
 * @author freebird
 */
public class ThirdHandler extends AbstractHandler {


    public ThirdHandler(int level) {
        super(level);
    }


    @Override
    protected void doHandle() {
        System.out.println("第三级别的处理");
    }
}
