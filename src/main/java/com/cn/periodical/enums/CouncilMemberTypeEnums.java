package com.cn.periodical.enums;

public enum CouncilMemberTypeEnums {
	/**
	 * 理事长
	 * */
	DIRECTOR_GENERAL("1000","DIRECTOR_GENERAL"),
	/**
	 * 常务理事
	 * */
	STANDING_DIRECTOR("1001","STANDING_DIRECTOR"),
	/**
	 * 副理事长
	 * */
	VICE_DIRECTOR_GENERAL("1002","VICE_DIRECTOR_GENERAL"),
	/**
	 * 理事
	 * */
	DIRECTOR("1003","DIRECTOR");
	
	private String code;
	private String name;
	CouncilMemberTypeEnums(String code,String name){
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
