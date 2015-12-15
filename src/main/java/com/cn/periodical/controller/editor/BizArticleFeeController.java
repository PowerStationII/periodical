package com.cn.periodical.controller.editor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.periodical.manager.AccountInfoManager;
import com.cn.periodical.manager.BizArticleFeeManager;
import com.cn.periodical.pojo.AccountInfo;
import com.cn.periodical.pojo.BizArticleFee;
/**
 * 稿件编辑-编辑稿费Controller
 * */
@Controller
public class BizArticleFeeController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(BizArticleFeeController.class);
	@Autowired
	BizArticleFeeManager bizArticleFeeManager;
	@Autowired
	AccountInfoManager accountInfoManager;
	/**
	 * toEditArticleFeePage
	 * 编辑稿费
	 */
	@RequestMapping(value="/toEditArticleFeePage")
	public ModelAndView toEditArticleFeePage(HttpServletRequest request) {
		logger.info("编辑稿费Page:[ ]");
		/**
		 * 期刊id+periodical+periodical_detail+article_info+account_info
		 * */
		ModelAndView mav = new ModelAndView("editor_editArticleFeePage");
		List<BizArticleFee> list = bizArticleFeeManager.editArticleFee(null);
		mav.addObject("list", list);
		return mav;
	}
	
	/**
	 * toSaveArticleFee
	 * 保存稿费信息
	 */
	@RequestMapping(value="/toSaveArticleFee")
	public ModelAndView toSaveArticleFee(HttpServletRequest request,String array) {
		logger.info("保存稿费信息Page:[------ ]"+array+"------periodicalId");
		/**
		 * 期刊id+periodical+periodical_detail+article_info+account_info
		 * */
		ModelAndView mav = new ModelAndView("redirect:../editor/toArticleGroupPage");
		JSONArray arr = (JSONArray) JSONArray.parse(array);
		for(int i=0;i<arr.size();i++){
			AccountInfo accountInfo = new AccountInfo();
			accountInfo.setArticleId(arr.getJSONObject(i).getString("articleId"));
			accountInfo.setAuthorPayeeId(arr.getJSONObject(i).getString("authorPayeeId"));
			accountInfo.setExpertPayeeId(arr.getJSONObject(i).getString("expertPayeeId"));
			accountInfo.setExpertAmount(Long.valueOf(arr.getJSONObject(i).getString("expertAmount")));
			accountInfo.setAuthorAmount(Long.valueOf(arr.getJSONObject(i).getString("authorAmount")));
			accountInfo.setAuthorTaxAmount(Long.valueOf(arr.getJSONObject(i).getString("authorTaxAmount")));
			accountInfo.setExpertTaxAmount(Long.valueOf(arr.getJSONObject(i).getString("expertTaxAmount")));
			accountInfo.setAuthorRealAmount(Long.valueOf(arr.getJSONObject(i).getString("authorRealAmount")));
			accountInfo.setExpertRealAmount(Long.valueOf(arr.getJSONObject(i).getString("expertRealAmount")));
			/**
			 * 如果收稿费的作者或者专家的收款行信息不存在
			 * accountInfo数据会被保存为0 页面需要带一个参数 articleInfo的ID防止重复付稿费
			 * 
			 * ？？？？？？
			 */
			
			accountInfoManager.saveAccountInfo(accountInfo);
		}
		
		
		
		return mav;
	}
}
