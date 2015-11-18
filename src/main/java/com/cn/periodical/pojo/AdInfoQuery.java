/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import com.cn.periodical.utils.PagingQuery;

/**
 * AdInfoQuery
 * @author code-generator
 *
 */
public class AdInfoQuery extends PagingQuery {
	private static final long serialVersionUID = 1L;
	
	public  AdInfoQuery(){
		super(1, 10);
	}
	
	public  AdInfoQuery(int pageNo, int pageSize){
		super(pageNo, pageSize);
	}
	
	private java.lang.String adId;
	private java.lang.String councilId;
	private java.lang.String adName;
	private java.lang.String adType;
	private java.lang.String adInvestPosition;
	private java.lang.String trialNo;
	private java.util.Date adSubmitTime;
	private java.util.Date adAuditTime;
	private java.lang.String adAuditOpinion;
	private java.lang.String adAttachmentName;
	private java.lang.String adAttachmentPath;
	private java.util.Date adRecordTime;
	private java.lang.String adContactName;
	private java.lang.String adContactPhone;
	private java.lang.Long adFee;
	private java.lang.String extend1;
	private java.lang.String extend2;
	private java.lang.String extend3;
	private java.lang.String extend4;
	private java.util.Date createTime;
	private java.util.Date updateTime;

	/**
	 * 广告id
	 * @param adId
	 */
	public void setAdId(java.lang.String adId) {
		this.adId = adId;
	}
	
	/**
	 * 广告id
	 * @return
	 */
	public java.lang.String getAdId() {
		return this.adId;
	}
	/**
	 * council_info.council_id
	 * @param councilId
	 */
	public void setCouncilId(java.lang.String councilId) {
		this.councilId = councilId;
	}
	
	/**
	 * council_info.council_id
	 * @return
	 */
	public java.lang.String getCouncilId() {
		return this.councilId;
	}
	/**
	 * 广告名称
	 * @param adName
	 */
	public void setAdName(java.lang.String adName) {
		this.adName = adName;
	}
	
	/**
	 * 广告名称
	 * @return
	 */
	public java.lang.String getAdName() {
		return this.adName;
	}
	/**
	 * 广告类型
	 * @param adType
	 */
	public void setAdType(java.lang.String adType) {
		this.adType = adType;
	}
	
	/**
	 * 广告类型
	 * @return
	 */
	public java.lang.String getAdType() {
		return this.adType;
	}
	/**
	 * 刊登位置
	 * @param adInvestPosition
	 */
	public void setAdInvestPosition(java.lang.String adInvestPosition) {
		this.adInvestPosition = adInvestPosition;
	}
	
	/**
	 * 刊登位置
	 * @return
	 */
	public java.lang.String getAdInvestPosition() {
		return this.adInvestPosition;
	}
	/**
	 * 广审号
	 * @param trialNo
	 */
	public void setTrialNo(java.lang.String trialNo) {
		this.trialNo = trialNo;
	}
	
	/**
	 * 广审号
	 * @return
	 */
	public java.lang.String getTrialNo() {
		return this.trialNo;
	}
	/**
	 * 提交日期
	 * @param adSubmitTime
	 */
	public void setAdSubmitTime(java.util.Date adSubmitTime) {
		this.adSubmitTime = adSubmitTime;
	}
	
	/**
	 * 提交日期
	 * @return
	 */
	public java.util.Date getAdSubmitTime() {
		return this.adSubmitTime;
	}
	/**
	 * 审核日期
	 * @param adAuditTime
	 */
	public void setAdAuditTime(java.util.Date adAuditTime) {
		this.adAuditTime = adAuditTime;
	}
	
	/**
	 * 审核日期
	 * @return
	 */
	public java.util.Date getAdAuditTime() {
		return this.adAuditTime;
	}
	/**
	 * 审核意见
	 * @param adAuditOpinion
	 */
	public void setAdAuditOpinion(java.lang.String adAuditOpinion) {
		this.adAuditOpinion = adAuditOpinion;
	}
	
	/**
	 * 审核意见
	 * @return
	 */
	public java.lang.String getAdAuditOpinion() {
		return this.adAuditOpinion;
	}
	/**
	 * 广告附件名称
	 * @param adAttachmentName
	 */
	public void setAdAttachmentName(java.lang.String adAttachmentName) {
		this.adAttachmentName = adAttachmentName;
	}
	
	/**
	 * 广告附件名称
	 * @return
	 */
	public java.lang.String getAdAttachmentName() {
		return this.adAttachmentName;
	}
	/**
	 * 广告附件路径
	 * @param adAttachmentPath
	 */
	public void setAdAttachmentPath(java.lang.String adAttachmentPath) {
		this.adAttachmentPath = adAttachmentPath;
	}
	
	/**
	 * 广告附件路径
	 * @return
	 */
	public java.lang.String getAdAttachmentPath() {
		return this.adAttachmentPath;
	}
	/**
	 * 报批日期
	 * @param adRecordTime
	 */
	public void setAdRecordTime(java.util.Date adRecordTime) {
		this.adRecordTime = adRecordTime;
	}
	
	/**
	 * 报批日期
	 * @return
	 */
	public java.util.Date getAdRecordTime() {
		return this.adRecordTime;
	}
	/**
	 * 联系人姓名
	 * @param adContactName
	 */
	public void setAdContactName(java.lang.String adContactName) {
		this.adContactName = adContactName;
	}
	
	/**
	 * 联系人姓名
	 * @return
	 */
	public java.lang.String getAdContactName() {
		return this.adContactName;
	}
	/**
	 * 联系人电话
	 * @param adContactPhone
	 */
	public void setAdContactPhone(java.lang.String adContactPhone) {
		this.adContactPhone = adContactPhone;
	}
	
	/**
	 * 联系人电话
	 * @return
	 */
	public java.lang.String getAdContactPhone() {
		return this.adContactPhone;
	}
	/**
	 * 刊登费
	 * @param adFee
	 */
	public void setAdFee(java.lang.Long adFee) {
		this.adFee = adFee;
	}
	
	/**
	 * 刊登费
	 * @return
	 */
	public java.lang.Long getAdFee() {
		return this.adFee;
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