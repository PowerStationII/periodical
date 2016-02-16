package com.cn.periodical.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.cn.periodical.enums.ArticalCodeEnums;
import com.cn.periodical.enums.RoleIdEnums;
import com.cn.periodical.manager.*;
import com.cn.periodical.pojo.*;
import com.cn.periodical.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cn.periodical.enums.ArticleStateEnums;
import com.cn.periodical.request.AuthorContributeReqDto;
import com.cn.periodical.service.AuthorContributeService;
import com.cn.periodical.utils.FileCopyUtils;
import com.cn.periodical.utils.PropertiesInitManager;

@Service
public class AuthorContributeServiceImpl implements AuthorContributeService {
	private static final Logger logger = LoggerFactory.getLogger(AuthorContributeServiceImpl.class);

	@Autowired
	AuthorInfoManager authorInfoManager;
	
	@Autowired
	UserInfoManager userInfoManager;
	
	@Autowired
	ArticleInfoManager articleInfoManager;
	
	@Autowired
	ArticleAttachmentInfoManager articleAttachmentInfoManager;
	
	@Autowired
	AddressInfoManager addressInfoManager;
	
	@Autowired
	ArticleInfoExtendManager articleInfoExtendManager;
	@Autowired
	ArticleInfoStateManager articleInfoStateManager;
	
	@Autowired
	TransactionTemplate transactionTemplate;
	
	
	@Autowired
	ArticleFlowsManager articleFlowsManager;

    @Autowired
    ArticalCodeManager articalCodeManager;

    @Autowired
    PeriodicalChongtouLogManager periodicalChongtouLogManager;


