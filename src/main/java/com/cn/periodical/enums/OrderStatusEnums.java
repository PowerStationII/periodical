package com.cn.periodical.enums;

public enum OrderStatusEnums {
	/**
	 * 未付款
	 * */
	NONE("N","NONE"),
	/**
	 * 全部付清
	 * */
	ALL("A","ALL"),
	/**
	 * 部分付清
	 * */
	PART("P","PART");
	
	private String code;
	private String name;
	OrderStatusEnums(String code,String name){
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
