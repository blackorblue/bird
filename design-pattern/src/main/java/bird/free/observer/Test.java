package bird.free.observer;

/**
 * @author zhouziyan
 * @date 2019/6/25 17:49
 */
public class Test {


    public static void main(String[] args) {
        Blogger blogger = new Blogger();
        Follower f1= new Follower("阿强");
        Follower f2 = new Follower("阿珍");
        blogger.addFollowers(f1);
        blogger.addFollowers(f2);
        blogger.publishBlog();

    }
}
