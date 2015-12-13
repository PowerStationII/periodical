package com.cn.periodical.controller.editor;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

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

import com.alibaba.fastjson.JSON;
import com.cn.periodical.manager.AdInfoManager;
import com.cn.periodical.manager.CouncilInfoManager;
import com.cn.periodical.pojo.AdInfo;
import com.cn.periodical.pojo.BizAd;
import com.cn.periodical.pojo.CouncilInfo;
import com.cn.periodical.pojo.CouncilInfoQuery;
import com.cn.periodical.pojo.UserInfo;
/**
 * 广告编辑-广告管理Controller
 * */
@Controller
public class AdManageController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(AdManageController.class);
	
	@Autowired
	CouncilInfoManager councilInfoManager;
	@Autowired
	AdInfoManager adInfoManager;
	/**
	 * toAdManagerPage
	 * 广告管理
	 */
	@RequestMapping(value="/toAdManagerPage")
	public ModelAndView toAdManagerPage(HttpServletRequest request,@ModelAttribute BizAd ad) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("广告管理首页Page in:[]");
		ModelAndView mav = new ModelAndView("editor_adManagerPage");
		/**
		 * 广告首页查询
		 * 查询条件:
		 * adName=广告名称;concilName=理事会名称;concilType=理事会类型
		 * registTime=注册时间;adType=广告类型;trialNo=广审号
		 * contractStartTime=合同开始日期;contractEndTime=合同结束日期
		 * 
		 * 查询一个list列表,页面展示用
		 * */
		
		List<BizAd> bizAds = adInfoManager.selectAdsForEditor(ad);
		mav.addObject("list", bizAds);
		logger.info("广告管理首页Page out:[]");
		return mav;
	}
	
	/**
	 * 理事会页面增加广告信息
	 * */
	@RequestMapping(value = "/toAdInfoAdd", method = RequestMethod.GET)
	public ModelAndView toAdInfoAdd(String councilId) {
		ModelAndView mav = new ModelAndView("editor_adManagerDetailPage");
		CouncilInfoQuery query = new CouncilInfoQuery();
		query.setCouncilId(councilId);
		List<CouncilInfo> infos = councilInfoManager.queryList(query);
		mav.addObject("c",infos.get(0));
		return mav;
	}
	
	/**
	 * 保存广告信息
	 */
	@RequestMapping(value = "/toSaveAdInfo", method = { RequestMethod.POST })
	public ModelAndView saveAdInfo(@ModelAttribute AdInfo adInfo) {
		ModelAndView mav = new ModelAndView("redirect:../editor/toAdManagerPage");
		logger.info("保存广告信息入参:["+JSON.toJSONString(adInfo)+"]");
		String adId= UUID.randomUUID().toString().replaceAll("-", "");
		adInfo.setAdId(adId);
		adInfoManager.saveAdInfo(adInfo);
		
		return mav;
	}
	
	/**
	 * 广告单条记录查询
	 * */
	@RequestMapping(value = "/toQrySingleAdInfo")
	public ModelAndView toQrySingleAdInfo(@RequestParam("adId") String adId) {
		ModelAndView mav = new ModelAndView("redirect:../editor/toAdInfoEdit");

		
		return mav;
	}
	
	/**
	 * 广告编辑页面
	 * */
	@RequestMapping(value = "/toAdInfoEdit")
	public ModelAndView toAdInfoEdit() {
		ModelAndView mav = new ModelAndView("editor_adManagerEditPage");

		return mav;
	}
	
	/**
	 * 广告编辑保存Action
	 * */
	@RequestMapping(value = "/toSaveAdInfoEdit")
	public ModelAndView toSaveAdInfoEdit() {
		ModelAndView mav = new ModelAndView("redirect:../editor/toAdManagerPage");

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
