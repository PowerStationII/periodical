package com.cn.periodical.controller.editor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.cn.periodical.pojo.ZuoZheGaoJianPage;
import com.cn.periodical.pojo.ZuoZheGaoJianPageChaxun;
import com.cn.periodical.request.ArticleQueryReqDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.pojo.EditorQueryArtilces;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.service.ArticleQueryService;
/**
 * 稿件编辑-稿件查询Controller for editor
 * */
@Controller
public class QueryArticleController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(QueryArticleController.class);
	
	@Autowired
	ArticleQueryService articleQueryService;
//	/**
//	 * toQueryArticlePage
//	 * 编辑稿件查询
//	 */
//	@RequestMapping(value="/toQueryArticlePage")
//	public ModelAndView toQueryArticlePage(HttpServletRequest request ,@ModelAttribute EditorQueryArtilces reqDto) {
//		logger.info("稿件查询Page in :["+JSON.toJSONString(reqDto)+"]");
//		ModelAndView mav = new ModelAndView("editor_queryArticlePage");
//		List<EditorQueryArtilces> list = articleQueryService.editorQueryArticles(reqDto);
//		mav.addObject("list", list);
//		logger.info("稿件查询Page out :["+JSON.toJSONString(list)+"]");
//		return mav;
//	}
	/**
	 * toQueryArticlePage
	 * 编辑稿件查询
	 */
	@RequestMapping(value="/toQueryArticlePage")
	public ModelAndView toQueryArticlePage(HttpServletRequest request ,@ModelAttribute EditorQueryArtilces reqDto) {
		logger.info("稿件查询Page in :["+JSON.toJSONString(reqDto)+"]");
		ModelAndView mav = new ModelAndView("editor_queryArticlePage");
		return mav;
	}
	/**
	 * toQueryArticlePage
	 * 编辑稿件查询
	 */
	@RequestMapping(value="/toQueryArticlePageSet")
    @ResponseBody
    public JSONObject toQueryArticlePageSet(HttpServletRequest request,HttpServletResponse response,
                                            @ModelAttribute EditorQueryArtilces query,
                                            @RequestParam(required = false, value = "page", defaultValue = "1") int page,
                                            @RequestParam(required = false, value = "rows", defaultValue = "10") int rows) {

        // 返回给页面的一个json
        JSONObject json = new JSONObject();
//        query.setUserId(userInfo.getUserId());
        /**
         * 查询总数
         */
        int count = articleQueryService.editorQueryArticlesPageCount(query);
        json.put("total", count);
        logger.info("+++++++++"+count);

        query.setPageSize((page-1)*rows);//开始
        query.setPageNo(rows);//截止

        logger.info("已登记Page出参 in:["+JSON.toJSONString(query)+"]");

        ZuoZheGaoJianPageChaxun zuoZheGaoJianPage = articleQueryService.editorQueryArticlesPage(query,count);
        json.put("rows", zuoZheGaoJianPage.getValues());

        logger.info("已登记Page出参 out:[]");
        return json;
	}
}