    public AuthorContributeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 投稿的业务流程:
	 * 1,article_info:稿件详情并记录最新的稿件流水id,此处为1L
	 * 2,article_info_extend:记录userId
	 * 3,article_flows:稿件流水
	 * 4,author_info:作者信息
	 * 5,address_info:地址信息
	 * 缺失:事务处理
	 * */
	public void saveArticle(final AuthorContributeReqDto contributeRequestDto,MultipartFile[] files,HttpServletRequest request) throws Exception {
		/**
		 * 保存上传的附件
		 * */
		String[] paths =  new String[5];

        final String articleId = articalCodeManager.getCode(ArticalCodeEnums.GAOJIAN_CODE.getCode(),ArticalCodeEnums.GAOJIAN_CODE.getName());
		
		//判断file数组不能为空并且长度大于0  
        if(files!=null&&files.length>0){  
            //循环获取file数组中得文件  
            for(int i = 0;i<files.length;i++){  
                MultipartFile file = files[i];
                if(!"".equals(file.getOriginalFilename())){
                    logger.info(file.getOriginalFilename());
                    //保存文件
                    paths[i]=saveFile(file,request,contributeRequestDto.getUserId(),articleId);
                }
            }
        }else{
        	throw new Exception("上传稿件异常!!");
        }
        final ArticleAttachmentInfo articleAttachmentInfo = new ArticleAttachmentInfo();
        
        articleAttachmentInfo.setArticleId(articleId);
        articleAttachmentInfo.setAttachmentName(files[0].getOriginalFilename());
        articleAttachmentInfo.setAttachmentPath(paths[0]);
        if(null!=files[1] && !"".equals(files[1].getOriginalFilename())){
            articleAttachmentInfo.setBdjcbgAttachmentName(files[1].getOriginalFilename());
            articleAttachmentInfo.setBdjcbgAttachmentPath(paths[1]);
        }
        if(null!=files[2] && !"".equals(files[2].getOriginalFilename())){
            articleAttachmentInfo.setCxcnsAttachmentName(files[2].getOriginalFilename());
            articleAttachmentInfo.setCxcnsAttachmentPath(paths[2]);
        }
        articleAttachmentInfo.setEditTimes(0);
        if(null!=files[3] && !"".equals(files[3].getOriginalFilename())){
            articleAttachmentInfo.setSjtztsjAttachmentName(files[3].getOriginalFilename());
            articleAttachmentInfo.setSjtztsjAttachmentPath(paths[3]);
        }
        if(null!=files[4] && !"".equals(files[4].getOriginalFilename())){
            articleAttachmentInfo.setYjspzpAttachmentName(files[4].getOriginalFilename());
            articleAttachmentInfo.setYjspzpAttachmentPath(paths[4]);
        }
        articleAttachmentInfo.setType(contributeRequestDto.getRoleId());
        articleAttachmentInfo.setStatus("Y");
        articleAttachmentInfo.setCreateTime(new Date());
        articleAttachmentInfo.setUpdateTime(new Date());
        
		
		final ArticleInfo articleInfo =new ArticleInfo();
		articleInfo.setArticleCnKeywords(contributeRequestDto.getArticleCnKeywords());
		articleInfo.setArticleCnSummary(contributeRequestDto.getArticleCnSummary());
		articleInfo.setArticleCnTitle(contributeRequestDto.getArticleCnTitle());
		articleInfo.setArticleEnKeywords(contributeRequestDto.getArticleEnKeywords());
		articleInfo.setArticleEnSummary(contributeRequestDto.getArticleEnSummary());
		articleInfo.setArticleEnTile(contributeRequestDto.getArticleEnTile());
		articleInfo.setArticleId(articleId);
		articleInfo.setArticleName(contributeRequestDto.getArticleName());
		articleInfo.setArticleType(contributeRequestDto.getArticleType().getCode());//0新稿1返修稿
		articleInfo.setArtilce(null);
		articleInfo.setClassificationNums(contributeRequestDto.getClassificationNums());
		articleInfo.setDocumentCode(contributeRequestDto.getDocumentCode());
		articleInfo.setTotalPages(contributeRequestDto.getTotalPages());
		articleInfo.setTotalPics(contributeRequestDto.getTotalPics());
		articleInfo.setTotalTabs(contributeRequestDto.getTotalTabs());
		articleInfo.setFundTitle(contributeRequestDto.getFundTitle());
		articleInfo.setIsAvaliable("Y");
		articleInfo.setExtends2("");
		articleInfo.setExtends3("N");
		articleInfo.setExtends4("");
		articleInfo.setInvestSection(contributeRequestDto.getInvestSection());
		articleInfo.setAuthorState(ArticleStateEnums.NEW_ARTICLE.getCode());
		articleInfo.setEditorState(ArticleStateEnums.NEW_ARTICLE.getCode());
		articleInfo.setExpertState("");
		articleInfo.setRemark(contributeRequestDto.getRemark());
		articleInfo.setReferenceDoc(contributeRequestDto.getReferenceDoc());
		articleInfo.setReceiveArticleTime(new Date());
		articleInfo.setPublishTime(null);
		articleInfo.setInovationPoint(contributeRequestDto.getInovationPoint());
		articleInfo.setIsfund(contributeRequestDto.getIsfund());
		articleInfo.setLatelyFlowsId(1L);
		articleInfo.setCreateTime(new Date());
		
		final ArticleInfoExtend articleInfoExtend = new ArticleInfoExtend();
		articleInfoExtend.setUserId(contributeRequestDto.getUserId());
		articleInfoExtend.setArticleId(articleId);
		articleInfoExtend.setRoleId(contributeRequestDto.getRoleId());
		
		final ArticleInfoState articleInfoState =  new ArticleInfoState();
		articleInfoState.setArticleId(articleId);
		articleInfoState.setEditorDownload("N");//编辑第一次下载稿件时,记录流水
		articleInfoState.setExpertDownload("N");//专家第一次下载稿件时,记录流水
		articleInfoState.setEnExpertUpload("N");
		articleInfoState.setPeriodicalId(contributeRequestDto.getPeriodicalId());
		articleInfoState.setPeriodicalName(contributeRequestDto.getPeriodicalName());
		
		final List<AuthorInfo> authorInfos = contributeRequestDto.getAuthorList();
        int isContacter = 0 ;
        for(AuthorInfo authorInfo :authorInfos ){
             if("Y".equals(authorInfo.getIsContacter())){
                 isContacter++ ;
             }
        }
        if(isContacter!=1){
            throw new Exception("只能有一个通讯作者");
        }

		final List<AddressInfo> addressInfos = contributeRequestDto.getAddressInfos();
		logger.info(authorInfos.size()+"------------"+addressInfos.size());
		
		int k =(Integer) transactionTemplate.execute(new TransactionCallback<Object> (){
			public Object doInTransaction(TransactionStatus status) {
				try {
					for(int i=0;i<authorInfos.size();i++){
						String authorId= UUID.randomUUID().toString().replaceAll("-", "");    // article's author
						String addressId= UUID.randomUUID().toString().replaceAll("-", "");   // articel's author's address
						AuthorInfo authorInfo = authorInfos.get(i);
						AddressInfo addressInfo = addressInfos.get(i);
						
						authorInfo.setArticleId(articleId);
						authorInfo.setAuthorId(authorId);
						
						addressInfo.setRefId(authorId);
						addressInfo.setAddressId(addressId);
						addressInfo.setRefRoleId(contributeRequestDto.getRoleId());
						authorInfoManager.saveAuthorInfo(authorInfo);// 这个表里放了注册作者的信息，投稿作者的信息
						addressInfoManager.saveAddressInfo(addressInfo);
					}
					articleInfoStateManager.saveArticleInfoState(articleInfoState);
					articleInfoManager.saveArticleInfo(articleInfo);
					articleAttachmentInfoManager.saveArticleAttachmentInfo(articleAttachmentInfo);
					articleInfoExtendManager.saveArticleInfoExtend(articleInfoExtend);
				}catch(Exception e){
					logger.error("投稿功能异常:"+e);
					status.setRollbackOnly();
					return 0;
				}
				return 1;
			}
		});
		
		if(k==1){
			/**
			 * 登记稿件流水
			 * */
			ArticleFlows articleFlows = new ArticleFlows();
			articleFlows.setId(1L); // why give value for id ?
			articleFlows.setPid(0L);// what is the pid ? yuguodong
			articleFlows.setUserId(contributeRequestDto.getUserId());
			articleFlows.setCreateTime(new Date());
			articleFlows.setRoleId(contributeRequestDto.getRoleId());
			articleFlows.setDealState(ArticleStateEnums.NEW_ARTICLE.getCode());
			articleFlows.setArticleId(articleId);
			articleFlows.setDealStartTime(new Date());
			articleFlows.setDealEndTime(new Date());
			articleFlows.setExtend2("N");/**为了审批意见是否作者可见而改*/
			articleFlowsManager.saveArticleFlowsNew(articleFlows);
		}


	}
	/**
	 * 重新投稿的业务流程:
	 * 1,article_info:稿件详情并记录最新的稿件流水id,此处为1L
	 * 2,article_info_extend:记录userId
	 * 3,article_flows:稿件流水
	 * 4,author_info:作者信息
	 * 5,address_info:地址信息
	 * 缺失:事务处理
	 * */
	public void saveChongTouArticle(final AuthorContributeReqDto contributeRequestDto,MultipartFile[] files,HttpServletRequest request) throws Exception {
        // 初投稿的文章编号
        final String  orgAtricleId = contributeRequestDto.getArticleId();
        /**
		 * 保存上传的附件
		 * */
		String[] paths =  new String[5];
        // 生成重投搞的稿件编号
        final String articleId = articalCodeManager.getCode(ArticalCodeEnums.GAOJIAN_CODE.getCode(),ArticalCodeEnums.GAOJIAN_CODE.getName());

		//判断file数组不能为空并且长度大于0
        if(files!=null&&files.length>0){
            //循环获取file数组中得文件
            for(int i = 0;i<files.length;i++){
                MultipartFile file = files[i];
                logger.info(file.getOriginalFilename());
                //保存文件
                paths[i]=saveFile(file,request,contributeRequestDto.getUserId(),articleId);
            }
        }else{
        	throw new Exception("上传稿件异常!!");
        }
        ArticleInfoExtendQuery example = new ArticleInfoExtendQuery () ;
        example.setArticleId(orgAtricleId);
        example.setRoleId(RoleIdEnums.AUTHOR.getCode());
        final ArticleInfoExtend articleInfoExtend = articleInfoExtendManager.selectByArticleIdKey(example);
        articleInfoExtend.setId(null);
        articleInfoExtend.setArticleId(articleId);
        /**
         * 附件（文章，以及文章的其他4个附件）
         */
        final ArticleAttachmentInfo articleAttachmentInfo = new ArticleAttachmentInfo();
        articleAttachmentInfo.setArticleId(articleId);
        articleAttachmentInfo.setAttachmentName(files[0].getOriginalFilename());
        articleAttachmentInfo.setAttachmentPath(paths[0]);
        articleAttachmentInfo.setEditTimes(0);
        articleAttachmentInfo.setType(articleInfoExtend.getRoleId());
        articleAttachmentInfo.setStatus("Y");
        articleAttachmentInfo.setCreateTime(new Date());
        articleAttachmentInfo.setUpdateTime(new Date());


        final ArticleInfo articleInfo = articleInfoManager.selectByArticleId(orgAtricleId);
        articleInfo.setId(null);
		articleInfo.setArticleId(articleId);
		articleInfo.setArtilce(null);
		articleInfo.setIsAvaliable("Y");
		articleInfo.setExtends2("");
		articleInfo.setExtends3("N");
		articleInfo.setExtends4("");
		articleInfo.setAuthorState(ArticleStateEnums.NEW_ARTICLE.getCode());
		articleInfo.setEditorState(ArticleStateEnums.NEW_ARTICLE.getCode());
		articleInfo.setExpertState("");
		articleInfo.setReceiveArticleTime(new Date());
		articleInfo.setPublishTime(null);
		articleInfo.setLatelyFlowsId(1L);
		articleInfo.setCreateTime(new Date());


        final ArticleInfoState articleInfoState =  articleInfoStateManager.selectByArticleIdKey(orgAtricleId);
        articleInfoState.setId(null);
        articleInfoState.setArticleId(articleId);
		articleInfoState.setEditorDownload("N");//编辑第一次下载稿件时,记录流水
		articleInfoState.setExpertDownload("N");//专家第一次下载稿件时,记录流水
		articleInfoState.setEnExpertUpload("N");

        final List<AuthorInfo> authorInfos = authorInfoManager.selectByArticleIdKey(orgAtricleId);
        final List<AddressInfo> addressInfos = contributeRequestDto.getAddressInfos(); // 这个不从前台取了， 直接查询出来，然后赋值保存
		logger.info(authorInfos.size()+"------------"+addressInfos.size());

		int k =(Integer) transactionTemplate.execute(new TransactionCallback<Object> (){
			public Object doInTransaction(TransactionStatus status) {
				try {
					for(int i=0;i<authorInfos.size();i++){
						AuthorInfo authorInfo = authorInfos.get(i);
                        authorInfo.setId(null);
						authorInfo.setArticleId(articleId);
                        String authorId = authorInfo.getAuthorId();

                        AddressInfoQuery example = new AddressInfoQuery ();
                        example.setRefId(authorId);
                        example.setRefRoleId(RoleIdEnums.AUTHOR.getCode());
                        AddressInfo addressInfo = addressInfoManager.selectByArticleIdKey(example);
                        addressInfo.setId(null);
						authorInfoManager.saveAuthorInfo(authorInfo);// 这个表里放了注册作者的信息，投稿作者的信息
						addressInfoManager.saveAddressInfo(addressInfo);  // 一个作者对应一个地址  这里可能会与问题，没有区别文章
					}
					articleInfoStateManager.saveArticleInfoState(articleInfoState);
					articleInfoManager.saveArticleInfo(articleInfo);
					articleAttachmentInfoManager.saveArticleAttachmentInfo(articleAttachmentInfo);
					articleInfoExtendManager.saveArticleInfoExtend(articleInfoExtend);

                    /**
                     * 登记稿件流水
                     * */
                    ArticleFlows articleFlows = new ArticleFlows();
                    articleFlows.setId(1L); // why give value for id ?
                    articleFlows.setPid(0L);// what is the pid ? yuguodong
                    articleFlows.setUserId(articleInfoExtend.getUserId());
                    articleFlows.setCreateTime(new Date());
                    articleFlows.setRoleId(articleInfoExtend.getRoleId());
                    articleFlows.setDealState(ArticleStateEnums.NEW_ARTICLE.getCode());
                    articleFlows.setArticleId(articleId);
                    articleFlows.setDealStartTime(new Date());
                    articleFlows.setDealEndTime(new Date());
                    articleFlows.setExtend2("N");/**为了审批意见是否作者可见而改*/
                    articleFlowsManager.saveArticleFlowsNew(articleFlows);

                    /**
                     * 记录重投流水
                     */
                    PeriodicalChongtouLog periodicalChongtouLog = new PeriodicalChongtouLog () ;
                    periodicalChongtouLog.setArticleNo(articleId);
                    List<PeriodicalChongtouLog> listFanxiu = periodicalChongtouLogManager.selectByCondition(periodicalChongtouLog);
                    if(null!= listFanxiu  && !listFanxiu.isEmpty()){
                        PeriodicalChongtouLog periodicalChongtouLog_temp = listFanxiu.get(0);
                        periodicalChongtouLog.setOriarticleNo(orgAtricleId);
                        periodicalChongtouLog.setArticleNo(articleId);
                        periodicalChongtouLog.setGroupFlag(periodicalChongtouLog_temp.getGroupFlag());
                        periodicalChongtouLog.setFanxiuCount(periodicalChongtouLog_temp.getFanxiuCount()+1);

                    }else{
                        periodicalChongtouLog.setOriarticleNo(orgAtricleId);
                        periodicalChongtouLog.setArticleNo(articleId);
                        periodicalChongtouLog.setGroupFlag(orgAtricleId);
                        periodicalChongtouLog.setFanxiuCount(1);
                    }
                    periodicalChongtouLogManager.insert(periodicalChongtouLog);
				}catch(Exception e){
					logger.error("投稿功能异常:"+e);
					status.setRollbackOnly();
					return 0;
				}
				return 1;
			}
		});

	}

	
	private String saveFile(@RequestParam(value="file", required=true) MultipartFile file,HttpServletRequest request,String userId,String articleId) throws Exception{  
    	PropertiesInitManager.dataInit();
    	String basePath = PropertiesInitManager.PROPERTIES.getProperty("filePath");
    	StringBuffer sbPath = new StringBuffer();
    	sbPath.append(basePath);
    	sbPath.append(File.separator);
    	sbPath.append(userId);
    	sbPath.append(File.separator);
    	sbPath.append(articleId);
    	sbPath.append(File.separator);
    	String filePath = sbPath.toString();
    	File headPath = new File(filePath);//获取文件夹路径       
    	if(!headPath.exists()){
    	//判断文件夹是否创建，没有创建则创建新文件夹        	
    		headPath.mkdirs();
    	}
    	
    	String fileName = filePath+file.getOriginalFilename();
    	File uploadFile = new File(fileName); 
        // 转存文件  
        file.transferTo(uploadFile);  
        logger.info(uploadFile.getAbsolutePath());
        return uploadFile.getAbsolutePath();  
    }


