package bird.free.singleton;

/**
 * @author freebird
 */
public class SingletonV2 {
    /**
     * volatile关键字保证了instance初始化的顺序不会重排序
     * 即：1.为对象分配内存空间
     *     2.初始化对象
     *     3.将对象指向分配的内存空间
     */
    private static volatile SingletonV2 instance = null;

    private SingletonV2(){}


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
