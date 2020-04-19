package io.freebird.proxy.dynamic;

/**
 * @author freebird
 * @date 2020/4/19 13:38
 * @desc 员工招聘
 */
public class StaffRecruitmentService implements RecruitmentService {


    @Override
    public void recuitment(String candidateId) {
        System.out.println("员工内推了:"+candidateId);
    }
}
