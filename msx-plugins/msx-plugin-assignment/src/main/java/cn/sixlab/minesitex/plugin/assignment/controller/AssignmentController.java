/**
 * Copyright (c) 2018 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2018/1/15 16:07
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.plugin.assignment.controller;

import cn.sixlab.minesitex.bean.assignment.entity.MsxAssignment;
import cn.sixlab.minesitex.bean.assignment.entity.MsxAssignmentRule;
import cn.sixlab.minesitex.lib.base.BaseController;
import cn.sixlab.minesitex.lib.base.model.ModelJson;
import cn.sixlab.minesitex.plugin.assignment.service.AssignmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/assignment")
public class AssignmentController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(AssignmentPubController.class);
    
    @Autowired
    private AssignmentService assignmentService;
    
    @GetMapping(value = "/{year}/{month}/{day}")
    public ModelJson<List<List<MsxAssignment>>> assignment(@PathVariable("year") Integer year,
            @PathVariable("month") Integer month,
            @PathVariable("day") Integer day) {
    
        LocalDate localDate = LocalDate.of(year, month, day);
        List<List<MsxAssignment>> assignmentList = assignmentService.getAssignment(Date.valueOf(localDate));
        
        ModelJson<List<List<MsxAssignment>>> json = new ModelJson<>();
        return json.setData(assignmentList);
    }
    
    @GetMapping(value = "/rules")
    public ModelJson<List<MsxAssignmentRule>> rules() {
        logger.debug("rules");
    
        List<MsxAssignmentRule> ruleList = assignmentService.getAssignments();
    
        ModelJson<List<MsxAssignmentRule>> json = new ModelJson<>();
        return json.setData(ruleList);
    }
    
    @PutMapping("/finish/{assignmentId}/{status}")
    public ModelJson<MsxAssignment> finish(@PathVariable Integer assignmentId,
            @PathVariable boolean status) {
        logger.debug("finish");
        
        ModelJson<MsxAssignment> result = new ModelJson<>();
        
        MsxAssignment assignment = assignmentService.changeStatus(assignmentId, status);
        
        return result.setData(assignment);
    }
}
