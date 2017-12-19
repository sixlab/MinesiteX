package cn.sixlab.minesitex.data.assignment;

import cn.sixlab.minesitex.bean.assignment.entity.MsxAssignment;
import cn.sixlab.minesitex.lib.base.util.JsonUtl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AssignmentRepoTest {
    
    @Autowired
    private AssignmentRepo repo;
    
    @Test
    public void findByAssignmentDateOrderByAssignmentHour() {
        List<MsxAssignment> assignmentList = repo.findByAssignmentDateOrderByAssignmentHourAscId(Date.valueOf(LocalDate.now()));
    
        System.out.println("----------------");
        System.out.println(assignmentList.size());
        for (MsxAssignment msxAssignment : assignmentList) {
            System.out.println(JsonUtl.toJson(msxAssignment));
        }
        System.out.println("----------------");
    }
}