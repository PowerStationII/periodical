package com.cn.periodical.controller;

import com.cn.periodical.utils.UtilLoad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 下载Controller
 */
@Controller
public class DownloadController {

	private static final Logger logger = LoggerFactory.getLogger(DownloadController.class);

	@RequestMapping(value = "/downloadAttachment")
	public void login(String fileName ,String filePath,HttpServletRequest request,HttpServletResponse response) {
		logger.info("开始下载文件:["+fileName+"]");
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);

        UtilLoad.fileDownload(request, response, fileName, filePath.replace(fileName, ""));
	}
}
