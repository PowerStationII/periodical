package com.cn.periodical.request;

import java.util.Date;

import com.cn.periodical.enums.AcademicDegreeEnums;
import com.cn.periodical.enums.CertificatesTypeEnums;
import com.cn.periodical.enums.CompanyTypeEnums;
import com.cn.periodical.enums.DegreeEnums;

/**
 * 注册请求参数
 * */
public class RegisteRequestDto extends RequestDto {

	public RegisteRequestDto() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 邮箱地址
	 * */
	private String email;
	/**
	 * 密码
	 * */
	private String password;
	/**
	 * 真实姓名
	 * */
	private String realName;
	/**
	 * 姓名拼写
	 * */
	private String nameSpell;
	/**
	 * 证件类型
	 * */
	private CertificatesTypeEnums certifiType;
	/**
	 * 证件号
	 * */
	private String certifiNo;
	/**
	 * 性别
	 * */
	private String sex;
	/**
	 * 出生日期
	 * */
	private Date birthDay;
	/**
	 * 联系电话
	 * */
	private String contactPhone;
	/**
	 * 邮寄地址
	 * */
	private String postAddress;
	/**
	 * 邮政编码
	 * */
	private String postCode;
	/**
	 * 研究领域
	 * */
	private String researchArea;
	/**
	 * 学历
	 * */
	private DegreeEnums degree;
	/**
	 * 学位
	 * */
	private AcademicDegreeEnums academicDegree;
	/**
	 * 单位名称
	 * */
	private String companyName;
	/**
	 * 单位性质
	 * */
	private CompanyTypeEnums companyType;
	/**
	 * 部门或院系
	 * */
	private String companyDepartment;
	/**
	 * 是否希望成为审稿专家
	 * */
	private String isreviewer;
	
	
	
	
	
}
