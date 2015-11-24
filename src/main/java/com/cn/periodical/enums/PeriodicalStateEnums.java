package com.cn.periodical.enums;

public enum PeriodicalStateEnums {
	/**
	 * 新刊
	 * */
	NEW("N","NEW"),
	/**
	 * 稿件组刊中
	 * */
	ARTICLE_PART_DEALING("APD","ARTICLE_PART_DEALING"),
	/**
	 * 稿件处理完成
	 * */
	ARTICLE_PART_OVER("APO","ARTICLE_PART_OVER"),
	/**
	 * 广告组刊中
	 * */
	AD_PART_DEALING("ADPD","AD_PART_DEALING"),
	/**
	 * 广告处理完成
	 * */
	AD_PART_OVER("ADPO","AD_PART_OVER"),
	/**
	 * 待签发
	 * */
	PRE_ISSUE("PI","PRE_ISSUE"),
	/**
	 * 已签发
	 * */
	FINISH_ISSUE("FI","FINISH_ISSUE");
	
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
