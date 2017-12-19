/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/12/15 17:52
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.bean.assignment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class MsxAssignment {
    
    @Id
    @GeneratedValue
    private Integer id;
    private String assignmentName;
    private String remark;
    private Integer ruleId;
    private Boolean finishCheck;
    
    private Date assignmentDate;
    private Integer assignmentHour;
    
    private Timestamp insertTime;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getAssignmentName() {
        return assignmentName;
    }
    
    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }
    
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public Integer getRuleId() {
        return ruleId;
    }
    
    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }
    
    public Boolean getFinishCheck() {
        return finishCheck;
    }
    
    public void setFinishCheck(Boolean finishCheck) {
        this.finishCheck = finishCheck;
    }
    
    public Date getAssignmentDate() {
        return assignmentDate;
    }
    
    public void setAssignmentDate(Date assignmentDate) {
        this.assignmentDate = assignmentDate;
    }
    
    public Integer getAssignmentHour() {
        return assignmentHour;
    }
    
    public void setAssignmentHour(Integer assignmentHour) {
        this.assignmentHour = assignmentHour;
    }
    
    public Timestamp getInsertTime() {
        return insertTime;
    }
    
    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }
}
