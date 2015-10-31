package com.cn.periodical.enums;
/**
 * 单位类型枚举类
 * */
public enum CompanyTypeEnums {
	ENTERPRISES("0", "国企"), 
	PRIVATE_ENTERPRISES("1", "私企"), 
	FOREIGN_COMPANY("2", "外企"), 
	COMPANY_OTHERS("2", "其他");

	private String code;
	private String name;

	private CompanyTypeEnums(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public static boolean isCompanyTypeEnums(String code) {
		CompanyTypeEnums[] companyTypeEnums = CompanyTypeEnums.values();
		for (CompanyTypeEnums companyTypeEnum : companyTypeEnums) {
			if (companyTypeEnum.getCode().equals(code)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return this.code + ":" + this.name;
	}

	public static CompanyTypeEnums get(String str) {
		for (CompanyTypeEnums companyTypeEnum: values()) {

			if (companyTypeEnum.toString().equals(str)) {
				return companyTypeEnum;
			}
		}
		return null;
	}
}
