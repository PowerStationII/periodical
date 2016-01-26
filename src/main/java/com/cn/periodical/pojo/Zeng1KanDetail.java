package com.cn.periodical.pojo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午10:21
 * To change this template use File | Settings | File Templates.
 */
public class Zeng1KanDetail implements Serializable {

    private int id ;
    private String periodicalId ;
    private String periodicalIssueNo ;
    private String articleId ;
    private int cycleNums ;
    private int zengSonNum ;
    private String youbian ;
    private String dizhi ;
    private String danwei ;
    private String xingming ;
    private String dianhua ;
    private String orderNo ;

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


    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getYoubian() {
        return youbian;
    }

    public void setYoubian(String youbian) {
        this.youbian = youbian;
    }

    public String getDizhi() {
        return dizhi;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }

    public String getDanwei() {
        return danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }

    public String getXingming() {
        return xingming;
    }

    public void setXingming(String xingming) {
        this.xingming = xingming;
    }

    public String getDianhua() {
        return dianhua;
    }

    public void setDianhua(String dianhua) {
        this.dianhua = dianhua;
    }

    public int getZengSonNum() {
        return zengSonNum;
    }

    public void setZengSonNum(int zengSonNum) {
        this.zengSonNum = zengSonNum;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
