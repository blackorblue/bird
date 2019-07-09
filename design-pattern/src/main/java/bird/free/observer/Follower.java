package bird.free.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouziyan
 * @date 2019/6/25 17:33
 */
public class Follower {

    private String nickName;

    private Boolean manual;

    private List<Blogger> bloggers = new ArrayList();

    public Follower(String nickName) {
        this.nickName = nickName;
    }

    public void receiveBlog(String msg) {
        System.out.println(msg);
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Boolean getManual() {
        return manual;
    }

    public void setManual(Boolean manual) {
        this.manual = manual;
    }

    public void follow(Blogger blogger) {
        blogger.addFollowers(this);
        bloggers.add(blogger);
    }
}
