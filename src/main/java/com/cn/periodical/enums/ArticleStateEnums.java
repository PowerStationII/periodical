package com.cn.periodical.enums;

public enum ArticleStateEnums {
	/**
	 * 初投稿(代表稿件在作者操作范围内.)
	 * */
	NEW_ARTICLE("0000","NEW_ARTICLE"),
	/**
	 * 已登记(代表稿件在编辑人员操作范围内.)
	 * */
	ENLISTED_ARTICLE("0001","ENLISTED_ARTICLE"),
	/**
	 * 已送审(代表稿件在专家操作范围内.)
	 * */
	SUBMITED_ARTICLE("0002","SUBMITED_ARTICLE"),
	/**
	 * 已待刊(代表稿件在编辑人员操作范围内.)
	 * */
	PUBLISH_ARTICLE("0003","PUBLISH_ARTICLE"),
	/**
	 * 处理中
	 * */
	DEALING_ARTICLE("0004","DEALING_ARTICLE"),
	/**
	 * 处理完成
	 * */
	END_ARTICLE("0008","END_ARTICLE"),
	/**
	 * 作废(无论专家或者编辑操作退稿.稿件状态将变为作废!)
	 * */
	DELETE_ARTICLE("0005","DELETE_ARTICLE"),
	/**
	 * 返修(类似于不同意的意思:但可重来)
	 * */
	REPAIR_ARTICLE("0006","REPAIR_ARTICLE"),
	/**
	 * 退稿(类似于不同意的意思:但不可重来,稿件直接作废)
	 * */
	RETURNED_ARTICLE("0007","RETURNED_ARTICLE");
	
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
