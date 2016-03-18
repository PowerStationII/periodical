package com.cn.periodical.controller.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.periodical.manager.PeriodicalDistributManager;
import com.cn.periodical.pojo.*;
import com.cn.periodical.service.EditorArticleDealService;
import com.cn.periodical.service.Zeng1KanInfoService;
import com.cn.periodical.service.Zeng4KanInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cn.periodical.manager.AddressInfoManager;
import com.cn.periodical.manager.UserInfoManager;
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
    @Autowired
    PeriodicalDistributManager periodicalDistributManager;
    @Autowired
    EditorArticleDealService editorArticleDealService;
    @Autowired
    Zeng4KanInfoService zeng4KanInfoService;
    @Autowired
    Zeng1KanInfoService zeng1KanInfoService;

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
//		AddressInfoBizPage page= addressInfoManager.queryPageListByBiz(distribut);
		mav.addObject("list", list);
		return mav;
	}

    /**
     * toUploadAddressPage
     * 上传地址
     */
    @RequestMapping(value="/toUploadAddressPage")
    public @ResponseBody Object toUploadAddressPage(@RequestParam(value="files", required=true) MultipartFile files,HttpServletRequest request
            ,String periodicalId,String orderNo) {
        UserInfo userInfo = getUserInfo(request);
        logger.info("上传邮寄地址信息 Page in:["+userInfo.getUserId()+"]");
        Map<String,Object> map = new HashMap<String,Object>();

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
            InputStream is = files.getInputStream();
            ReadExcel readExcel = new ReadExcel("","",userInfo.getRoleId(),userInfos.get(0).getRefId(),is);
            List<AddressInfo> list = readExcel.readXls();
            editorArticleDealService.toUploadAddressPage(orderNo , periodicalId, list);
            map.put("message",super.success);
        }catch(Exception e){
            logger.info("地址上传错误");
            e.printStackTrace();
            map.put("message","请按照模板上传地址");
        }
        return map;
    }

    /**
     * toUploadAddressPage
     * 上传地址
     */
    @RequestMapping(value="/toUploadZeng4KanPage")
    public @ResponseBody Object toUploadZeng4KanPage(@RequestParam(value="files", required=true) MultipartFile files,HttpServletRequest request
            ,String periodicalId,String orderNo,String periodicalIssueNo,String cycleNums) {
        UserInfo userInfo = getUserInfo(request);
        logger.info("上传邮寄地址信息 Page in:["+userInfo.getUserId()+"]");
        Map<String,Object> map = new HashMap<String,Object>();

        /**
         * 根据orderNo 在info 表查询 到 期刊号、刊号、第几期
         */

        /**
         * 解析excel地址 保存到 detail表
         * */
        try{
            InputStream is = files.getInputStream();
            ReadExcel readExcel = new ReadExcel("","",is,orderNo,periodicalId,periodicalIssueNo,cycleNums);
            List<Zeng4KanDetail> list = readExcel.readXlsZeng4Kan();
            // 然后循环保存
            zeng4KanInfoService.insertZeng4KanDetail(list);
        }catch(Exception e){
            logger.info("地址上传错误");
            e.printStackTrace();
        }
        map.put("message",super.success);
        return map;
    }
    /**
     * toUploadAddressPage
     * 上传地址
     */
    @RequestMapping(value="/toUploadZeng1KanPage")
    public @ResponseBody Object toUploadZeng1KanPage(@RequestParam(value="files", required=true) MultipartFile files,HttpServletRequest request
            ,String periodicalId,String orderNo,String periodicalIssueNo,String cycleNums) {
        UserInfo userInfo = getUserInfo(request);
        logger.info("上传邮寄地址信息 Page in:["+userInfo.getUserId()+"]");
        Map<String,Object> map = new HashMap<String,Object>();

        /**
         * 根据orderNo 在info 表查询 到 期刊号、刊号、第几期
         */

        /**
         * 解析excel地址 保存到 detail表
         * */
        try{
            InputStream is = files.getInputStream();
            ReadExcel readExcel = new ReadExcel("","",is,orderNo,periodicalId,periodicalIssueNo,cycleNums);
            List<Zeng1KanDetail> list = readExcel.readXlsZeng1Kan();
            // 然后循环保存
            zeng1KanInfoService.insertZeng1KanDetail(list);
        }catch(Exception e){
            logger.info("地址上传错误");
            e.printStackTrace();
        }
        map.put("message",super.success);
        return map;
    }

	
	
	/**
	 * 删除地址信息
	 */
	@RequestMapping(value = "/toDeleteAddressInfo")
	public ModelAndView toDeleteSectionInfo(String addressId) {
		ModelAndView mav = new ModelAndView("redirect:../reader/toDistributPage");
		logger.info("删除期刊下栏目信息 in:["+addressId+"]");
		try {
			/**
			 * 根据addressId删除AddressInfo信息
			 * */
			AddressInfoQuery query=new AddressInfoQuery();
			query.setAddressId(addressId);
			addressInfoManager.deleteAddressInfo(query);
		} catch (Exception e) {
			//记录错误日志
			logger.error("删除地址信息异常!", e);
			return new ModelAndView("error");
		}
		return mav;
	}
	
	
	/**
	 * toDownloadAddressPage
	 * 下载地址信息模板
	 */
	@RequestMapping(value="/toDownloadAddressPage")
	public ModelAndView toDownloadAddressPage(HttpServletRequest request,HttpServletResponse response) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("下载地址信息模板 Page in:["+userInfo.getUserId()+"]");
		ModelAndView mav = new ModelAndView("redirect:../reader/toDistributPage");
		String fileName="地址信息模板.xls";
		//String path = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"template"+File.separator+fileName;
		String path =  request.getSession().getServletContext().getRealPath("/")+"template"+File.separator+fileName;
		logger.info("开始下载文件:["+fileName+"]");
		logger.info("开始下载文件:["+path+"]");
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		//response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
		try {
			// 弹出下载对话框
			// 为了解决浏览器弹出下载框时框中的中文名称显示问题需要转换编码。
			// 为了解决火狐浏览器中文空格问题需加上\"\"来解决
			response.addHeader("Content-Disposition", "attachment;filename=\""
					+ new String(fileName.getBytes("gbk"), "ISO-8859-1") + "\"");
		} catch (UnsupportedEncodingException e1) {
			System.out.println("文件下载方法中：文件名称编码异常！");
		}
		try {
			File file = new File(path);
			InputStream inputStream = new FileInputStream(file);
			OutputStream os = response.getOutputStream();
			byte[] b = new byte[1024*10];
			int length;
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return mav;
	}

    @RequestMapping(value="/toUploadAddressPageOne")
    public ModelAndView toUploadAddressPageOne(HttpServletRequest request,String receivePostcode ,String receiveAddress ,String contacterName , String extend2,
                                              String contacterTelephone ,String subscribeNums , String orderNo , String periodicalId){
        UserInfo userInfo = getUserInfo(request);
        logger.info("上传邮寄地址信息 Page in:["+userInfo.getUserId()+"]");
        Map<String,Object> map = new HashMap<String,Object>();

        UserInfoQuery query= new UserInfoQuery();
        query.setUserId(userInfo.getUserId());
        query.setRoleId(userInfo.getRoleId());
        /**
         * 如果多余一条或没有报异常
         * */
        List<UserInfo> userInfos = userInfoManager.queryList(query);


        AddressInfo addressInfo =  new AddressInfo ();

        // 邮编
            addressInfo.setReceivePostcode(receivePostcode);
        // 通讯地址
            addressInfo.setReceiveAddress(receiveAddress);
        // 单位名称
            addressInfo.setContacterName(contacterName);
        // 联系人
            addressInfo.setExtend2(extend2);
        // 联系电话
            addressInfo.setContacterTelephone(contacterTelephone);
            addressInfo.setContacterMobile(contacterTelephone);
            addressInfo.setSubscribeNums(Integer.parseInt(subscribeNums));
        addressInfo.setRefRoleId(userInfo.getRoleId());
        addressInfo.setRefId(userInfos.get(0).getRefId());


        editorArticleDealService.toUploadAddressPageOne( addressInfo,  orderNo ,  periodicalId) ;
        ModelAndView mav = new ModelAndView("redirect:../editor/toSubSupplementManagePage");
        mav.addObject("orderNo",orderNo);
        return mav ;
    }

    @RequestMapping(value="/inToUploadAddressPageOne")
    public ModelAndView inToUploadAddressPageOne(String orderNo , String periodicalId){
        ModelAndView mav = new ModelAndView("editor_newAddressPage");
        mav.addObject("orderNo",orderNo);
        mav.addObject("periodicalId",periodicalId);
        return mav ;
    }

}
