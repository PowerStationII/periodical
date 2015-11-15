package com.cn.periodical.enums;

public enum PeriodicalStateEnums {
	/**
	 * 创建中
	 * */
	NEW_PERIODICAL("0","NEW_PERIODICAL"),
	/**
	 * 待签发
	 * */
	PRE_PERIODICAL("1","PRE_PERIODICAL"),
	/**
	 * over
	 * */
	OVER_PERIODICAL("9","OVER_PERIODICAL");
	
	private String code;
	private String name;
	PeriodicalStateEnums(String code,String name){
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
