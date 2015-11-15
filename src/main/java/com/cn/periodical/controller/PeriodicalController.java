/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.controller;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cn.periodical.enums.PeriodicalStateEnums;
import com.cn.periodical.manager.PeriodicalInfoManager;
import com.cn.periodical.manager.PeriodicalManager;
import com.cn.periodical.pojo.Periodical;
import com.cn.periodical.pojo.PeriodicalInfo;
import com.cn.periodical.pojo.PeriodicalInfoQuery;
import com.cn.periodical.pojo.PeriodicalPage;
import com.cn.periodical.pojo.PeriodicalQuery;
import com.cn.periodical.utils.GenerateOrderNo;

@Controller
@RequestMapping("/params")
public class PeriodicalController {
	@Autowired
	private PeriodicalManager periodicalManager;
	@Autowired
	PeriodicalInfoManager periodicalInfoManager;
	
	private static final Logger logger = LoggerFactory.getLogger(PeriodicalController.class);
	/**
	 * 列表页面
	 */
	@RequestMapping(value = "/periodicalIndex", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView periodicalIndex(@ModelAttribute PeriodicalQuery query,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) {
		ModelAndView mav = new ModelAndView("params/PeriodicalIndex");
		query.setPageNo(pageNo);
		query.setPageSize(pageSize);
		
		PeriodicalPage result = periodicalManager.queryPageList(query);
		
		mav.addObject("query", query);
		mav.addObject("pagenation",result.getPagenation());
		mav.addObject("pageInfos",result.getValues());
		
		return mav;
	}
	
	/**
	 * 跳转到详情页
	 */
	@RequestMapping(value = "/toPeriodicalDetail", method = RequestMethod.GET)
	public ModelAndView toPeriodicalDetail(@RequestParam(required = true, value = "id") Long id) {
		ModelAndView mav = new ModelAndView("params/PeriodicalDetail");
		Periodical pageInfo = periodicalManager.findPeriodicalById(id);
		mav.addObject("pageInfo", pageInfo);
		
		return mav;
	}
	
	/**
	 * 跳转到添加页面
	 */
	@RequestMapping(value = "/toPeriodicalAdd", method = RequestMethod.GET)
	public String toPeriodicalAdd() {
		return "PeriodicalAdd";
	}
	
	/**
	 * 跳转到编辑页面
	 */
	@RequestMapping(value = "/toPeriodicalEdit", method = RequestMethod.GET)
	public ModelAndView toPeriodicalEdit(@RequestParam(required = true, value = "id") Long id) {
		ModelAndView mav = new ModelAndView("params/PeriodicalEdit");
		Periodical pageInfo = periodicalManager.findPeriodicalById(id);
		mav.addObject("pageInfo", pageInfo);
		
		
		return mav;
	}
	
	/**
	 * 保存数据
	 */
	@RequestMapping(value = "/savePeriodical", method = { RequestMethod.POST })
	public ModelAndView savePeriodical(@ModelAttribute Periodical periodical, RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("redirect:/params/periodicalIndex");
		PeriodicalInfoQuery periodicalInfoQuery = new PeriodicalInfoQuery();

		periodicalInfoQuery.setPeriodicalId(periodical.getPeriodicalId());
		
		List<PeriodicalInfo> periodicalInfos = periodicalInfoManager.queryList(periodicalInfoQuery);
		PeriodicalInfo periodicalInfo = periodicalInfos.get(0);
		
		try {
			for(int i=0;i<periodicalInfo.getCycle();i++){
				periodical.setPeriodicalId(periodical.getPeriodicalId());
				periodical.setPeriodicalIssueNo(GenerateOrderNo.generateOrderNo());
				periodical.setPeriodicalState(PeriodicalStateEnums.NEW_PERIODICAL.getCode());
				periodical.setCycleNums(i+1);
				periodical.setPeriodicalYear(periodical.getPeriodicalYear());
				periodical.setPublishNums(periodical.getPublishNums());
				periodicalManager.savePeriodical(periodical);
			}
			redirectAttributes.addFlashAttribute("message", "保存成功!");
		} catch (Exception e) {
			//记录错误日志
			logger.error("", e);
			
			if(periodical.getId() == null){
				mav.setViewName("params/PeriodicalAdd");
			}else{
				mav.addObject("pageInfo", periodical);
				mav.setViewName("params/PeriodicalEdit");
			}
			
			redirectAttributes.addFlashAttribute("message", "保存失败:" + e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 删除数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/deletePeriodical", method = RequestMethod.GET)
	public ModelAndView deletePeriodical(@RequestParam(required = true, value = "id") Long id, RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("redirect:/params/periodicalIndex");
		
		try {
			periodicalManager.deletePeriodicalById(id);
		} catch (Exception e) {
			//记录错误日志
			logger.error("", e);
			redirectAttributes.addFlashAttribute("message", "发生错误:" + e.getMessage());
		}
		
		return mav;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateEditor());
		binder.registerCustomEditor(String.class, new StringEditor());
		binder.registerCustomEditor(Integer.class, new IntegerEditor());
		binder.registerCustomEditor(Long.class, new LongEditor());
		binder.registerCustomEditor(Float.class, new FloatEditor());
		binder.registerCustomEditor(Double.class, new DoubleEditor());
		binder.registerCustomEditor(BigDecimal.class, new BigDecimalEditor());
	}
	
	class DateEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text != null && !"".equals(text)) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					setValue(dateFormat.parse(text));
				} catch (ParseException e) {
					setValue(null);
				}
			} else {
				setValue(null);
			}
		}
	}
	
	class StringEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text != null && !"".equals(text)) {
				setValue(text);
			} else {
				setValue(null);
			}
		}
	}
	
	class IntegerEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text != null && !"".equals(text)) {
				setValue(Integer.valueOf(text));
			} else {
				setValue(null);
			}
		}
	}
	
	class LongEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text != null && !"".equals(text)) {
				setValue(Long.valueOf(text));
			} else {
				setValue(null);
			}
		}
	}
	
	class FloatEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text != null && !"".equals(text)) {
				setValue(Float.valueOf(text));
			} else {
				setValue(null);
			}
		}
	}
	
	class DoubleEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text != null && !"".equals(text)) {
				setValue(Double.valueOf(text));
			} else {
				setValue(null);
			}
		}
	}
	
	class BigDecimalEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text != null && !"".equals(text)) {
				setValue(BigDecimal.valueOf(Double.valueOf(text)));
			} else {
				setValue(null);
			}
		}
	}
}
