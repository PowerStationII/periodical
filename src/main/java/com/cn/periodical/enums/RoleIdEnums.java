package com.cn.periodical.enums;

public enum RoleIdEnums {
	/**
	 * 作者
	 * */
	AUTHOR("1001","AUTHOR"),
	/**
	 * 读者-个人
	 * */
	READER_P("1002","READER_P"),
	/**
	 * 读者-省所/企业
	 * */
	READER_E("1011","READER_E"),
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
	ADMIN("1010","ADMIN"),


    //===================================

    /**
     * 作者
     * */
    AUTHOR_ATTR("1001","原稿下载"),
    /**
     * 中文(稿件)专家
     * */
    CN_EXPERT_ATTR("1003","中文专家稿件下载"),
    /**
     * 英文专家
     * */
    EN_EXPERT_ATTR("1004","英文专家稿件下载"),
    /**
     * 稿件编辑
     * */
    ARTICLE_EDITOR_ATTR("1006","编辑稿件下载");

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
