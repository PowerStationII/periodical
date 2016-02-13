package com.cn.periodical.controller.editor;

import java.beans.PropertyEditorSupport;
import java.io.File;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cn.periodical.manager.AdInfoManager;
import com.cn.periodical.manager.CouncilInfoManager;
import com.cn.periodical.manager.SectionInfoManager;
import com.cn.periodical.pojo.AdInfo;
import com.cn.periodical.pojo.AdInfoQuery;
import com.cn.periodical.pojo.BizAdPage;
import com.cn.periodical.pojo.BizAdQuery;
import com.cn.periodical.pojo.CouncilInfo;
import com.cn.periodical.pojo.CouncilInfoQuery;
import com.cn.periodical.pojo.SectionInfo;
import com.cn.periodical.pojo.SectionInfoQuery;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.utils.PropertiesInitManager;
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
	@Autowired
	SectionInfoManager sectionInfoManager;
	/**
	 * toAdManagerPage
	 * 广告管理
	 */
	@RequestMapping(value="/toAdManagerPage")
	public ModelAndView toAdManagerPage() {
		ModelAndView mav = new ModelAndView("editor_adManagerPage");
		return mav;
	}
	
	/**
	 * toAdManagerPage
	 * 广告管理分页
	 */
	@RequestMapping(value="/toAdManagerPageSet")
	@ResponseBody
	public JSONObject toAdManagerPageSet(HttpServletRequest request,@ModelAttribute BizAdQuery query,@RequestParam(required = false, value = "page", defaultValue = "1") int page,
			@RequestParam(required = false, value = "rows", defaultValue = "10") int rows) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("广告管理首页Page in:["+JSON.toJSONString(query)+"]");
        // 返回给页面的一个json
		JSONObject json = new JSONObject();
        /**
         * 查询总数
          */
        int count = adInfoManager.queryBizAdCount(query);
		json.put("total", count);
		logger.info("+++++++++"+count);
		
		query.setPageSize((page-1)*rows);//开始
		query.setPageNo(rows);//截止
		
		logger.info("广告管理首页*****Page in:["+JSON.toJSONString(query)+"]");
		BizAdPage bizAdPage = adInfoManager.queryBizAdPageList(query);
		json.put("rows", bizAdPage.getValues());
		
		logger.info("广告管理首页Page out:[]");
		return json;
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
		
		SectionInfoQuery sectionInfoQuery =  new SectionInfoQuery();
		sectionInfoQuery.setExtend1("Y");
		List<SectionInfo> sectionInfos = sectionInfoManager.queryList(sectionInfoQuery);
		mav.addObject("sectionInfos", sectionInfos);
		
		return mav;
	}
	
	/**
	 * 保存广告信息
	 */
	@RequestMapping(value = "/toSaveAdInfo", method = { RequestMethod.POST })
	public ModelAndView saveAdInfo(@RequestParam(value="file", required=true) MultipartFile file,
			@ModelAttribute AdInfo adInfo,String councilId) {
		
		String adId= UUID.randomUUID().toString().replaceAll("-", "");

		ModelAndView mav = new ModelAndView("redirect:../editor/toAdManagerPage");
		logger.info("保存广告信息入参:["+JSON.toJSONString(adInfo)+"councilId:"+councilId+"]");
		
		String fileName="";
		String filePath="";
		String absolutPath="";
		try {
			PropertiesInitManager.dataInit();
	    	String basePath = PropertiesInitManager.PROPERTIES.getProperty("adUpload");
	    	StringBuffer sbPath = new StringBuffer();
	    	sbPath.append(basePath);
	    	sbPath.append(File.separator);
	    	sbPath.append(adId);
	    	sbPath.append(File.separator);
	    	filePath = sbPath.toString();
	    	File headPath = new File(filePath);//获取文件夹路径       
	    	if(!headPath.exists()){
	    	//判断文件夹是否创建，没有创建则创建新文件夹        	
	    		headPath.mkdirs();
	    	}
	    	
	    	fileName = filePath+file.getOriginalFilename();
	    	File uploadFile = new File(fileName); 
	        // 转存文件  
        
			file.transferTo(uploadFile);
			logger.info(uploadFile.getAbsolutePath());
			absolutPath = uploadFile.getAbsolutePath(); 
			
			
			
			adInfo.setAdAttachmentName(file.getOriginalFilename());
			adInfo.setAdAttachmentPath(absolutPath);
			adInfo.setAdId(adId);
			adInfoManager.saveAdInfo(adInfo);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}  
		
		return mav;
	}
	
	/**
	 * 广告单条记录查询
	 * */
	@RequestMapping(value = "/toQrySingleAdInfo")
	public ModelAndView toQrySingleAdInfo(@RequestParam("adId") String adId) {
		ModelAndView mav = new ModelAndView("editor_adManagerEditPage");
		AdInfoQuery query = new AdInfoQuery();
		List<AdInfo> adInfos = adInfoManager.queryList(query);
		mav.addObject("adInfo",adInfos.get(0));
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
