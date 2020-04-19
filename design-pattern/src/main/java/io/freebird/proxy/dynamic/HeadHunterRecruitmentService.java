package io.freebird.proxy.dynamic;

/**
 * @author freebird
 * @date 2020/4/19 13:41
 */
public class HeadHunterRecruitmentService implements RecruitmentService {
    @Override
    public void recuitment(String candidateId) {
        System.out.println("猎头内推了:"+candidateId);
    }
}
