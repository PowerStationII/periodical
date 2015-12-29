package com.cn.periodical.controller;

import com.cn.periodical.utils.UtilLoad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: 1
 * Date: 15-12-29
 * Time: 下午10:24
 * To change this template use File | Settings | File Templates.
 * ajax 上传文件
 */
@Controller
public class UploadAndDownloadController {
    private static final Logger logger = LoggerFactory.getLogger(UploadAndDownloadController.class);

    /**
     * 文件上传
     * @param request
     * @param files
     * @param filePath
     * @return
     */
    @RequestMapping(value="/upLoadFile" , method= RequestMethod.POST )
    public @ResponseBody
    Object upLoadFile(HttpServletRequest request, @RequestParam("files") MultipartFile[] files , @RequestParam("filePath")String filePath){
        logger.info("UploadAndDownloadController.uploadImg.filePath="+filePath);
        Map<String, Object> resMap = UtilLoad.fileUpload(files, filePath);
        return resMap;
    }

    /**
     * 文件下载
     * @param request
     * @param response
     * @param fileName
     * @param filePath
     */
    @RequestMapping(value="/downLoadFile")
    public void download (HttpServletRequest request,HttpServletResponse response, String fileName,String filePath) {
        logger.info("UploadAndDownloadController.download.filePath+fileName"+filePath);
        UtilLoad.fileDownload(request, response,fileName,filePath.replace(fileName,""));
    }

}
