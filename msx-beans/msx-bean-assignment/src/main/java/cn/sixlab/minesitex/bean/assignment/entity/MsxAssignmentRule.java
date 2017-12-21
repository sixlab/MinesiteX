/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/12/15 17:55
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.bean.assignment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class MsxAssignmentRule {
    @Id
    @GeneratedValue
    private Integer id;
    private String ruleName;
    private String ruleRemark;
    
    private Date beginDate;
    private Date endDate;
    
    private Integer ruleOrder;
    private Timestamp insertTime;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getRuleName() {
        return ruleName;
    }
    
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
    
    public String getRuleRemark() {
        return ruleRemark;
    }
    
    public void setRuleRemark(String ruleRemark) {
        this.ruleRemark = ruleRemark;
    }
    
    public Date getBeginDate() {
        return beginDate;
    }
    
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }
    
    public Date getEndDate() {
        return endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public Integer getRuleOrder() {
        return ruleOrder;
    }
    
    public void setRuleOrder(Integer ruleOrder) {
        this.ruleOrder = ruleOrder;
    }
    
    public Timestamp getInsertTime() {
        return insertTime;
    }
    
    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }
}
