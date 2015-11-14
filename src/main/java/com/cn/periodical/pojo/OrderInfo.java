package com.cn.periodical.pojo;

import java.util.Date;

/**
 *      订单主档
 *  ceated with IntelliJ IDEA.
 * User: yuguodong
 * Date: 15-11-14
 * Time: 下午11:51
 * To change this template use File | Settings | File Templates.
 */
public class OrderInfo {

    private java.lang.Long id;
    private String user_id ;
    private String order_no ;// 订单编号
    private String periodical_year ;
    private Double amount ;
    private String pay_id ;//支付记录
    private Integer subscribe_nums ; //订阅数量
    private String supplement_id1 ;
    private String supplement_id2 ;
    private String supplement_id3 ;
    private String supplement_id4 ;
    private String supplement_id5 ;
    private String supplement_id6 ;
    private String supplement_id7 ;
    private Integer supplement_id1_nums ;
    private Integer supplement_id2_nums ;
    private Integer supplement_id3_nums ;
    private Integer supplement_id4_nums ;
    private Integer supplement_id5_nums ;
    private Integer supplement_id6_nums ;
    private Integer supplement_id7_nums ;
    private String order_status ; //订单状态
    private String extend_1 ;
    private String extend_2 ;
    private String extend_3 ;
    private String extend_4 ;
    private Date create_time ;
    private Date update_time ;
    private Date audit_time ; //       审核日期

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getPeriodical_year() {
        return periodical_year;
    }

    public void setPeriodical_year(String periodical_year) {
        this.periodical_year = periodical_year;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPay_id() {
        return pay_id;
    }

    public void setPay_id(String pay_id) {
        this.pay_id = pay_id;
    }

    public Integer getSubscribe_nums() {
        return subscribe_nums;
    }

    public void setSubscribe_nums(Integer subscribe_nums) {
        this.subscribe_nums = subscribe_nums;
    }

    public String getSupplement_id1() {
        return supplement_id1;
    }

    public void setSupplement_id1(String supplement_id1) {
        this.supplement_id1 = supplement_id1;
    }

    public String getSupplement_id2() {
        return supplement_id2;
    }

    public void setSupplement_id2(String supplement_id2) {
        this.supplement_id2 = supplement_id2;
    }

    public String getSupplement_id3() {
        return supplement_id3;
    }

    public void setSupplement_id3(String supplement_id3) {
        this.supplement_id3 = supplement_id3;
    }

    public String getSupplement_id4() {
        return supplement_id4;
    }

    public void setSupplement_id4(String supplement_id4) {
        this.supplement_id4 = supplement_id4;
    }

    public String getSupplement_id5() {
        return supplement_id5;
    }

    public void setSupplement_id5(String supplement_id5) {
        this.supplement_id5 = supplement_id5;
    }

    public String getSupplement_id6() {
        return supplement_id6;
    }

    public void setSupplement_id6(String supplement_id6) {
        this.supplement_id6 = supplement_id6;
    }

    public String getSupplement_id7() {
        return supplement_id7;
    }

    public void setSupplement_id7(String supplement_id7) {
        this.supplement_id7 = supplement_id7;
    }

    public Integer getSupplement_id1_nums() {
        return supplement_id1_nums;
    }

    public void setSupplement_id1_nums(Integer supplement_id1_nums) {
        this.supplement_id1_nums = supplement_id1_nums;
    }

    public Integer getSupplement_id2_nums() {
        return supplement_id2_nums;
    }

    public void setSupplement_id2_nums(Integer supplement_id2_nums) {
        this.supplement_id2_nums = supplement_id2_nums;
    }

    public Integer getSupplement_id3_nums() {
        return supplement_id3_nums;
    }

    public void setSupplement_id3_nums(Integer supplement_id3_nums) {
        this.supplement_id3_nums = supplement_id3_nums;
    }

    public Integer getSupplement_id4_nums() {
        return supplement_id4_nums;
    }

    public void setSupplement_id4_nums(Integer supplement_id4_nums) {
        this.supplement_id4_nums = supplement_id4_nums;
    }

    public Integer getSupplement_id5_nums() {
        return supplement_id5_nums;
    }

    public void setSupplement_id5_nums(Integer supplement_id5_nums) {
        this.supplement_id5_nums = supplement_id5_nums;
    }

    public Integer getSupplement_id6_nums() {
        return supplement_id6_nums;
    }

    public void setSupplement_id6_nums(Integer supplement_id6_nums) {
        this.supplement_id6_nums = supplement_id6_nums;
    }

    public Integer getSupplement_id7_nums() {
        return supplement_id7_nums;
    }

    public void setSupplement_id7_nums(Integer supplement_id7_nums) {
        this.supplement_id7_nums = supplement_id7_nums;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getExtend_1() {
        return extend_1;
    }

    public void setExtend_1(String extend_1) {
        this.extend_1 = extend_1;
    }

    public String getExtend_2() {
        return extend_2;
    }

    public void setExtend_2(String extend_2) {
        this.extend_2 = extend_2;
    }

    public String getExtend_3() {
        return extend_3;
    }

    public void setExtend_3(String extend_3) {
        this.extend_3 = extend_3;
    }

    public String getExtend_4() {
        return extend_4;
    }

    public void setExtend_4(String extend_4) {
        this.extend_4 = extend_4;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getAudit_time() {
        return audit_time;
    }

    public void setAudit_time(Date audit_time) {
        this.audit_time = audit_time;
    }
}
