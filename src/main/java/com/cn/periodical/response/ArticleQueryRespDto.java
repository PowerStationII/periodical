package com.cn.periodical.response;

import java.util.List;

import com.cn.periodical.pojo.AccountInfo;
import com.cn.periodical.pojo.AddressInfo;
import com.cn.periodical.pojo.ArticleAttachmentInfo;
import com.cn.periodical.pojo.ArticleFlows;
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.AuthorInfo;

public class ArticleQueryRespDto extends ResponseDto {

	public ArticleQueryRespDto() {
		// TODO Auto-generated constructor stub
	}
	
	private ArticleInfo articleInfo;
	private ArticleAttachmentInfo attachmentInfo;
	private List<AuthorInfo> authorInfos;
	private List<AddressInfo> addressInfo;
	private String authorName;
	private ArticleFlows articleFlows;
	private AccountInfo accountInfo;
	

}
