package bird.free.chain;

public class FirstHandler extends AbstractHandler {

    public FirstHandler(int level) {
        super(level);
    }


    protected void doHandle() {
        System.out.println("第一级别的处理");
    }
}
