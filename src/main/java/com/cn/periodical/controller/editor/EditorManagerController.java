package com.cn.periodical.controller.editor;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.enums.SystemIdEnums;
import com.cn.periodical.manager.EditorInfoManager;
import com.cn.periodical.manager.UserInfoManager;
import com.cn.periodical.pojo.BizEditor;
import com.cn.periodical.pojo.EditorInfo;
import com.cn.periodical.pojo.EditorInfoQuery;
import com.cn.periodical.pojo.SectionInfo;
import com.cn.periodical.pojo.SectionInfoQuery;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.pojo.UserInfoQuery;

/**
 * 主编-编辑管理
 * */
@Controller
public class EditorManagerController extends EditorController {

	private static final Logger logger = LoggerFactory.getLogger(EditorManagerController.class);
	
	@Autowired
	EditorInfoManager editorInfoManager;
	@Autowired
	UserInfoManager userInfoManager;
	
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
		List<BizEditor> list =editorInfoManager.queryEditors(be);
		mav.addObject("list",list);
		logger.info("编辑人员管理首页Page out:[]" + list.size());
		return mav;
	}
	
	@RequestMapping(value = "/toEditorInfoAdd", method = RequestMethod.GET)
	public ModelAndView toEditorInfoAdd() {
		ModelAndView mav = new ModelAndView("editor_editorInfoDetailPage");

		return mav;
	}
	
	@RequestMapping(value = "/isEditorNameExsit")
	@ResponseBody
	public boolean isEditorNameExsit(HttpServletRequest request,String name) {
		EditorInfoQuery query = new EditorInfoQuery();
		query.setEditorName(name);
		List<EditorInfo> pInfos = editorInfoManager.queryList(query);
		if(pInfos!=null && pInfos.size()>=1){
			return true;
		}
		return false;
	}
	
	@RequestMapping(value = "/isUserNameExsit")
	@ResponseBody
	public boolean isUserNameExsit(HttpServletRequest request,String name) {
		UserInfoQuery query = new UserInfoQuery();
		query.setLogonName(name);
		List<UserInfo> pInfos = userInfoManager.queryList(query);
		if(pInfos!=null && pInfos.size()>=1){
			return true;
		}
		return false;
	}
	
	/**
	 * 保存编辑信息
	 */
	@RequestMapping(value = "/toSaveEditorInfo", method = { RequestMethod.POST })
	public ModelAndView toSaveEditorInfo(@ModelAttribute EditorInfo editorInfo,@RequestParam("roleId") String roleId) {
		ModelAndView mav = new ModelAndView("redirect:../editor/toEditorManagerPage");
		logger.info("新增编辑信息 in:["+JSON.toJSONString(editorInfo)+"]");
		try {
			String userId = UUID.randomUUID().toString().replaceAll("-", "");
			String editorId = UUID.randomUUID().toString().replaceAll("-", "");
			/**
			 * 1,email做用户名,默认密码111111.向userInfo中添加记录
			 * ref_id=editor_info中的editor_id
			 * */
			UserInfo addUserInfo= new UserInfo();
			addUserInfo.setLogonName(editorInfo.getEmail());
			addUserInfo.setLogonPwd("111111");
			addUserInfo.setUserId(userId);
			addUserInfo.setRefId(editorId);
			addUserInfo.setRoleId(roleId);
			addUserInfo.setSystemId(SystemIdEnums.EDIT_SYS.getCode());
			userInfoManager.saveUserInfo(addUserInfo);
			/**
			 * 2,保存editorInfo到Editor_info表
			 * */
			editorInfo.setEditorId(editorId);
			editorInfoManager.saveEditorInfo(editorInfo);
			
		} catch (Exception e) {
			//记录错误日志
			logger.error("新增编辑信息异常!", e);
			return new ModelAndView("error");
		}
		return mav;
	}

}
