package com.cn.periodical.controller.editor;

import com.alibaba.fastjson.JSONObject;
import com.cn.periodical.enums.PeriodicalStateEnums;
import com.cn.periodical.manager.*;
import com.cn.periodical.pojo.*;
import com.cn.periodical.utils.PropertiesInitManager;
import com.cn.periodical.utils.UtilLoad;
import org.codehaus.plexus.archiver.zip.ZipEntry;
import org.codehaus.plexus.archiver.zip.ZipOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * 签发人-签发管理Controller
 * */
@Controller
public class IssueController extends EditorController{
	
	@Autowired
	BizPeriodicalManager bizPeriodicalManager;
	@Autowired
	PeriodicalManager periodicalManager;
    @Autowired
    SectionInfoManager sectionInfoManager;
    @Autowired
    ArticleAttachmentInfoManager articleAttachmentInfoManager;
    @Autowired
    AdInfoManager adInfoManager;

	private static final Logger logger = LoggerFactory.getLogger(IssueController.class);
	/**
	 * toIssueManagerPage
	 * 签发管理
	 */
	@RequestMapping(value="/toIssueManagerPage",method = RequestMethod.GET)
	public ModelAndView toIssueManagerPage(HttpServletRequest request,BizPeriodical reqDto) {
		logger.info("签发管理Page:[  ]");
		UserInfo userInfo = getUserInfo(request);
		ModelAndView mav = new ModelAndView("editor_issueManagerPage");
		/**
		 * 查询广告+稿件全部完成的期刊
		 * */
		List<BizPeriodical> list = bizPeriodicalManager.queryPeriodicalInfosForIssueEditor(reqDto);
		mav.addObject("list", list);
		return mav;
	}
	/**
	 * toIssueManagerPage
	 * 签发管理
	 */
	@RequestMapping(value="/toIssueManagerPageSet",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject toIssueManagerPageSet(HttpServletRequest request,
                                            @ModelAttribute BizPeriodicalQuery query,
                                            @RequestParam(required = false, value = "page", defaultValue = "1") int page,
                                            @RequestParam(required = false, value = "rows", defaultValue = "10") int rows) {
		logger.info("签发管理Page:[  ]");
		/**
		 * 查询广告+稿件全部完成的期刊
		 * */
 		int count = bizPeriodicalManager.queryPeriodicalInfosForIssueEditorPageCount(query);

        UserInfo userInfo = getUserInfo(request);
        JSONObject json = new JSONObject();
        json.put("total", count);

        query.setPageSize((page-1)*rows);//开始
        query.setPageNo(rows);//截止

        BizPeriodicalPage bizAdPage = bizPeriodicalManager.queryPeriodicalInfosForIssueEditorPage(query,count);
        json.put("rows", bizAdPage.getValues());

        return json;
	}

    @RequestMapping(value="/toIssue")
    public @ResponseBody Object toIssue(HttpServletRequest request,String periodicalId  ,String periodicalIsNo) {
        logger.info("签发Page:[  ]");
        UserInfo userInfo = getUserInfo(request);
        Map<String,Object> map = new HashMap<String ,Object>();
        PeriodicalQuery query= new PeriodicalQuery();
        query.setPeriodicalId(periodicalId);
        query.setPeriodicalIssueNo(periodicalIsNo);
        List<Periodical> list = periodicalManager.queryList(query);
        Periodical p = list.get(0);
        if(PeriodicalStateEnums.FINISH_ISSUE.getCode().equals(p.getPeriodicalState()) || PeriodicalStateEnums.FINISH_ISSUE.getCode().equals(p.getExtend2())){
            map.put("message","期刊已经签发过，不可重复签发");
            return map ;
        }
        if(!PeriodicalStateEnums.PRE_ISSUE.getCode().equals(p.getPeriodicalState())){
            map.put("message","期刊文章未送到签发");
            return map ;
        }
        if(!PeriodicalStateEnums.PRE_ISSUE.getCode().equals(p.getExtend2())){
            map.put("message","期刊广告未送到签发");
            return map ;
        }
        p.setId(p.getId());
        p.setIssueOpinion("同意");
        p.setPeriodicalState(PeriodicalStateEnums.FINISH_ISSUE.getCode());
        p.setIssueTime(new Date());
        periodicalManager.savePeriodical(p);
        map.put("message",super.success);
        return map;
    }
    @RequestMapping(value="/downloadAllPeriodical")
    public @ResponseBody Object downloadAllPeriodical(HttpServletRequest request,HttpServletResponse response,
                                      String periodicalId  ,String periodicalIsNo){

        Map<String,Object> map = new HashMap<String ,Object>();
        try{
            /**
             * 1、根据期刊号、期号查询出该期下的所有的文章
             * 2、找到这些文章的附件为英文专家审核后的附件
             * 3、把该期的文章列表导出来，并区分是哪个栏目下
             * 3、打成zip包，下载
             */

            SectionInfoQuery query =new SectionInfoQuery();
            query.setPeriodicalId(periodicalId);
            query.setPeriodicalIssueNo(periodicalIsNo);
            query.setExtend1("N");
            StringBuffer articleTitleInfo = new StringBuffer();
            List<String> articleId_list = new ArrayList<String>();
            // 查询出一期
            List<SectionInfo> sectionInfos = sectionInfoManager.queryListForGroupAticle(query);
            // 循环一期所有的栏目
            for(SectionInfo sectionInfo : sectionInfos){
                articleTitleInfo.append("\r\n\n栏目名称："+sectionInfo.getSectionName());
                // 一个栏目下所有的文章
                List<Map<String, Object>> articleList = sectionInfo.getList();
                for(Map<String, Object> article : articleList){
                    articleTitleInfo.append("\r\n      "+article.get("article_cn_title"));
                    articleId_list.add(String.valueOf(article.get("article_id")));
                }
            }

            // 查出所有附件地址
            List<ArticleAttachmentInfo> articleAttr_list = articleAttachmentInfoManager.queryAttByArtcicleIds(articleId_list);
            String m = this.zipFile( request, response,"稿件.zip",articleAttr_list,String.valueOf(articleTitleInfo));
            if(null==m){
                map.put("message","导出成功");
            }else{
                map.put("message","导出失败");
            }
        }catch (Exception e){
            map.put("message",e.getMessage());
            logger.info("签发导出zip稿件"+e);
        }
        return map ;
    }

    /**
     * 把文件压缩并下载压缩文件
     * @param zipFileName
     * @param articleAttr_list
     * @return
     */
    private String zipFile(HttpServletRequest request,HttpServletResponse response,
                           String zipFileName,List<ArticleAttachmentInfo> articleAttr_list,String articleList) {
        PropertiesInitManager.dataInit();
        String FilePath = String.valueOf(PropertiesInitManager.PROPERTIES.get("gaojianZIP"))+File.separator;
        /**
         * 保存稿件列表
         */
        String fileListName = FilePath+"期刊稿件列表.txt" ;
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileListName)));

            writer.write(articleList);

            writer.close();

        }catch(Exception e){

        }

        byte[] buffer = new byte[1024];
        String strZipPath = FilePath + zipFileName;
        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
                    strZipPath));

            File[] file1s = new File[articleAttr_list.size()+1] ;

            for(int i = 0 ; i< articleAttr_list.size() ; i++){
                ArticleAttachmentInfo articleAttachmentInfo =   articleAttr_list.get(i);
                file1s[i] = new File(articleAttachmentInfo.getAttachmentPath());
            }
            file1s[articleAttr_list.size()] = new File(fileListName);
            for (int i = 0; i < file1s.length; i++) {
                FileInputStream fis = new FileInputStream(file1s[i]);
                out.putNextEntry(new ZipEntry(file1s[i].getName()));
                //设置压缩文件内的字符编码，不然会变成乱码
                out.setEncoding("GBK");
                int len;
                // 读入需要下载的文件的内容，打包到zip文件
                while ((len = fis.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
                out.closeEntry();
                fis.close();
            }
            out.close();

            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName=" + zipFileName);

            UtilLoad.fileDownload(request, response, zipFileName, FilePath);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return null;
    }

    @RequestMapping(value="/downloadAllGuanGao")
    public @ResponseBody Object downloadAllGuanGao(HttpServletRequest request,HttpServletResponse response,
                                                      String periodicalId  ,String periodicalIsNo) {
        Map<String,Object> map = new HashMap<String ,Object>();
        try{
            /**
             * 1、根据期刊号、期号查询出该期下的所有的文章
             * 2、找到这些文章的附件为英文专家审核后的附件
             * 3、把该期的文章列表导出来，并区分是哪个栏目下
             * 3、打成zip包，下载
             */

            SectionInfoQuery query =new SectionInfoQuery();
            query.setPeriodicalId(periodicalId);
            query.setPeriodicalIssueNo(periodicalIsNo);
            query.setExtend1("Y");

            StringBuffer articleTitleInfo = new StringBuffer();
            List<String> articleId_list = new ArrayList<String>();
            // 查询出一期
            List<SectionInfo> sectionInfos = sectionInfoManager.selectByExampleForAd(query);
            // 循环一期所有的栏目
            for(SectionInfo sectionInfo : sectionInfos){
                articleTitleInfo.append("\r\n\n栏目名称："+sectionInfo.getSectionName());
                // 一个栏目下所有的文章
                List<Map<String, Object>> articleList = sectionInfo.getListAd();
                for(Map<String, Object> article : articleList){
                    articleTitleInfo.append("\r\n      "+article.get("ad_name"));
                    articleId_list.add(String.valueOf(article.get("ad_id")));
                }
            }

            // 查出所有附件地址
            List<AdInfo> articleAttr_list = adInfoManager.selectByadids(articleId_list);
            String m = this.zipFileGG(request, response, "广告.zip", articleAttr_list, String.valueOf(articleTitleInfo));
            if(null==m){
                map.put("message","导出成功");
            }else{
                map.put("message","导出失败");
            }
        }catch (Exception e){
            map.put("message",e.getMessage());
            logger.info("签发导出zip稿件"+e);
        }
        return map ;

    }

    /**
     * 把文件压缩并下载压缩文件
     * @param zipFileName
     * @param articleAttr_list
     * @return
     */
    private String zipFileGG(HttpServletRequest request,HttpServletResponse response,
                           String zipFileName,List<AdInfo> articleAttr_list,String articleList) {
        PropertiesInitManager.dataInit();
        String FilePath = String.valueOf(PropertiesInitManager.PROPERTIES.get("gaojianZIP"))+ File.separator;
        String fileListName = FilePath+"期刊广告列表.txt" ;
        /**
         * 保存稿件列表
         */
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileListName)));

            writer.write(articleList);

            writer.close();

        }catch(Exception e){

        }

        byte[] buffer = new byte[1024];
        String strZipPath = FilePath + zipFileName;
        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
                    strZipPath));

            File[] file1s = new File[articleAttr_list.size()+1] ;

            for(int i = 0 ; i< articleAttr_list.size() ; i++){
                AdInfo articleAttachmentInfo =   articleAttr_list.get(i);
                file1s[i] = new File(articleAttachmentInfo.getAdAttachmentPath());
            }
            file1s[articleAttr_list.size()] =  new File(fileListName);
            for (int i = 0; i < file1s.length; i++) {
                FileInputStream fis = new FileInputStream(file1s[i]);
                out.putNextEntry(new ZipEntry(file1s[i].getName()));
                //设置压缩文件内的字符编码，不然会变成乱码
                out.setEncoding("GBK");
                int len;
                // 读入需要下载的文件的内容，打包到zip文件
                while ((len = fis.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
                out.closeEntry();
                fis.close();
            }
            out.close();

            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName=" + zipFileName);

            UtilLoad.fileDownload(request, response, zipFileName, FilePath);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return null;
    }

}
