package com.cn.periodical.enums;

public enum ArticleStateEnums {
	/**
	 * 新稿
	 * */
	NEW_ARTICLE("0000","NEW_ARTICLE"),
	/**
	 * 已登记
	 * */
	ENLISTED_ARTICLE("0001","ENLISTED_ARTICLE"),
	/**
	 * 已返修
	 * */
	REPAIR_ARTICLE("0002","REPAIR_ARTICLE"),
	/**
	 * 已退稿
	 * */
	RETURNED_ARTICLE("0003","RETURNED_ARTICLE"),
	/**
	 * 待刊
	 * */
	PUBLISH_ARTICLE("0004","PUBLISH_ARTICLE");
	
	private String code;
	private String name;
	ArticleStateEnums(String code,String name){
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
