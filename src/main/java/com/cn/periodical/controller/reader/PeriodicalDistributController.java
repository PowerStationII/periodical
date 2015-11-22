package com.cn.periodical.controller.reader;

import java.io.InputStream;
import java.util.List;

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
import com.cn.periodical.pojo.AddressInfo;
import com.cn.periodical.pojo.BizDistribut;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.utils.ReadExcel;
/**
 * 读者工作区-邮寄地址管理Controller
 * */
@Controller
public class PeriodicalDistributController extends ReaderController{
	
	@Autowired
	AddressInfoManager addressInfoManager;
	
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
		/**
		 * 解析excel地址 保存到address_info&periodical_distribut
		 * */
		
//		InputStream is = file.getInputStream()
//        ReadExcel readExcel = new ReadExcel("","",is);
//        List<AddressInfo> list = readExcel.readXls();
		
		
		
		return mav;
	}
}
