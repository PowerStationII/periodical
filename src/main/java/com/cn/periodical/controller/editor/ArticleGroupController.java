package com.cn.periodical.controller.editor;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.cn.periodical.enums.RoleIdEnums;
import com.cn.periodical.manager.*;
import com.cn.periodical.pojo.*;
import com.cn.periodical.utils.GenerateOrderNo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cn.periodical.enums.ArticleStateEnums;
import com.cn.periodical.enums.PeriodicalStateEnums;
import com.cn.periodical.response.EditorArticleDealRespDto;
import com.cn.periodical.service.EditorArticleDealService;
/**
 * 稿件编辑-组刊Controller
 * */
@Controller
public class ArticleGroupController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleGroupController.class);
	@Autowired
	PeriodicalInfoManager periodicalInfoManager;
	
	@Autowired
	PeriodicalManager periodicalManager;
	
	@Autowired
	SectionInfoManager sectionInfoManager;
	
	@Autowired
	EditorArticleDealService articleDealService;
	
	@Autowired
	PeriodicalDetailsManager periodicalDetailsManager;
	@Autowired
	ArticleInfoManager articleInfoManager;
	@Autowired
	AuthorInfoManager authorInfoManager;
    @Autowired
    ExpertInfoManager expertInfoManager;
    @Autowired
    SongKanDetailManager songKanDetailManager;

	/**
	 * toArticleGroupPage
	 * 排刊
	 */
	@RequestMapping(value="/toArticleGroupPage",method = RequestMethod.GET)
	public ModelAndView toArticleGroupPage(HttpServletRequest request) {
		logger.info("排刊组稿Page:[ ]");
		ModelAndView mav = new ModelAndView("editor_articleGroupPage");
		List<PeriodicalInfo> periodicalInfos = periodicalInfoManager.queryList(null);
		mav.addObject("list", periodicalInfos);
		return mav;
	}
	/**
	 * toArticleGroupPage
	 * 送刊
	 */
	@RequestMapping(value="/toArticleGroupPageSongKan",method = RequestMethod.GET)
	public ModelAndView toArticleGroupPageSongKan(HttpServletRequest request) {
		logger.info("排刊组稿PageSongKan:[ ]");
		ModelAndView mav = new ModelAndView("editor_articleGroupPageSongKan");
		List<PeriodicalInfo> periodicalInfos = periodicalInfoManager.queryList(null);
		mav.addObject("list", periodicalInfos);
		return mav;
	}
	/**
	 * toGroupPage
	 * 组稿
	 */
	@RequestMapping(value="/toGroupPage")
	public ModelAndView toGroupPage(HttpServletRequest request,String periodicalId,String periodicalIssueNo,String periodicalYear) {
		logger.info("组稿Page:[ "+periodicalId+" ]");
		ModelAndView mav = new ModelAndView("editor_groupPage");
        PeriodicalInfoQuery periodicalInfoQuery = new PeriodicalInfoQuery ();
        periodicalInfoQuery.setPeriodicalId(periodicalId);
        periodicalInfoQuery.setPeriodicalYear("");
		PeriodicalInfo periodicalInfo = periodicalInfoManager.selectByPeriodicalId(periodicalInfoQuery);
		PeriodicalQuery query = new PeriodicalQuery();
		query.setPeriodicalId(periodicalId);
		query.setPeriodicalIssueNo(periodicalIssueNo);
        query.setPeriodicalYear(periodicalYear);
        String periodicalYear1 = periodicalYear.substring(2,4);
		List<Periodical> periodicals = periodicalManager.queryList(query);
        if(null==periodicals || periodicals.isEmpty()){
            for(int i=1;i<=periodicalInfo.getCycle();i++){
                Periodical periodical = new Periodical();
                periodical.setPeriodicalId(periodicalInfo.getPeriodicalId());
//                periodical.setPeriodicalIssueNo(GenerateOrderNo.generateOrderNo()); //  就用国内刊号
                if(i<10){
                    periodical.setPeriodicalIssueNo(periodicalInfo.getPeriodicalId()+"-"+periodicalYear1+"0"+i);
                }else{
                    periodical.setPeriodicalIssueNo(periodicalInfo.getPeriodicalId()+"-"+periodicalYear1+i);
                }
//				periodical.setPeriodicalIssueNo(periodicalInfo.getCnNo());
                periodical.setPeriodicalState(PeriodicalStateEnums.NEW.getCode());
                periodical.setExtend2(PeriodicalStateEnums.NEW.getCode());
                periodical.setCycleNums(i);
                periodical.setPeriodicalYear(periodicalYear);
//				periodical.setPublishNums(periodicalInfo.getPublishNums()==null?10000:periodicalInfo.get);
                periodical.setCreateTime(new Date());
                periodicalManager.savePeriodical(periodical);
            }
            periodicals = periodicalManager.queryList(query);
        }
		mav.addObject("list", periodicals);
		mav.addObject("p", periodicalInfo);
		return mav;
	}
	/**
	 * toGroupPage
	 * 送刊
	 */
	@RequestMapping(value="/toGroupPageSongKan")
	public ModelAndView toGroupPageSongKan(HttpServletRequest request,String periodicalId,String periodicalIssueNo
    ,String periodicalYear) {
		logger.info("组稿Page:[ "+periodicalId+" ]");
		ModelAndView mav = new ModelAndView("editor_groupPageSongKan");
        PeriodicalInfoQuery periodicalInfoQuery = new PeriodicalInfoQuery ();
        periodicalInfoQuery.setPeriodicalId(periodicalId);
//        periodicalInfoQuery.setPeriodicalYear(periodicalYear);
		PeriodicalInfo periodicalInfo = periodicalInfoManager.selectByPeriodicalId(periodicalInfoQuery);
		PeriodicalQuery query = new PeriodicalQuery();
		query.setPeriodicalId(periodicalId);
		query.setPeriodicalIssueNo(periodicalIssueNo);
		query.setPeriodicalYear(periodicalYear);
		List<Periodical> periodicals = periodicalManager.queryList(query);
		mav.addObject("list", periodicals);
		mav.addObject("p", periodicalInfo);
		return mav;
	}

	
	/**
	 * toArticleGroupDetailPage
	 * 组稿详情页
	 */
	@RequestMapping(value="/toArticleGroupDetailPage")
	public ModelAndView toArticleGroupDetailPage(
            @RequestParam("periodicalId") String periodicalId,
            @RequestParam("periodicalIssueNo") String periodicalIssueNo,
            @RequestParam("articleId") String articleId,
            @RequestParam("title") String title,
			HttpServletRequest request) {
		logger.info("组稿左右Page:[ "+periodicalId+"]&["+periodicalIssueNo+"]");
		ModelAndView mav = new ModelAndView("editor_articleGroupDetailPage");

		List<EditorArticleDealRespDto> list = new ArrayList<EditorArticleDealRespDto>();
		ArticleInfoQuery articleInfoQuery = new ArticleInfoQuery();
		/**
		 * 取编辑处理完成(点击待刊按钮后)且专家是待刊的状态的稿件进行组刊
		 * */
		articleInfoQuery.setEditorState(ArticleStateEnums.END_ARTICLE.getCode());
		articleInfoQuery.setExpertState(ArticleStateEnums.PUBLISH_ARTICLE.getCode());
        articleInfoQuery.setArticleId(articleId);
        articleInfoQuery.setArticleCnTitle(title);
		articleInfoQuery.setExtends3("N");
		List<ArticleInfo> articleInfos = articleInfoManager.queryListZuGao(articleInfoQuery);
		Iterator<ArticleInfo> iters = articleInfos.iterator();
		while(iters.hasNext()){
			EditorArticleDealRespDto editorArticleDealRespDto = new EditorArticleDealRespDto();
			ArticleInfo articleInfo = iters.next();
			AuthorInfoQuery authorInfoQuery = new AuthorInfoQuery();
			authorInfoQuery.setArticleId(articleInfo.getOriArticleId());
			List<AuthorInfo> authorInfos = authorInfoManager.queryList(authorInfoQuery);
			editorArticleDealRespDto.setArticleInfo(articleInfo);
			editorArticleDealRespDto.setAuthorInfos(authorInfos);
//			editorArticleDealRespDto.setArticleAttachmentInfo(articleAttachmentInfo);
			list.add(editorArticleDealRespDto);
		}

		mav.addObject("list", list);


		SectionInfoQuery query =new SectionInfoQuery();
		query.setPeriodicalId(periodicalId);
		query.setPeriodicalIssueNo(periodicalIssueNo);
		query.setExtend1("N");
		List<SectionInfo> sectionInfos = sectionInfoManager.queryListForGroupAticle(query);
		mav.addObject("sList", sectionInfos);

		mav.addObject("periodicalIssueNo", periodicalIssueNo);
		mav.addObject("periodicalId", periodicalId);
		mav.addObject("articleId", articleId);
		mav.addObject("title", title);
		return mav;
	}
	/**
	 * toArticleGroupDetailPage
	 * 组稿详情页
	 */
	@RequestMapping(value="/toArticleGroupDetailPageShow")
	public ModelAndView toArticleGroupDetailPageShow(
            @RequestParam("periodicalId") String periodicalId,
            @RequestParam("periodicalIssueNo") String periodicalIssueNo,
            @RequestParam("articleId") String articleId,
            @RequestParam("title") String title,
			HttpServletRequest request) {
		logger.info("组稿左右Page:[ "+periodicalId+"]&["+periodicalIssueNo+"]");
		ModelAndView mav = new ModelAndView("editor_articleGroupDetailPageShow");

		List<EditorArticleDealRespDto> list = new ArrayList<EditorArticleDealRespDto>();
		ArticleInfoQuery articleInfoQuery = new ArticleInfoQuery();
		/**
		 * 取编辑处理完成(点击待刊按钮后)且专家是待刊的状态的稿件进行组刊
		 * */
		articleInfoQuery.setEditorState(ArticleStateEnums.END_ARTICLE.getCode());
		articleInfoQuery.setExpertState(ArticleStateEnums.PUBLISH_ARTICLE.getCode());
        articleInfoQuery.setArticleId(articleId);
        articleInfoQuery.setArticleCnTitle(title);
		articleInfoQuery.setExtends3("N");
		List<ArticleInfo> articleInfos = articleInfoManager.queryListZuGao(articleInfoQuery);
		Iterator<ArticleInfo> iters = articleInfos.iterator();
		while(iters.hasNext()){
			EditorArticleDealRespDto editorArticleDealRespDto = new EditorArticleDealRespDto();
			ArticleInfo articleInfo = iters.next();
			AuthorInfoQuery authorInfoQuery = new AuthorInfoQuery();
			authorInfoQuery.setArticleId(articleInfo.getArticleId());
			List<AuthorInfo> authorInfos = authorInfoManager.queryList(authorInfoQuery);
			editorArticleDealRespDto.setArticleInfo(articleInfo);
			editorArticleDealRespDto.setAuthorInfos(authorInfos);
//			editorArticleDealRespDto.setArticleAttachmentInfo(articleAttachmentInfo);
			list.add(editorArticleDealRespDto);
		}

		mav.addObject("list", list);


		SectionInfoQuery query =new SectionInfoQuery();
		query.setPeriodicalId(periodicalId);
		query.setPeriodicalIssueNo(periodicalIssueNo);
		query.setExtend1("N");
		List<SectionInfo> sectionInfos = sectionInfoManager.queryListForGroupAticle(query);
		mav.addObject("sList", sectionInfos);

		mav.addObject("periodicalIssueNo", periodicalIssueNo);
		mav.addObject("periodicalId", periodicalId);
		mav.addObject("articleId", articleId);
		mav.addObject("title", title);
		return mav;
	}
	/**
	 * toArticleGroupDetailPage
	 * 送刊详情页
	 */
	@RequestMapping(value="/toArticleGroupDetailPageSongKan",method = RequestMethod.GET)
	public ModelAndView toArticleGroupDetailPageSongKan(
			@RequestParam("periodicalId") String periodicalId,
			@RequestParam("periodicalIssueNo") String periodicalIssueNo,
            String qishu ,  String year ,
			HttpServletRequest request) {
		logger.info("送刊左右Page:[ "+periodicalId+"]&["+periodicalIssueNo+"]");
		ModelAndView mav = new ModelAndView("editor_articleGroupDetailPageSongKan");
        String orderNo = "" ;
		SectionInfoQuery query =new SectionInfoQuery();
		query.setPeriodicalId(periodicalId);
		query.setPeriodicalIssueNo(periodicalIssueNo);
		query.setExtend1("N");
        List<HashMap<String,Object>> showList = new ArrayList<HashMap<String, Object>>() ;
		List<SectionInfo> sectionInfos = sectionInfoManager.queryListForGroupAticle(query);
        for(SectionInfo sectionInfo : sectionInfos){
            List<Map<String, Object>> list = sectionInfo.getList();
            for(Map<String, Object> map : list){
                  String article_id = (String)map.get("articleId");// 文章显示的（第一次投的）
                String oriArticleId = (String)map.get("oriArticleId");// 文章id
                String title = (String)map.get("article_cn_title");// 文章标题

                AuthorInfoQuery authorInfoQuery = new AuthorInfoQuery();
                authorInfoQuery.setArticleId(oriArticleId);
                List<AuthorInfo> authorInfos = authorInfoManager.queryList(authorInfoQuery);

                for(AuthorInfo authorInfo : authorInfos){
                    HashMap<String,Object> m = new HashMap<String,Object>();
                    m.put("article_id",article_id);
                    m.put("oriArticleId",oriArticleId);
                    m.put("title",title);
                    m.put("authorName",authorInfo.getAuthorName());
                    m.put("count",1);
                    showList.add(m);
                }

                SongKanDetail songKanDetail = songKanDetailManager.selectArticle(article_id);
                if(null!=songKanDetail){
                    orderNo =  songKanDetail.getOrderNo() ;
                }
//                StringBuilder strb_aurhor = new StringBuilder();
//                for(AuthorInfo authorInfo : authorInfos){
//                    strb_aurhor.append(","+authorInfo.getAuthorName());
//                }
//                map.put("author",String.valueOf(strb_aurhor).replaceFirst(",",""));
//                map.put("authroCount",authorInfos.size());
//                if(null==songKanDetail){
//                    map.put("nums",0);
//                } else{
//                    map.put("nums",songKanDetail.getZengSonNum());
//                    orderNo =  songKanDetail.getOrderNo() ;
//                }
            }
        }
		mav.addObject("showList", showList);

		mav.addObject("periodicalIssueNo", periodicalIssueNo);
		mav.addObject("periodicalId", periodicalId);
		mav.addObject("qishu", qishu);
		mav.addObject("year", year);
		mav.addObject("orderNo", orderNo);
		return mav;
	}

	
	/**
	 * toArticleGroup
	 * 组稿
	 */
	@RequestMapping(value="/toArticleGroup")
    public @ResponseBody
    Object toArticleGroup(
			@RequestParam("str") String str,
			@RequestParam("periodicalIssueNo") String periodicalIssueNo,
			String leftArray,
			String periodicalId,HttpServletRequest request,String type) {
		logger.info("组稿左右提交进来的:leftArray:["+leftArray+"]"
				+ "&periodicalIssueNo:["+periodicalIssueNo+"]"
						+ "&str["+str+"]&periodicalId:["+periodicalId+"]");
		UserInfo userInfo = getUserInfo(request);
//		ModelAndView mav = new ModelAndView("redirect:../editor/toGroupPage");
        Map<String,Object> mapret = new HashMap<String,Object>();
        try{
            mapret.put("periodicalId", periodicalId);
		/*
		 * 每点击一次提交periodical_details,表中的数据会根据条件删除
		 * periodical_details根据periodicalId&periodicalIssueNo&sectionId先删后插入
		 * */
            PeriodicalDetailsQuery dQuery = new PeriodicalDetailsQuery();
            dQuery.setPeriodicalId(periodicalId);
            dQuery.setPeriodicalIssueNo(periodicalIssueNo);
            dQuery.setType("0000");
            logger.info("删除details表中已存在的数据......"+JSON.toJSONString(dQuery));
            periodicalDetailsManager.deletePeriodicalDetails(dQuery);
            logger.info("删除details表中已存在的数据......");

            JSONArray array = (JSONArray) JSONArray.parse(str);
            for(int i=0;i<array.size();i++){
                System.out.println(array.getJSONObject(i));
                PeriodicalDetails periodicalDetails = new PeriodicalDetails();
                periodicalDetails.setPeriodicalId(periodicalId);
                periodicalDetails.setRefId(array.getJSONObject(i).getString("id"));
                periodicalDetails.setType("0000");//0000是稿件的意思
                periodicalDetails.setCreateTime(new Date());
                periodicalDetails.setPeriodicalIssueNo(periodicalIssueNo);
                periodicalDetails.setUserId(userInfo.getUserId());
                periodicalDetails.setSectionId(array.getJSONObject(i).getString("id"));
                JSONArray jsonArray = array.getJSONObject(i).getJSONArray("data");

                /**
                 * 页面如何将左边里存在的值传入后台,如果左边有值,需要将articleInfo.extend_3的状态变回N
                 * */
                if(!"".equals(leftArray) && leftArray!=null){
                    String[] leftStrs = leftArray.split(",");
                    for(int l=0;l<leftStrs.length;l++){
                        Map map = new HashMap();
                        map.put("articleId", leftStrs[l]);
                        ArticleInfo a = articleInfoManager.qryInfoByArticleId(map);
                        a.setId(a.getId());
                        a.setExtends3("N");
                        articleInfoManager.saveArticleInfo(a);
                    }
                }

                for(int k=0;k<jsonArray.size();k++){
                    periodicalDetails.setArticleId(jsonArray.getString(k));
                    periodicalDetailsManager.savePeriodicalDetails(periodicalDetails);
                    /**
                     * 将已经在栏目下的稿件artcileInfo.extend_3字段变更为Y
                     * 为了让左边不在查出这条数据
                     * */
                    Map map = new HashMap();
                    map.put("articleId", jsonArray.getString(k));
                    ArticleInfo a = articleInfoManager.qryInfoByArticleId(map);
                    a.setId(a.getId());
                    a.setExtends3("Y");
                    articleInfoManager.saveArticleInfo(a);
                }
            }
            PeriodicalQuery query =new PeriodicalQuery();
            query.setPeriodicalId(periodicalId);
            query.setPeriodicalIssueNo(periodicalIssueNo);
            List<Periodical> pList = periodicalManager.queryList(query);
            Periodical p = pList.get(0);
            p.setId(p.getId());
            if("Y".equals(type)){
                p.setPeriodicalState(PeriodicalStateEnums.ARTICLE_PART_OVER.getCode());
            }else{
                p.setPeriodicalState(PeriodicalStateEnums.ARTICLE_PART_DEALING.getCode());
            }
            periodicalManager.savePeriodical(p);
            mapret.put("message","保存成功");
        } catch(Exception e){
            logger.error("组稿异常"+e);
            mapret.put("message",e.getMessage());
        }
		return mapret;
	}

    /**
     *
     * @param periodicalIssueNo   期号
     * @param periodicalId    刊号
     * @param request
     * @return
     */
    @RequestMapping(value="/toArticleToYingWenPage")
    public ModelAndView toArticleToYingWen(@RequestParam("periodicalIssueNo") String periodicalIssueNo,
                                           String periodicalId,HttpServletRequest request,String periodicalYear) {
        ModelAndView mav = new ModelAndView("editor_toYingWenPage");

        /**
         * 查询期刊
         */
        Periodical periodical = new Periodical () ;
        periodical.setPeriodicalId(periodicalId);
        periodical.setPeriodicalIssueNo(periodicalIssueNo);
        PeriodicalInfoQuery periodicalInfoQuery = periodicalManager.selectPeridicalByperiodicalId(periodical) ;

        /**
         * 查询专家
         * */
        ExpertInfoQuery query = new ExpertInfoQuery();
        query.setExtend1(RoleIdEnums.EN_EXPERT.getCode());
        List<ExpertInfo> expertInfos = expertInfoManager.queryList(query);

        mav.addObject("periodicalInfoQuery",periodicalInfoQuery);
        mav.addObject("expertInfos",expertInfos);
        mav.addObject("periodicalYear",periodicalYear);
        return mav ;
    }
    @RequestMapping(value="/toYingWen")
    public @ResponseBody
    Object toYingWen( @RequestParam("periodicalIssueNo")String periodicalIssueNo,@RequestParam("periodicalId")String periodicalId,
                                   @RequestParam("eId")String eId ,HttpServletRequest request) {
        Map<String,Object> map = new HashMap<String , Object>();
        map.put("periodicalId", periodicalId);
        map.put("message", super.success);
        PeriodicalQuery query =new PeriodicalQuery();
        query.setPeriodicalId(periodicalId);
        query.setPeriodicalIssueNo(periodicalIssueNo);
        List<Periodical> pList = periodicalManager.queryList(query);
        Periodical p = pList.get(0);
        p.setId(p.getId());
        p.setExtend1(eId);
        p.setPeriodicalState(PeriodicalStateEnums.SONG_YINGEN.getCode());
        periodicalManager.savePeriodical(p);
        return map ;
    }


    /**
     * toArticleGroupDetailPage
     * 刊文章页列表面
     */
    @RequestMapping(value="/toArticleGroupDPage",method = RequestMethod.GET)
    public ModelAndView toArticleGroupDPage(
            @RequestParam("periodicalId") String periodicalId,
            @RequestParam("periodicalIssueNo") String periodicalIssueNo,
            HttpServletRequest request) {
        logger.info("组稿左右Page:[ "+periodicalId+"]&["+periodicalIssueNo+"]");
        ModelAndView mav = new ModelAndView("editor_toArticleGroupPage");

        SectionInfoQuery query =new SectionInfoQuery();
        query.setPeriodicalId(periodicalId);
        query.setPeriodicalIssueNo(periodicalIssueNo);
        query.setExtend1("N");
        List<SectionInfo> sectionInfos = sectionInfoManager.queryListForGroupAticle(query);
        mav.addObject("sList", sectionInfos);

        mav.addObject("periodicalIssueNo", periodicalIssueNo);
        mav.addObject("periodicalId", periodicalId);
        return mav;
    }
}
