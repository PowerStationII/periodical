package com.cn.periodical.pojo;

import com.cn.periodical.utils.PagingQuery;

public class BizPeriodicalQuery extends PagingQuery {

	public BizPeriodicalQuery() {
        super(1, 10);
	}

    public  BizPeriodicalQuery(int pageNo, int pageSize){
        super(pageNo, pageSize);
    }
	
	private String pId;//期刊id
	private String pCnName;//期刊中文名称
	private String hOrgan;//主办单位
	private String cycle;//周期
	private String press;//编辑社
	private String isNo;//刊号
	private String iFPrice;//国内定价
	private String cNums;//第*期
	private String pIsNo;//期刊编号
	private String pState;//期刊状态
	private String pYear;//年份
	private String isOpinion;//签发意见
	private String isTime;//签发时间
	private String aCnTitle;
	private String aId;
	private String section;
	private String extend1;//英文专家是否审核完毕Y
	
	
	public String getExtend1() {
		return extend1;
	}
	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}

	private String attachmentName;
	private String attachmentPath;
	
	
	
	
	public String getAttachmentName() {
		return attachmentName;
	}
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	public String getaCnTitle() {
		return aCnTitle;
	}
	public void setaCnTitle(String aCnTitle) {
		this.aCnTitle = aCnTitle;
	}
	public String getaId() {
		return aId;
	}
	public void setaId(String aId) {
		this.aId = aId;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getpCnName() {
		return pCnName;
	}
	public void setpCnName(String pCnName) {
		this.pCnName = pCnName;
	}
	public String gethOrgan() {
		return hOrgan;
	}
	public void sethOrgan(String hOrgan) {
		this.hOrgan = hOrgan;
	}
	public String getCycle() {
		return cycle;
	}
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getIsNo() {
		return isNo;
	}
	public void setIsNo(String isNo) {
		this.isNo = isNo;
	}
	public String getiFPrice() {
		return iFPrice;
	}
	public void setiFPrice(String iFPrice) {
		this.iFPrice = iFPrice;
	}
	public String getcNums() {
		return cNums;
	}
	public void setcNums(String cNums) {
		this.cNums = cNums;
	}
	public String getpIsNo() {
		return pIsNo;
	}
	public void setpIsNo(String pIsNo) {
		this.pIsNo = pIsNo;
	}
	public String getpState() {
		return pState;
	}
	public void setpState(String pState) {
		this.pState = pState;
	}
	public String getpYear() {
		return pYear;
	}
	public void setpYear(String pYear) {
		this.pYear = pYear;
	}
	public String getIsOpinion() {
		return isOpinion;
	}
	public void setIsOpinion(String isOpinion) {
		this.isOpinion = isOpinion;
	}
	public String getIsTime() {
		return isTime;
	}
	public void setIsTime(String isTime) {
		this.isTime = isTime;
	}
}
