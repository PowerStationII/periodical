package com.cn.periodical.pojo;

import com.cn.periodical.utils.PagingQuery;

/**
 * AuthorInfoQuery
 * @author code-generator
 *
 */
public class AuthorInfoQuery extends PagingQuery {
	private static final long serialVersionUID = 1L;
	
	public  AuthorInfoQuery(){
		super(1, 10);
	}
	
	public  AuthorInfoQuery(int pageNo, int pageSize){
		super(pageNo, pageSize);
	}
	
	private java.lang.String articleId;
	private java.lang.String authorId;
	private java.lang.String authorName;
	private java.lang.String email;
	private java.lang.String authorNameSpell;
	private java.lang.String certificateType;
	private java.lang.String sex;
	private java.util.Date birthday;
	private java.lang.String researchArea;
	private java.lang.String degree;
	private java.lang.String academicDegree;
	private java.lang.String companyName;
	private java.lang.String compayType;
	private java.lang.String companyDepartment;
	private java.lang.String isreviewer;
	private java.lang.String isfirstauthor;
	private java.lang.String extend1;
	private java.lang.String extend2;
	private java.lang.String extend3;
	private java.lang.String extend4;
	private java.util.Date createTime;
	private java.util.Date updateTime;

	/**
	 * 
	 * @param articleId
	 */
	public void setArticleId(java.lang.String articleId) {
		this.articleId = articleId;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getArticleId() {
		return this.articleId;
	}
	/**
	 * 
	 * @param authorId
	 */
	public void setAuthorId(java.lang.String authorId) {
		this.authorId = authorId;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getAuthorId() {
		return this.authorId;
	}
	/**
	 * 
	 * @param authorName
	 */
	public void setAuthorName(java.lang.String authorName) {
		this.authorName = authorName;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getAuthorName() {
		return this.authorName;
	}
	/**
	 * 
	 * @param email
	 */
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getEmail() {
		return this.email;
	}
	/**
	 * 
	 * @param authorNameSpell
	 */
	public void setAuthorNameSpell(java.lang.String authorNameSpell) {
		this.authorNameSpell = authorNameSpell;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getAuthorNameSpell() {
		return this.authorNameSpell;
	}
	/**
	 * 
	 * @param certificateType
	 */
	public void setCertificateType(java.lang.String certificateType) {
		this.certificateType = certificateType;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getCertificateType() {
		return this.certificateType;
	}
	/**
	 * 
	 * @param sex
	 */
	public void setSex(java.lang.String sex) {
		this.sex = sex;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getSex() {
		return this.sex;
	}
	/**
	 * 
	 * @param birthday
	 */
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.util.Date getBirthday() {
		return this.birthday;
	}
	/**
	 * 
	 * @param researchArea
	 */
	public void setResearchArea(java.lang.String researchArea) {
		this.researchArea = researchArea;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getResearchArea() {
		return this.researchArea;
	}
	/**
	 * 
	 * @param degree
	 */
	public void setDegree(java.lang.String degree) {
		this.degree = degree;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getDegree() {
		return this.degree;
	}
	/**
	 * 
	 * @param academicDegree
	 */
	public void setAcademicDegree(java.lang.String academicDegree) {
		this.academicDegree = academicDegree;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getAcademicDegree() {
		return this.academicDegree;
	}
	/**
	 * 
	 * @param companyName
	 */
	public void setCompanyName(java.lang.String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getCompanyName() {
		return this.companyName;
	}
	/**
	 * 
	 * @param compayType
	 */
	public void setCompayType(java.lang.String compayType) {
		this.compayType = compayType;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getCompayType() {
		return this.compayType;
	}
	/**
	 * 
	 * @param companyDepartment
	 */
	public void setCompanyDepartment(java.lang.String companyDepartment) {
		this.companyDepartment = companyDepartment;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getCompanyDepartment() {
		return this.companyDepartment;
	}
	/**
	 * 
	 * @param isreviewer
	 */
	public void setIsreviewer(java.lang.String isreviewer) {
		this.isreviewer = isreviewer;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getIsreviewer() {
		return this.isreviewer;
	}
	/**
	 * 
	 * @param isfirstauthor
	 */
	public void setIsfirstauthor(java.lang.String isfirstauthor) {
		this.isfirstauthor = isfirstauthor;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getIsfirstauthor() {
		return this.isfirstauthor;
	}
	/**
	 * 
	 * @param extend1
	 */
	public void setExtend1(java.lang.String extend1) {
		this.extend1 = extend1;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getExtend1() {
		return this.extend1;
	}
	/**
	 * 
	 * @param extend2
	 */
	public void setExtend2(java.lang.String extend2) {
		this.extend2 = extend2;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getExtend2() {
		return this.extend2;
	}
	/**
	 * 
	 * @param extend3
	 */
	public void setExtend3(java.lang.String extend3) {
		this.extend3 = extend3;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getExtend3() {
		return this.extend3;
	}
	/**
	 * 
	 * @param extend4
	 */
	public void setExtend4(java.lang.String extend4) {
		this.extend4 = extend4;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getExtend4() {
		return this.extend4;
	}
	/**
	 * 
	 * @param createTime
	 */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	/**
	 * 
	 * @param updateTime
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
}