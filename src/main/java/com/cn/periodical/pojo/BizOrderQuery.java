package com.cn.periodical.pojo;

import com.cn.periodical.utils.PagingQuery;

public class BizOrderQuery extends PagingQuery {

    public  BizOrderQuery(){
        super(1, 10);
    }

    public  BizOrderQuery(int pageNo, int pageSize){
        super(pageNo, pageSize);
    }
	private String pCnName;
	private String oStatus;
	private String oAmount;
	private String piName;
	private String piUrl;
	private String payNo;
	private String payAmount;
	private String eAccountNo;
	private String eAccountName;
	private String orderNo;
	private String pYear;
	private String subNums;
	private String amount;
	private String submitTime;
	private String auditTime;
	private String userId;
	private String erAccount;
	private String erName;
	private String aPayAmount;
	private String readerName;
	private String iFprice;
	private String cycle;
	private String periodicalId;
	private String addressId;
	private String contacterName;
	private String contacterTelephone;
	private String receiveAddress;
	private String receivePostCode;
	private String distributNum;
	private String distributId;
	private String pIsNo;
	
	public String getpIsNo() {
		return pIsNo;
	}
	public void setpIsNo(String pIsNo) {
		this.pIsNo = pIsNo;
	}
	public String getDistributId() {
		return distributId;
	}
	public void setDistributId(String distributId) {
		this.distributId = distributId;
	}
	public String getPeriodicalId() {
		return periodicalId;
	}
	public void setPeriodicalId(String periodicalId) {
		this.periodicalId = periodicalId;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getContacterName() {
		return contacterName;
	}
	public void setContacterName(String contacterName) {
		this.contacterName = contacterName;
	}
	public String getContacterTelephone() {
		return contacterTelephone;
	}
	public void setContacterTelephone(String contacterTelephone) {
		this.contacterTelephone = contacterTelephone;
	}
	public String getReceiveAddress() {
		return receiveAddress;
	}
	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}
	public String getReceivePostCode() {
		return receivePostCode;
	}
	public void setReceivePostCode(String receivePostCode) {
		this.receivePostCode = receivePostCode;
	}
	public String getDistributNum() {
		return distributNum;
	}
	public void setDistributNum(String distributNum) {
		this.distributNum = distributNum;
	}
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	public String getiFprice() {
		return iFprice;
	}
	public void setiFprice(String iFprice) {
		this.iFprice = iFprice;
	}
	public String getCycle() {
		return cycle;
	}
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	public String getaPayAmount() {
		return aPayAmount;
	}
	public void setaPayAmount(String aPayAmount) {
		this.aPayAmount = aPayAmount;
	}
	public String getErAccount() {
		return erAccount;
	}
	public void setErAccount(String erAccount) {
		this.erAccount = erAccount;
	}
	public String getErName() {
		return erName;
	}
	public void setErName(String erName) {
		this.erName = erName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getpYear() {
		return pYear;
	}
	public void setpYear(String pYear) {
		this.pYear = pYear;
	}
	public String getSubNums() {
		return subNums;
	}
	public void setSubNums(String subNums) {
		this.subNums = subNums;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public String getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(String auditTime) {
		this.auditTime = auditTime;
	}
	public String getpCnName() {
		return pCnName;
	}
	public void setpCnName(String pCnName) {
		this.pCnName = pCnName;
	}
	public String getoStatus() {
		return oStatus;
	}
	public void setoStatus(String oStatus) {
		this.oStatus = oStatus;
	}
	public String getoAmount() {
		return oAmount;
	}
	public void setoAmount(String oAmount) {
		this.oAmount = oAmount;
	}
	public String getPiName() {
		return piName;
	}
	public void setPiName(String piName) {
		this.piName = piName;
	}
	public String getPiUrl() {
		return piUrl;
	}
	public void setPiUrl(String piUrl) {
		this.piUrl = piUrl;
	}
	public String getPayNo() {
		return payNo;
	}
	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}
	public String getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}
	public String geteAccountNo() {
		return eAccountNo;
	}
	public void seteAccountNo(String eAccountNo) {
		this.eAccountNo = eAccountNo;
	}
	public String geteAccountName() {
		return eAccountName;
	}
	public void seteAccountName(String eAccountName) {
		this.eAccountName = eAccountName;
	}
}
