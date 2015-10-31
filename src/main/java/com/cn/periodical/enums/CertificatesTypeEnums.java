package com.cn.periodical.enums;

/**
 * 证件类型
 */
public enum CertificatesTypeEnums {

	IDCARD("0", "身份证"), 
	BOOKLET("1", "户口簿"), 
	PASSPORT("2", "护照"), 
	OFFICERCARD("3", "军官证"), 
	SOLDIERCARD("4","士兵证"), 
	HKANDMCARD("5", "港澳居民来往内地通行证"), 
	TAIWANCARD("6", "台湾同胞来往内地通行证"), 
	TEMPORARYID("7","临时身份证"), 
	ForeignerID("8", "外国人居留证"), 
	PoliceID("9", "警官证"), 
	OtherCard("X", "其他证件");

	private String code;
	private String name;

	private CertificatesTypeEnums(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public static boolean isIdentificationTypeEnum(String code) {
		CertificatesTypeEnums[] certificatesTypeEnums = CertificatesTypeEnums.values();
		for (CertificatesTypeEnums identificationTypeEnum : certificatesTypeEnums) {
			if (identificationTypeEnum.getCode().equals(code)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return this.code + ":" + this.name;
	}

	public static CertificatesTypeEnums get(String str) {
		for (CertificatesTypeEnums e : values()) {

			if (e.toString().equals(str)) {
				return e;
			}
		}
		return null;
	}

}
