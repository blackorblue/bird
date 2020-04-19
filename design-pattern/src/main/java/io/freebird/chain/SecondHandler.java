package io.freebird.chain;

public class SecondHandler extends AbstractHandler {

    public SecondHandler(int level) {
        super(level);
    }


    protected void doHandle() {
        System.out.println("第二级别的处理");
    }
}
