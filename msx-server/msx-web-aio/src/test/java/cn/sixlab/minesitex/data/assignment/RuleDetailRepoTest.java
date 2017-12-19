package cn.sixlab.minesitex.data.assignment;

import cn.sixlab.minesitex.bean.assignment.entity.MsxAssignmentRuleDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RuleDetailRepoTest {
    
    @Autowired
    private RuleDetailRepo ruleDetailRepo;
    
    @Test
    public void queryActiveRuleDetail() {
        List<Integer> is = new ArrayList<>();
        is.add(1);
        is.add(6);
        List<MsxAssignmentRuleDetail> detailList = ruleDetailRepo.findByRuleIdInOrderByRuleHour(is);
    
        System.out.println("-----------");
        System.out.println(detailList.size());
        for (MsxAssignmentRuleDetail msxAssignmentRuleDetail : detailList) {
            System.out.println(msxAssignmentRuleDetail.getId());
        }
        System.out.println("-----------");
    }
}