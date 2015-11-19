package com.cn.periodical.controller.editor;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.pojo.BizEditor;
import com.cn.periodical.pojo.EditorInfo;
import com.cn.periodical.pojo.UserInfo;

/**
 * 主编-编辑管理
 * */
@Controller
public class EditorManagerController extends EditorController {

	private static final Logger logger = LoggerFactory.getLogger(EditorManagerController.class);
	
	public EditorManagerController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * toEditorManagerPage
	 * 编辑人员管理
	 */
	@RequestMapping(value="/toEditorManagerPage",method = RequestMethod.GET)
	public ModelAndView toEditorManagerPage(HttpServletRequest request,@ModelAttribute BizEditor be) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("编辑人员管理首页Page in:[]");
		ModelAndView mav = new ModelAndView("editor_editorManagerPage");
		/**
		 * 编辑管理首页查询
		 * 查询条件:
		 * editorName=编辑姓名;editorLogonName=账号名;editorType=编辑类型
		 * 
		 * 查询一个list列表,页面展示用
		 * */
		
		
		
		logger.info("编辑人员管理首页Page out:[]");
		return mav;
	}
	
	@RequestMapping(value = "/toEditorInfoAdd", method = RequestMethod.GET)
	public ModelAndView toEditorInfoAdd() {
		ModelAndView mav = new ModelAndView("editor_editorInfoDetailPage");

		return mav;
	}
	
	/**
	 * 保存编辑信息
	 */
	@RequestMapping(value = "/toSaveEditorInfo", method = { RequestMethod.POST })
	public ModelAndView toSaveEditorInfo(@ModelAttribute EditorInfo editorInfo,@RequestParam("roleId") String roleId) {
		ModelAndView mav = new ModelAndView("redirect:../editor/toEditorManagerPage");
		logger.info("新增编辑信息 in:["+JSON.toJSONString(editorInfo)+"]");
		try {
			/**
			 * 1,email做用户名,默认密码111111.向userInfo中添加记录
			 * ref_id=editor_info中的editor_id
			 * */
			
			
			/**
			 * 2,保存editorInfo到Editor_info表
			 * */
			
			
		} catch (Exception e) {
			//记录错误日志
			logger.error("新增编辑信息异常!", e);
			return new ModelAndView("error");
		}
		return mav;
	}

}
