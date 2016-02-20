package com.cn.periodical.pojo;

import com.cn.periodical.utils.PagingQuery;

public class BizCouncilQuery extends PagingQuery {

	public BizCouncilQuery() {
        super(1, 10);
	}
	public BizCouncilQuery(int pageNo, int pageSize) {
        super(pageNo, pageSize);
	}
	private String adCounts;
	private String amount;
	private String contractStartTime;
	private String contractEndTime;
	private String registerTime;
	private String type;
	private String ad;
	private String councilId;
	private String councilCompanyName;
	private String invoiceNo;
	
	
	
	public String getContractStartTime() {
		return contractStartTime;
	}
	public void setContractStartTime(String contractStartTime) {
		this.contractStartTime = contractStartTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAdCounts() {
		return adCounts;
	}
	public void setAdCounts(String adCounts) {
		this.adCounts = adCounts;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getContractEndTime() {
		return contractEndTime;
	}
	public void setContractEndTime(String contractEndTime) {
		this.contractEndTime = contractEndTime;
	}
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getCouncilId() {
		return councilId;
	}
	public void setCouncilId(String councilId) {
		this.councilId = councilId;
	}
	public String getCouncilCompanyName() {
		return councilCompanyName;
	}
	public void setCouncilCompanyName(String councilCompanyName) {
		this.councilCompanyName = councilCompanyName;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
}
