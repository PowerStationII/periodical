package com.cn.periodical.enums;

/**
 * Created with IntelliJ IDEA.
 * User: 1
 * Date: 15-12-26
 * Time: 下午2:14
 * To change this template use File | Settings | File Templates.
 */
public enum ArticalCodeEnums {
    GAOJIAN_CODE("1","A"), // 稿件编号  article
    LISHIHUI_CODE("2","M"),// 理事会编号 members
    QIKAN_CODE("3","P"),// 期刊编号 periodical
    QIKAN_CONDE1("4","QK"),// 期刊编号 periodical
    SONGKAN_CONDE("5","SK");// 送刊生成的订单编号

    private String code;
    private String name;
    ArticalCodeEnums(String code,String name){
        this.code=code;
        this.name=name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
