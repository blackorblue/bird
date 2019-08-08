package chain;

public class FirstHandler extends AbstractHandler {

    public FirstHandler(int level) {
        super(level);
    }

    @Override
    public void setNextHandler(AbstractHandler handler) {
        super.setNextHandler(handler);
    }

    protected void doHandle() {
        System.out.println("第一级别的处理");
    }
}
