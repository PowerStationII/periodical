package com.cn.periodical.enums;

public enum CouncilMemberTypeEnums {
	/**
	 * 理事长
	 * */
	DIRECTOR_GENERAL("DG","理事长"),
	/**
	 * 常务理事
	 * */
	STANDING_DIRECTOR("SD","常务理事"),
	/**
	 * 副理事长
	 * */
	VICE_DIRECTOR_GENERAL("VDG","副理事长"),
	/**
	 * 理事
	 * */
	DIRECTOR("D","理事");
	
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
