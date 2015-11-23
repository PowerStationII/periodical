package com.cn.periodical.controller.reader;

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
		 String fileName = request.getParameter("fileName");   
		 String filePath = request.getParameter("filePath");     
		 //filePath=filePath.replace('\\', '/'); 
		 response.reset();    
		 response.setContentType("application/x-download");   
		 response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
		 OutputStream os;
		 FileInputStream fis;
		 try {  
			  os = response.getOutputStream(); 
			  fis = new FileInputStream(filePath + fileName);                
			  byte[] buffer = new byte[1024 * 10];            
			  for (int read; (read = fis.read(buffer)) != -1;) {                
				 os.write(buffer, 0, read);            
			  }  
			  os.close();
			  fis.close();
		 } 
		 catch (Exception e){
			  
		 }
		 return "";
	}
	
	
}
