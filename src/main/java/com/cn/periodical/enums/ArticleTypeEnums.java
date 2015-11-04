package com.cn.periodical.enums;

public enum ArticleTypeEnums {
	/**
	 * 新稿
	 * */
	NEW_ARTICLE("0","NEW_ARTICLE"),
	/**
	 * 返修重投
	 * */
	REPAIR_ARTICLE("1","REPAIR_ARTICLE");
	
	private String code;
	private String name;
	ArticleTypeEnums(String code,String name){
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
