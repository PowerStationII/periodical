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
	private String birthDay;
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
    /**
     * 读者类型，1是个人 ； 2是企业
     */
    private String readType ;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getNameSpell() {
		return nameSpell;
	}
	public void setNameSpell(String nameSpell) {
		this.nameSpell = nameSpell;
	}
	public CertificatesTypeEnums getCertifiType() {
		return certifiType;
	}
	public void setCertifiType(CertificatesTypeEnums certifiType) {
		this.certifiType = certifiType;
	}
	public String getCertifiNo() {
		return certifiNo;
	}
	public void setCertifiNo(String certifiNo) {
		this.certifiNo = certifiNo;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getPostAddress() {
		return postAddress;
	}
	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getResearchArea() {
		return researchArea;
	}
	public void setResearchArea(String researchArea) {
		this.researchArea = researchArea;
	}
	public DegreeEnums getDegree() {
		return degree;
	}
	public void setDegree(DegreeEnums degree) {
		this.degree = degree;
	}
	public AcademicDegreeEnums getAcademicDegree() {
		return academicDegree;
	}
	public void setAcademicDegree(AcademicDegreeEnums academicDegree) {
		this.academicDegree = academicDegree;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public CompanyTypeEnums getCompanyType() {
		return companyType;
	}
	public void setCompanyType(CompanyTypeEnums companyType) {
		this.companyType = companyType;
	}
	public String getCompanyDepartment() {
		return companyDepartment;
	}
	public void setCompanyDepartment(String companyDepartment) {
		this.companyDepartment = companyDepartment;
	}
	public String getIsreviewer() {
		return isreviewer;
	}
	public void setIsreviewer(String isreviewer) {
		this.isreviewer = isreviewer;
	}

    public String getReadType() {
        return readType;
    }

    public void setReadType(String readType) {
        this.readType = readType;
    }
}
