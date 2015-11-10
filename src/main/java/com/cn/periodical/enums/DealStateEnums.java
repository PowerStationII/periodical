package com.cn.periodical.enums;

public enum DealStateEnums {
	/**
	 * 通过(类似于同意的意思:可以进入下级审批)
	 * */
	NEW_ARTICLE("2000","NEW_ARTICLE"),
	/**
	 * 返修(类似于不同意的意思:但可重来)
	 * */
	REPAIR_ARTICLE("2001","REPAIR_ARTICLE"),
	/**
	 * 退稿(类似于不同意的意思:但不可重来,稿件直接作废)
	 * */
	RETURNED_ARTICLE("2002","RETURNED_ARTICLE");
	
	private String code;
	private String name;
	DealStateEnums(String code,String name){
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
