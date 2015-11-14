package com.cn.periodical.pojo;

import java.util.Date;

/**
 *     付款主档
 *     Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 15-11-15
 * Time: 上午12:02
 * To change this template use File | Settings | File Templates.
 */
public class PayInfo {
    private Long id ;
    private String order_no ;
    private String pay_id ;
    private Double pay_amount ;
    private Date pay_time ;
    private String invoice_tile ;// 发票抬头
    private String pay_type ;  //
    private String extend_1 ;
    private String extend_2 ;
    private String extend_3 ;
    private String extend_4 ;
    private Date create_time ;
    private Date update_time ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getPay_id() {
        return pay_id;
    }

    public void setPay_id(String pay_id) {
        this.pay_id = pay_id;
    }

    public Double getPay_amount() {
        return pay_amount;
    }

    public void setPay_amount(Double pay_amount) {
        this.pay_amount = pay_amount;
    }

    public Date getPay_time() {
        return pay_time;
    }

    public void setPay_time(Date pay_time) {
        this.pay_time = pay_time;
    }

    public String getInvoice_tile() {
        return invoice_tile;
    }

    public void setInvoice_tile(String invoice_tile) {
        this.invoice_tile = invoice_tile;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
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
}
