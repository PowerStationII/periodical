package com.cn.periodical.pojo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午10:21
 * To change this template use File | Settings | File Templates.
 */
public class SongKanInfo implements Serializable {

    private int id ;
    private String periodicalId ;
    private String periodicalIssueNo ;
    private int cycleNums ;
    private int zengSonNums ;
    private String orderNo ;
    private String year ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriodicalId() {
        return periodicalId;
    }

    public void setPeriodicalId(String periodicalId) {
        this.periodicalId = periodicalId;
    }

    public String getPeriodicalIssueNo() {
        return periodicalIssueNo;
    }

    public void setPeriodicalIssueNo(String periodicalIssueNo) {
        this.periodicalIssueNo = periodicalIssueNo;
    }

    public int getCycleNums() {
        return cycleNums;
    }

    public void setCycleNums(int cycleNums) {
        this.cycleNums = cycleNums;
    }

    public int getZengSonNums() {
        return zengSonNums;
    }

    public void setZengSonNums(int zengSonNums) {
        this.zengSonNums = zengSonNums;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
