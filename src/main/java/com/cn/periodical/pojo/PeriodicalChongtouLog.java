package com.cn.periodical.pojo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午10:21
 * To change this template use File | Settings | File Templates.
 */
public class PeriodicalChongtouLog implements Serializable {

    private int id ;
    private String oriarticleNo ;
    private String articleNo ;
    private String groupFlag ;
    private int fanxiuCount ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriarticleNo() {
        return oriarticleNo;
    }

    public void setOriarticleNo(String oriarticleNo) {
        this.oriarticleNo = oriarticleNo;
    }

    public String getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(String articleNo) {
        this.articleNo = articleNo;
    }

    public String getGroupFlag() {
        return groupFlag;
    }

    public void setGroupFlag(String groupFlag) {
        this.groupFlag = groupFlag;
    }

    public int getFanxiuCount() {
        return fanxiuCount;
    }

    public void setFanxiuCount(int fanxiuCount) {
        this.fanxiuCount = fanxiuCount;
    }
}
