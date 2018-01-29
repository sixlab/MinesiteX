package cn.sixlab.minesitex.data.assignment;

import cn.sixlab.minesitex.bean.assignment.entity.MsxAssignmentRuleDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RuleDetailRepoTest {
    private static Logger logger = LoggerFactory.getLogger(RuleDetailRepoTest.class);
    
    @Autowired
    private RuleDetailRepo ruleDetailRepo;
    
    @Test
    public void queryActiveRuleDetail() {
        List<Integer> is = new ArrayList<>();
        is.add(1);
        is.add(6);
        List<MsxAssignmentRuleDetail> detailList = ruleDetailRepo.findByRuleIdInOrderByRuleHour(is);
    
        logger.info("-----------");
        logger.info(detailList.size()+"");
        for (MsxAssignmentRuleDetail msxAssignmentRuleDetail : detailList) {
            logger.info(msxAssignmentRuleDetail.getId()+"");
        }
        logger.info("-----------");
    }
}