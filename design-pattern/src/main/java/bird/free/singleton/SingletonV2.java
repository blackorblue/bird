package bird.free.singleton;

/**
 * @author freebird
 */
public class SingletonV2 {

    private static volatile SingletonV2 instance = null;

    private SingletonV2(){}

    /**
     * TODO 依然存在问题:假如第二个线程进入的时候对象还未实例化完成，那么读到的依然为null。
     */
    public static SingletonV2 getInstance(){
        if(instance == null){
            synchronized (SingletonV2.class){
                if(instance == null){
                    instance = new SingletonV2();
                }
            }
        }
        return instance;
    }
}
