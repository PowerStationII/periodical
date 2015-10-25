package com.cn.periodical.enums;

public enum RoleIdEnums {
	/**
	 * 作者
	 * */
	AUTHOR("1001","AUTHOR"),
	/**
	 * 读者
	 * */
	READER("1002","READER"),
	/**
	 * 中文(稿件)专家
	 * */
	CN_EXPERT("1003","CN_EXPERT"),
	/**
	 * 英文专家
	 * */
	EN_EXPERT("1004","EN_EXPERT"),
	/**
	 * 主编
	 * */
	EDITOR("1005","EDITOR"),
	/**
	 * 稿件编辑
	 * */
	ARTICLE_EDITOR("1006","ARTICLE_EDITOR"),
	/**
	 * 广告编辑
	 * */
	AD_EDITOR("1007","AD_EDITOR"),
	/**
	 * 发行编辑
	 * */
	SUBSCRIBE_EDITOR("1008","SUBSCRIBE_EDITOR"),
	/**
	 * 签发人
	 * */
	ISSUER("1009","ISSUER"),
	/**
	 * 系统管理员
	 * */
	ADMIN("1010","ADMIN");
	
	private String code;
	private String name;
	RoleIdEnums(String code,String name){
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
