package chain;

public abstract class AbstractHandler {

    private AbstractHandler nextHandler;
    private   int level = 1;

    public AbstractHandler(int level) {
        this.level = level;
    }

    public void setNextHandler(AbstractHandler handler){
        this.nextHandler = handler;
    }

    public final void handle(int level){
        if(level == this.level){
            this.doHandle();
        } else {
            if(nextHandler != null){
                nextHandler.handle(level);
            }else {
                System.out.println("没有能够处理的...");
            }
        }
    }

    protected abstract void doHandle();
}