    public void saveAtricalAtt(String articleId , String attName , String attPath , String type) throws Exception {
        try{
            ArticleAttachmentInfoQuery articleAttachmentInfoQuery = new ArticleAttachmentInfoQuery();
            articleAttachmentInfoQuery.setArticleId(articleId);
            articleAttachmentInfoQuery.setType(type);
            List<ArticleAttachmentInfo> list = articleAttachmentInfoManager.queryList(articleAttachmentInfoQuery);
            ArticleAttachmentInfo copyFile = new ArticleAttachmentInfo();
            if(null!=list && !list.isEmpty()){
                copyFile.setId(list.get(0).getId());
            }
            copyFile.setArticleId(articleId);
            copyFile.setAttachmentName(attName);
            copyFile.setAttachmentPath(attPath+File.separator+attName);
            copyFile.setBdjcbgAttachmentName("");
            copyFile.setBdjcbgAttachmentPath("");
            copyFile.setCxcnsAttachmentName("");
            copyFile.setCxcnsAttachmentPath("");
            copyFile.setEditTimes(0);
            copyFile.setSjtztsjAttachmentName("");
            copyFile.setSjtztsjAttachmentPath("");
            copyFile.setYjspzpAttachmentName("");
            copyFile.setYjspzpAttachmentPath("");
            copyFile.setType(type);// 1006
            copyFile.setStatus("Y");
            copyFile.setCreateTime(new Date());
            copyFile.setUpdateTime(new Date());

            articleAttachmentInfoManager.saveArticleAttachmentInfo(copyFile);
        }catch(Exception e){
            logger.info("稿件复制异常!!!怎么通知系统呢?");
            throw new Exception("复制稿件到编辑目录出错!!"+e.getMessage());
        }
    }
}
