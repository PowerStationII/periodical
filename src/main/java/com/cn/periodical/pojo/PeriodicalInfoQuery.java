/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import com.cn.periodical.utils.PagingQuery;

/**
 * PeriodicalInfoQuery
 * @author code-generator
 *
 */
public class PeriodicalInfoQuery extends PagingQuery {
	private static final long serialVersionUID = 1L;
	
	public  PeriodicalInfoQuery(){
		super(1, 10);
	}
	
	public  PeriodicalInfoQuery(int pageNo, int pageSize){
		super(pageNo, pageSize);
	}
	
	private java.lang.String payeeId;
	private java.lang.String periodicalYear;
	private java.lang.String periodicalId;
	private java.lang.String periodicalCnName;
	private java.lang.String periodicalEnName;
	private java.lang.String periodicalType;
	private java.lang.String competentOrganization;
	private java.lang.String hostOrganization;
	private java.lang.Integer cycle;
	private java.lang.String publishPlace;
	private java.lang.String languages;
	private java.lang.String format;
	private java.lang.String press;
	private java.lang.String website;
	private java.lang.String publishArea;
	private java.lang.String issnNo;
	private java.lang.String cnNo;
	private java.lang.String mailNo;
	private java.lang.Long inUnitPrice;
	private java.lang.Long inFixPrice;
	private java.lang.Long outFixPrice;
	private java.util.Date openTime;
	private java.lang.String usedTitles;
	private java.lang.String awards;
	private java.lang.String extend1;
	private java.lang.String extend2;
	private java.lang.String extend3;
	private java.lang.String extend4;
	private java.util.Date createTime;
	private java.util.Date updateTime;

	/**
	 * 收款人信息id
	 * @param payeeId
	 */
	public void setPayeeId(java.lang.String payeeId) {
		this.payeeId = payeeId;
	}
	
	/**
	 * 收款人信息id
	 * @return
	 */
	public java.lang.String getPayeeId() {
		return this.payeeId;
	}
	/**
	 * 年份
	 * @param periodicalYear
	 */
	public void setPeriodicalYear(java.lang.String periodicalYear) {
		this.periodicalYear = periodicalYear;
	}
	
