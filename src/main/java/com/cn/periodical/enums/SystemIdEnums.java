package com.cn.periodical.enums;

public enum SystemIdEnums {
	/**
	 * 编辑系统
	 * */
	EDIT_SYS("111","编辑系统"),
	/**
	 * 专家系统
	 * */
	EXPERT_SYS("222","专家系统"),
	/**
	 * 作者系统
	 * */
	AUTHOR_SYS("333","作者系统"),
	/**
	 * 读者系统
	 * */
	READER_SYS("444","读者系统");
	
	private String code;
	private String name;
	SystemIdEnums(String code,String name){
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
