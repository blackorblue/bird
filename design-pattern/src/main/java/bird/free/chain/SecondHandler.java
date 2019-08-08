package bird.free.chain;

public class SecondHandler extends AbstractHandler {

    public SecondHandler(int level) {
        super(level);
    }

    @Override
    public void setNextHandler(AbstractHandler handler) {
        super.setNextHandler(handler);
    }
    protected void doHandle() {
        System.out.println("第二级别的处理");
    }
}
