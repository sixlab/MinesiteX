package cn.sixlab.minesitex.data.assignment;

import cn.sixlab.minesitex.bean.assignment.entity.MsxAssignmentRule;
import cn.sixlab.minesitex.lib.base.util.JsonUtl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RuleRepoTest {
    
    @Autowired
    private RuleRepo ruleRepo;
    
    @Test
    public void queryActiveRule() {
        List<MsxAssignmentRule> ruleList = ruleRepo.queryActiveRule(new Date(Instant.now().toEpochMilli()));
    
        System.out.println("--------------");
        System.out.println(ruleList.size());
        System.out.println(JsonUtl.toJson(ruleList));
        System.out.println("--------------");
    }
}