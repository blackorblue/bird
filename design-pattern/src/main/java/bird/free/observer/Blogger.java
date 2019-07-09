package bird.free.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouziyan
 * @date 2019/6/25 17:32
 */
public class Blogger {


    private final List<Follower> fans = new ArrayList<Follower>();


    public void addFollowers(Follower follower) {
        fans.add(follower);
    }

    public void publishBlog() {
        for (Follower fan : fans) {
            fan.receiveBlog(fan.getNickName() + "收到一条消息:很高心能够遇见你们!");
        }
    }

    public boolean removeFollowers(Follower follower) {
        return fans.remove(follower);
    }


}