	/**
	 * 年份
	 * @return
	 */
	public java.lang.String getPeriodicalYear() {
		return this.periodicalYear;
	}
	/**
	 * 
	 * @param periodicalId
	 */
	public void setPeriodicalId(java.lang.String periodicalId) {
		this.periodicalId = periodicalId;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getPeriodicalId() {
		return this.periodicalId;
	}
	/**
	 * 中文刊名
	 * @param periodicalCnName
	 */
	public void setPeriodicalCnName(java.lang.String periodicalCnName) {
		this.periodicalCnName = periodicalCnName;
	}
	
	/**
	 * 中文刊名
	 * @return
	 */
	public java.lang.String getPeriodicalCnName() {
		return this.periodicalCnName;
	}
	/**
	 * 
	 * @param periodicalEnName
	 */
	public void setPeriodicalEnName(java.lang.String periodicalEnName) {
		this.periodicalEnName = periodicalEnName;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getPeriodicalEnName() {
		return this.periodicalEnName;
	}
	/**
	 * 主管单位
	 * @param periodicalType
	 */
	public void setPeriodicalType(java.lang.String periodicalType) {
		this.periodicalType = periodicalType;
	}
	
	/**
	 * 主管单位
	 * @return
	 */
	public java.lang.String getPeriodicalType() {
		return this.periodicalType;
	}
	/**
	 * 主管单位
	 * @param competentOrganization
	 */
	public void setCompetentOrganization(java.lang.String competentOrganization) {
		this.competentOrganization = competentOrganization;
	}
	
	/**
	 * 主管单位
	 * @return
	 */
	public java.lang.String getCompetentOrganization() {
		return this.competentOrganization;
	}
	/**
	 * 主办单位
	 * @param hostOrganization
	 */
	public void setHostOrganization(java.lang.String hostOrganization) {
		this.hostOrganization = hostOrganization;
	}
	
	/**
	 * 主办单位
	 * @return
	 */
	public java.lang.String getHostOrganization() {
		return this.hostOrganization;
	}
	/**
	 * 周期
	 * @param cycle
	 */
	public void setCycle(java.lang.Integer cycle) {
		this.cycle = cycle;
	}
	
	/**
	 * 周期
	 * @return
	 */
	public java.lang.Integer getCycle() {
		return this.cycle;
	}
	/**
	 * 出版地
	 * @param publishPlace
	 */
	public void setPublishPlace(java.lang.String publishPlace) {
		this.publishPlace = publishPlace;
	}
	
	/**
	 * 出版地
	 * @return
	 */
	public java.lang.String getPublishPlace() {
		return this.publishPlace;
	}
	/**
	 * 语种
	 * @param languages
	 */
	public void setLanguages(java.lang.String languages) {
		this.languages = languages;
	}
	
	/**
	 * 语种
	 * @return
	 */
	public java.lang.String getLanguages() {
		return this.languages;
	}
	/**
	 * 开本
	 * @param format
	 */
	public void setFormat(java.lang.String format) {
		this.format = format;
	}
	
	/**
	 * 开本
	 * @return
	 */
	public java.lang.String getFormat() {
		return this.format;
	}
	/**
	 * 编辑出版(出版社)
	 * @param press
	 */
	public void setPress(java.lang.String press) {
		this.press = press;
	}
	
	/**
	 * 编辑出版(出版社)
	 * @return
	 */
	public java.lang.String getPress() {
		return this.press;
	}
	/**
	 * 
	 * @param website
	 */
	public void setWebsite(java.lang.String website) {
		this.website = website;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getWebsite() {
		return this.website;
	}
	/**
	 * 
	 * @param publishArea
	 */
	public void setPublishArea(java.lang.String publishArea) {
		this.publishArea = publishArea;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getPublishArea() {
		return this.publishArea;
	}
	/**
	 * 国际标准刊号
	 * @param issnNo
	 */
	public void setIssnNo(java.lang.String issnNo) {
		this.issnNo = issnNo;
	}
	
	/**
	 * 国际标准刊号
	 * @return
	 */
	public java.lang.String getIssnNo() {
		return this.issnNo;
	}
	/**
	 * 国内统一刊号
	 * @param cnNo
	 */
	public void setCnNo(java.lang.String cnNo) {
		this.cnNo = cnNo;
	}
	
	/**
	 * 国内统一刊号
	 * @return
	 */
	public java.lang.String getCnNo() {
		return this.cnNo;
	}
	/**
	 * 邮发代号
	 * @param mailNo
	 */
	public void setMailNo(java.lang.String mailNo) {
		this.mailNo = mailNo;
	}
	
	/**
	 * 邮发代号
	 * @return
	 */
	public java.lang.String getMailNo() {
		return this.mailNo;
	}
	/**
	 * 国内单价
	 * @param inUnitPrice
	 */
	public void setInUnitPrice(java.lang.Long inUnitPrice) {
		this.inUnitPrice = inUnitPrice;
	}
	
	/**
	 * 国内单价
	 * @return
	 */
	public java.lang.Long getInUnitPrice() {
		return this.inUnitPrice;
	}
	/**
	 * 国内定价
	 * @param inFixPrice
	 */
	public void setInFixPrice(java.lang.Long inFixPrice) {
		this.inFixPrice = inFixPrice;
	}
	
	/**
	 * 国内定价
	 * @return
	 */
	public java.lang.Long getInFixPrice() {
		return this.inFixPrice;
	}
	/**
	 * 国外定价
	 * @param outFixPrice
	 */
	public void setOutFixPrice(java.lang.Long outFixPrice) {
		this.outFixPrice = outFixPrice;
	}
	
	/**
	 * 国外定价
	 * @return
	 */
	public java.lang.Long getOutFixPrice() {
		return this.outFixPrice;
	}
	/**
	 * 创刊时间
	 * @param openTime
	 */
	public void setOpenTime(java.util.Date openTime) {
		this.openTime = openTime;
	}
	
	/**
	 * 创刊时间
	 * @return
	 */
	public java.util.Date getOpenTime() {
		return this.openTime;
	}
	/**
	 * 曾用刊名
	 * @param usedTitles
	 */
	public void setUsedTitles(java.lang.String usedTitles) {
		this.usedTitles = usedTitles;
	}
	
	/**
	 * 曾用刊名
	 * @return
	 */
	public java.lang.String getUsedTitles() {
		return this.usedTitles;
	}
	/**
	 * 所获奖项
	 * @param awards
	 */
	public void setAwards(java.lang.String awards) {
		this.awards = awards;
	}
	
	/**
	 * 所获奖项
	 * @return
	 */
	public java.lang.String getAwards() {
		return this.awards;
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