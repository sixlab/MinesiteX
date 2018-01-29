package cn.sixlab.minesitex.data.assignment;

import cn.sixlab.minesitex.bean.assignment.entity.MsxAssignmentRule;
import cn.sixlab.minesitex.lib.base.util.JsonUtl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RuleRepoTest {
    private static Logger logger = LoggerFactory.getLogger(RuleRepoTest.class);
    
    @Autowired
    private RuleRepo ruleRepo;
    
    @Test
    public void queryActiveRule() {
        List<MsxAssignmentRule> ruleList = ruleRepo.queryActiveRule(new Date(Instant.now().toEpochMilli()));
    
        logger.info("-----------");
        logger.info(ruleList.size()+"");
        logger.info(JsonUtl.toJson(ruleList));
        logger.info("-----------");
    }
}