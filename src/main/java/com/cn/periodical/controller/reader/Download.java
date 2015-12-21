package com.cn.periodical.controller.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.runtime.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.periodical.utils.UtilLoad;


/**
 * 登录Controller
 */
@Controller 
public class Download extends ReaderController{

	private static final Logger logger = LoggerFactory.getLogger(Download.class);

	/**
	 * 跳转到广告业务写死页面
	 */
	@RequestMapping(value="/download")
	@ResponseBody
	public String FileDownload(HttpServletRequest request,
			HttpServletResponse response)  {
		 String fileName = "订购指南.png";   
		 String filePath = request.getSession().getServletContext().getRealPath("/")+"template"+File.separator;     
		 UtilLoad.fileDownload(request, response, fileName, filePath);
		 return "";
	}
	
	
}
