package com.cn.periodical.pojo;

import java.io.Serializable;

import com.cn.periodical.utils.PagingQuery;

public class BizDistribut extends PagingQuery implements Serializable {

	public BizDistribut() {
		// TODO Auto-generated constructor stub
		super(1, 10);
	}
	public  BizDistribut(int pageNo, int pageSize){
		super(pageNo, pageSize);
	}
	
	private String aId;
	private String cName;
	private String cMobile;
	private String rAddress;
	private String rPostCode;
	private String rContacter;
	private String status;
	private String userId;
	private int nums;
	private String dStatus;
	private String pId;
	private String sId1;
	private int sIdNums1;
	private String sId2;
	private int sIdNums2;
	private String sId3;
	private int sIdNums3;
	private int dNums;
	private String amount;
	private String orderNo;
	private String oStatus;
	private String pCnName;
	private String pIsNo;
	private String extends2;

	
	
	
	
	
	
	public String getpIsNo() {
		return pIsNo;
	}
	public void setpIsNo(String pIsNo) {
		this.pIsNo = pIsNo;
	}
	public String getdStatus() {
		return dStatus;
	}
	public void setdStatus(String dStatus) {
		this.dStatus = dStatus;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getsId1() {
		return sId1;
	}
	public void setsId1(String sId1) {
		this.sId1 = sId1;
	}
	public int getsIdNums1() {
		return sIdNums1;
	}
	public void setsIdNums1(int sIdNums1) {
		this.sIdNums1 = sIdNums1;
	}
	public String getsId2() {
		return sId2;
	}
	public void setsId2(String sId2) {
		this.sId2 = sId2;
	}
	public int getsIdNums2() {
		return sIdNums2;
	}
	public void setsIdNums2(int sIdNums2) {
		this.sIdNums2 = sIdNums2;
	}
	public String getsId3() {
		return sId3;
	}
	public void setsId3(String sId3) {
		this.sId3 = sId3;
	}
	public int getsIdNums3() {
		return sIdNums3;
	}
	public void setsIdNums3(int sIdNums3) {
		this.sIdNums3 = sIdNums3;
	}
	public int getdNums() {
		return dNums;
	}
	public void setdNums(int dNums) {
		this.dNums = dNums;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getoStatus() {
		return oStatus;
	}
	public void setoStatus(String oStatus) {
		this.oStatus = oStatus;
	}
	public String getpCnName() {
		return pCnName;
	}
	public void setpCnName(String pCnName) {
		this.pCnName = pCnName;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public String getaId() {
		return aId;
	}
	public void setaId(String aId) {
		this.aId = aId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcMobile() {
		return cMobile;
	}
	public void setcMobile(String cMobile) {
		this.cMobile = cMobile;
	}
	public String getrAddress() {
		return rAddress;
	}
	public void setrAddress(String rAddress) {
		this.rAddress = rAddress;
	}
	public String getrPostCode() {
		return rPostCode;
	}
	public void setrPostCode(String rPostCode) {
		this.rPostCode = rPostCode;
	}
	public String getrContacter() {
		return rContacter;
	}
	public void setrContacter(String rContacter) {
		this.rContacter = rContacter;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

    public String getExtends2() {
        return extends2;
    }

    public void setExtends2(String extends2) {
        this.extends2 = extends2;
    }
}
