package com.cn.periodical.enums;

public enum AttachmentTypeEnums {
	/**
	 * 初稿附件
	 * */
	ORIGINAL_ARTICLE("ORI_A","ORIGINAL_ARTICLE"),
	/**
	 * 编辑/专家附件
	 * */
	AUDIT_ARTICLE("AUD_A","AUDIT_ARTICLE"),
	/**
	 * 英文审核附件
	 * */
	COMPOUND_ARTICLE("COM_A","COMPOUND_ARTICLE"),
	/**
	 * 确定稿附件
	 * */
	CONFIRM_ARTICLE("CON_A","CONFIRM_ARTICLE");
	
	private String code;
	private String name;
	AttachmentTypeEnums(String code,String name){
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
