package io.freebird.jvm;

public class FinalizeEscapeGC {

    private static FinalizeEscapeGC SAVE_HOOK = null;

    /**
     * this调用{@link FinalizeEscapeGC#finalize()}
     * 会将自己放入一个F-queue中按序执行。
     * finalize()中可以通过对将被回收的自己建立引用来进行自救
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method execute");
        SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        SAVE_HOOK = null;
        // 在执行gc之前会执行对象的finalize()方法
        System.gc();

        Thread.sleep(500);
        // 进行了自救，因为在finalize中重新被引用
        if(SAVE_HOOK != null){
            System.out.println("i'm still alive..");
        }else {
            System.out.println("i'm dead :(");
        }


        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        // 没有自救成功，因为finalize方法只会自动执行一次
        if(SAVE_HOOK != null){
            System.out.println("i'm still alive..");
        }else {
            System.out.println("i'm dead :(");
        }
    }
}
