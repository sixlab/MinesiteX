package cn.sixlab.minesitex.data.assignment;

import cn.sixlab.minesitex.bean.assignment.entity.MsxAssignment;
import cn.sixlab.minesitex.lib.base.util.JsonUtl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AssignmentRepoTest {
    private static Logger logger = LoggerFactory.getLogger(AssignmentRepoTest.class);
    
    @Autowired
    private AssignmentRepo repo;
    
    @Test
    public void findByAssignmentDateOrderByAssignmentHour() {
        List<MsxAssignment> assignmentList = repo.findByAssignmentDateOrderByAssignmentHourAscId(Date.valueOf(LocalDate.now()));
    
        logger.info("----------------");
        logger.info(assignmentList.size()+"");
        for (MsxAssignment msxAssignment : assignmentList) {
            logger.info(JsonUtl.toJson(msxAssignment));
        }
        logger.info("----------------");
    }
    
    @Test
    public void countAllByAssignmentDate() {
        MsxAssignment assignment = repo.findOne(59);
        
        assignment.setId(null);
        assignment.setAssignmentDate(Date.valueOf(LocalDate.now()));
        
        repo.save(assignment);
    
        int count = repo.countAllByAssignmentDate(Date.valueOf(LocalDate.now()));
        
        logger.info("----------------");
        logger.info(count+"");
        logger.info("----------------");
    }
}