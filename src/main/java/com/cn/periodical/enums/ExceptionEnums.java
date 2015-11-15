package com.cn.periodical.enums;

public enum ExceptionEnums {
	/**
	 * 业务错误
	 * */
	USER_NOT_EXSITS("01","用户不存在!!"),
	USER_SYSTEM_NOT_MATCH("02","系统选择错误!请返回并选择{0}系统登录!!"),
	ENTER_NOT_EXSITS("03","入口不存在!"),
	/**
	 * 数据库错误
	 * */
	
	
	/**
	 * 参数校验错误
	 * */
	
	/**
	 * 系统错误
	 * */
	SYSTEM_ERROR("99","系统异常,请联系管理员!");
	
	private String code;
	private String name;
	ExceptionEnums(String code,String name){
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
