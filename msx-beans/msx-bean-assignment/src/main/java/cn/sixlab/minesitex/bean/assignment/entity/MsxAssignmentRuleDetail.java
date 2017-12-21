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
import java.sql.Timestamp;

@Entity
public class MsxAssignmentRuleDetail {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer ruleId;
    
    /**
     * 1:按公历算
     * 2:按农历算
     */
    private Integer yearType;
    
    /**
     * 数字：每隔几年
     * 空：不需要
     */
    private Integer yearNum;
    
    /**
     * 1-12：每几个月
     * 空：不需要
     */
    private Integer monthNum;
    
    /**
     * 周类型：
     *
     */
    private Integer weekType;
    
    /**
     * 数字：第几周，负数是倒数第几周
     * 空：不需要
     */
    private Integer weekNum;
    
    /**
     * 月：每月的日期
     * 周：没周的星期
     * 年+月：每年的对应月的日期
     * 年+周：每年的对应周的星期
     * 月+周：每月的对应周的星期
     * 年+月+周：每年的对应月份中对应周的星期
     */
    private Integer dayNum;
    
    private Integer ruleHour;
    
    private String remark;
    
    private Timestamp insertTime;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getRuleId() {
        return ruleId;
    }
    
    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }
    
    public Integer getYearType() {
        return yearType;
    }
    
    public void setYearType(Integer yearType) {
        this.yearType = yearType;
    }
    
    public Integer getYearNum() {
        return yearNum;
    }
    
    public void setYearNum(Integer yearNum) {
        this.yearNum = yearNum;
    }
    
    public Integer getMonthNum() {
        return monthNum;
    }
    
    public void setMonthNum(Integer monthNum) {
        this.monthNum = monthNum;
    }
    
    public Integer getWeekType() {
        return weekType;
    }
    
    public void setWeekType(Integer weekType) {
        this.weekType = weekType;
    }
    
    public Integer getWeekNum() {
        return weekNum;
    }
    
    public void setWeekNum(Integer weekNum) {
        this.weekNum = weekNum;
    }
    
    public Integer getDayNum() {
        return dayNum;
    }
    
    public void setDayNum(Integer dayNum) {
        this.dayNum = dayNum;
    }
    
    public Integer getRuleHour() {
        return ruleHour;
    }
    
    public void setRuleHour(Integer ruleHour) {
        this.ruleHour = ruleHour;
    }
    
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public Timestamp getInsertTime() {
        return insertTime;
    }
    
    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }
}
