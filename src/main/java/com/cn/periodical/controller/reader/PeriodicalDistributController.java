package com.cn.periodical.controller.reader;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cn.periodical.manager.AddressInfoManager;
import com.cn.periodical.manager.UserInfoManager;
import com.cn.periodical.pojo.AddressInfo;
import com.cn.periodical.pojo.BizDistribut;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.pojo.UserInfoQuery;
import com.cn.periodical.utils.ReadExcel;
/**
 * 读者工作区-邮寄地址管理Controller
 * */
@Controller
public class PeriodicalDistributController extends ReaderController{
	
	@Autowired
	AddressInfoManager addressInfoManager;
	@Autowired
	UserInfoManager userInfoManager;
	
	private static final Logger logger = LoggerFactory.getLogger(PeriodicalDistributController.class);
	/**
	 * toDistributPage
	 * 邮寄地址管理
	 */
	@RequestMapping(value="/toDistributPage")
	public ModelAndView toDistributPage(HttpServletRequest request) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("邮寄地址管理 Page in:["+userInfo.getUserId()+"]");
		ModelAndView mav = new ModelAndView("reader_distributAddressInfoPage");
		BizDistribut distribut = new BizDistribut();
		distribut.setUserId(userInfo.getUserId());
		List<BizDistribut> list = addressInfoManager.queryAddressListByUserId(distribut);
		mav.addObject("list", list);
		return mav;
	}
	
	
	/**
	 * toUploadAddressPage
	 * 上传地址
	 */
	@RequestMapping(value="/toUploadAddressPage")
	public ModelAndView toUploadAddressPage(@RequestParam(value="file", required=true) MultipartFile file,HttpServletRequest request) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("上传邮寄地址信息 Page in:["+userInfo.getUserId()+"]");
		ModelAndView mav = new ModelAndView("redirect:../reader/toDistributPage");
		
		UserInfoQuery query= new UserInfoQuery();
		query.setUserId(userInfo.getUserId());
		query.setRoleId(userInfo.getRoleId());
		/**
		 * 如果多余一条或没有报异常
		 * */
		List<UserInfo> userInfos = userInfoManager.queryList(query); 
		
		/**
		 * 解析excel地址 保存到address_info
		 * */
		try{
			InputStream is = file.getInputStream();
	        ReadExcel readExcel = new ReadExcel("","",userInfo.getRoleId(),userInfos.get(0).getRefId(),is);
	        List<AddressInfo> list = readExcel.readXls();
	        for(AddressInfo addressInfo:list){
	        	addressInfo.setExtend2("");//excel名称
	        	addressInfo.setExtend3("");//excel全路径
	        	addressInfo.setAddressId(UUID.randomUUID().toString().replaceAll("-", ""));
	        	addressInfo.setCreateTime(new Date());
	        	addressInfoManager.saveAddressInfo(addressInfo);
	        }
		}catch(Exception e){
			logger.info("地址上传错误");
			e.printStackTrace();
		}
		return mav;
	}
}