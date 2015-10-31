package com.cn.periodical.enums;
/**
 * 学历
 * */
public enum DegreeEnums {
	IDCARD("0", "小学"), 
	BOOKLET("1", "初中"), 
	PASSPORT("2", "高中"), 
	OFFICERCARD("3", "中专"), 
	SOLDIERCARD("4","高职"), 
	HKANDMCARD("5", "专科"), 
	BACHELOR_DEGREE("6", "本科"), 
	TEMPORARYID("7","硕士研究生"), 
	ForeignerID("8", "博士研究生");

	private String code;
	private String name;

	private DegreeEnums(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public static boolean isDegreeEnums(String code) {
		DegreeEnums[] degreeEnums = DegreeEnums.values();
		for (DegreeEnums degreeEnum : degreeEnums) {
			if (degreeEnum.getCode().equals(code)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return this.code + ":" + this.name;
	}

	public static DegreeEnums get(String str) {
		for (DegreeEnums degreeEnum  : values()) {

			if (degreeEnum.toString().equals(str)) {
				return degreeEnum;
			}
		}
		return null;
	}
}
