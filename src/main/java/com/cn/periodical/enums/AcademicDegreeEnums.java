package com.cn.periodical.enums;
/**
 * 学位
 * */
public enum AcademicDegreeEnums {
	BACHELOR("0", "学士"), 
	MASTER("1", "硕士"), 
	DOCTOR("2", "博士"), 
	POST("3", "博士后");

	private String code;
	private String name;

	private AcademicDegreeEnums(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public static boolean isAcademicDegreeEnums(String code) {
		AcademicDegreeEnums[] academicDegreeEnums = AcademicDegreeEnums.values();
		for (AcademicDegreeEnums academicDegreeEnum : academicDegreeEnums) {
			if (academicDegreeEnum.getCode().equals(code)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return this.code + ":" + this.name;
	}

	public static AcademicDegreeEnums get(String str) {
		for (AcademicDegreeEnums academicDegreeEnum  : values()) {

			if (academicDegreeEnum.toString().equals(str)) {
				return academicDegreeEnum;
			}
		}
		return null;
	}
}
