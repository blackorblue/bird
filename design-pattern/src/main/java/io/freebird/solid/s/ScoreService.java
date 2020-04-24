package io.freebird.solid.s;

/**
 * @author freebird
 * @date 2020/4/24 22:16
 */
public class ScoreService {

    UserRepository userRepository;

    UserScoreRepository userScoreRepository;

    public ScoreService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ScoreService(UserScoreRepository userScoreRepository) {
        this.userScoreRepository = userScoreRepository;
    }

    /**
     * 错误的示范，在用户表更新用户的成绩信息
     * 虽然成绩与用户有强关联，但是从面向对象的角度说。用户基础表应该与业务解耦。
     * @param score
     * @param uid
     */
    public void saveScore(String score, String uid){
        User user = new User();
        user.setUid(uid);
        user.setScore(score);
        userRepository.updateScorebyUid(user);
    }

    /**
     * 正确的示范，用户的成绩应该与成绩表紧紧耦合
     * @param score
     * @param uid
     */
    public void saveUserScore(String score, String uid){
        UserScore user = new UserScore();
        user.setUid(uid);
        user.setScore(score);
        userScoreRepository.updateByUid(user);
    }
}
