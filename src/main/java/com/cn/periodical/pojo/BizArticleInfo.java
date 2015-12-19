package com.cn.periodical.pojo;

import java.io.Serializable;
import java.util.List;

public class BizArticleInfo implements Serializable {

	public BizArticleInfo() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * */
	private BizUserArticleExtendInfo bizUserArticleExtendInfo;
	private List<ArticleInfo> articleInfos;
	private ArticleInfoState articleInfoState;
	private List<BizAuthorAddressInfo> bizAuthorAddressInfos;
	private List<ArticleAttachmentInfo> articleAttachmentInfos;
	
	
	
	
}
