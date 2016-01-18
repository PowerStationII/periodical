package com.cn.periodical.controller.editor;

import java.awt.Color;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lowagie.text.rtf.RtfWriter2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.manager.AddressInfoManager;
import com.cn.periodical.manager.BizOrderManager;
import com.cn.periodical.manager.OrderInfoManager;
import com.cn.periodical.pojo.BizDistribut;
import com.cn.periodical.pojo.BizOrder;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.utils.PropertiesInitManager;
import com.cn.periodical.utils.UtilLoad;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;

/**
 * 发行编辑-期刊邮寄Controller
 */
@Controller
public class SubscribePostController extends EditorController {

	private static final Logger logger = LoggerFactory.getLogger(SubscribePostController.class);

	@Autowired
	AddressInfoManager addressInfoManager;

	@Autowired
	OrderInfoManager orderInfoManager;
	@Autowired
	BizOrderManager bizOrderManager;

	/**
	 * toSubscribePostPage 邮寄管理
	 */
	@RequestMapping(value = "/toSubscribePostPage", method = RequestMethod.GET)
	public ModelAndView toSubscribePostPage(HttpServletRequest request) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("发行编辑-邮寄管理Page:[" + userInfo.getUserId() + "]");
		ModelAndView mav = new ModelAndView("editor_subscribePostPage");
		/**
		 * 订单信息
		 */
		List<BizOrder> list = bizOrderManager.queryOrderInfosForSubEditor(null);
		mav.addObject("list", list);
		return mav;
	}

	/**
	 * toReaderAddressInfoDetails 读者订阅地址及信息明细
	 */
	@RequestMapping(value = "/toReaderAddressInfoDetails")
	public ModelAndView toReaderAddressInfoDetails(HttpServletRequest request, String orderNo, String periodicalId,
			String periodicalIssueNo) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("发行编辑-查看读者订阅地址信息Page:[" + userInfo.getUserId() + "]orderNo:[" + orderNo + "]" + "periodicalId:["
				+ periodicalId + "]" + "periodicalIssueNo:[" + periodicalIssueNo + "]");
		ModelAndView mav = new ModelAndView("editor_subscribePostDetailPage");

		BizDistribut distribut = new BizDistribut();
		distribut.setOrderNo(orderNo);
		distribut.setpId(periodicalId);
		distribut.setpIsNo(periodicalIssueNo);
		List<BizDistribut> list = addressInfoManager.exportReaderAddressInfos(distribut);
		mav.addObject("list", list);
		mav.addObject("distribut", distribut);

		return mav;
	}

	/**
	 * toExportReaderAddressInfo 导出读者订阅地址及信息 periodical_distribute表
	 */
	@RequestMapping(value = "/toExportReaderAddressInfo")
	@ResponseBody
	public void toExportReaderAddressInfo(HttpServletRequest request,HttpServletResponse response,
			String orderNo,String periodicalId,String periodicalIssueNo) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("发行编辑-导出读者订阅地址信息Page:[" + userInfo.getUserId() + "]");
		//ModelAndView mav = new ModelAndView("editor_subscribePostPage");
		
		BizDistribut distribut = new BizDistribut();
		distribut.setOrderNo(orderNo);
		distribut.setpId(periodicalId);
		distribut.setpIsNo(periodicalIssueNo);
		List<BizDistribut> list = addressInfoManager.exportReaderAddressInfos(distribut);
		
		try {
//			createWord(list);
            createDocContext("",list);
			UtilLoad.fileDownload(request, response, "邮寄地址信息.doc", PropertiesInitManager.PROPERTIES.getProperty("postAddressPath"));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String checkDate = request.getParameter("checkDate");
//		OutputStream os = null;
//		String fileName = periodicalIssueNo + ".doc";
//		response.setContentType("application/msword");
//		response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
//		InputStream inputStream = this.getWordFile(list);
//		os = response.getOutputStream();
//		byte[] b = new byte[10240];
//		int length;
//		while ((length = inputStream.read(b)) > 0) {
//			os.write(b, 0, length);
//		}
//		os.flush();
//		os.close();
//		inputStream.close();
		
		
		// BizDistribut distribut = new BizDistribut();
		// distribut.setOrderNo(orderNo);
		// List<BizDistribut> list =
		// addressInfoManager.exportReaderAddressInfos(distribut);
		// mav.addObject("list", list);
		// mav.addObject("orderNo", orderNo);

		//return mav;
	}

	/**
	 * toExportAuthorAddressInfo 导出作者订阅地址及信息 author_info&address_info表
	 */
	@RequestMapping(value = "/toExportAuthorAddressInfo")
	public ModelAndView toExportAuthorAddressInfo(HttpServletRequest request) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("发行编辑-导出作者订阅信息Page:[" + userInfo.getUserId() + "]");
		ModelAndView mav = new ModelAndView("editor_subscribePostPage");

		return mav;
	}
	
	
//	public InputStream getWordFile() throws Exception {
//		Document doc = new Document(PageSize.A4);// 创建DOC
//		ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();// 创建新字节输出流
//		RtfWriter2.getInstance(doc, byteArrayOut);// 建立一个书写器与document对象关联，通过书写器可以将文档写入到输出流中
//		doc.open();// 打开文档
//		RtfFont titleFont = new RtfFont("宋体", 14, Font.NORMAL, Color.BLACK);// 标题字体
//		RtfFont contextFont = new RtfFont("宋体", 12, Font.NORMAL, Color.BLACK);// 内容字体
//		Table table = new Table(3, 11);
//		// 设定没列宽度
//		int[] widths = { 20, 20, 20 };
//		table.setWidths(widths);
//		table.setWidth(100);// 设置表格所在word宽度
//		table.setAlignment(Element.ALIGN_CENTER);// 设置表格字体居中
//		table.setAutoFillEmptyCells(true);// 设置表格自动填满
//		String titleString = "机房维护值班检查表（上班）";
//		Paragraph title = new Paragraph(titleString, titleFont);
//		title.setAlignment(Element.ALIGN_CENTER);
//		doc.add(title);
//		// 设置表头
//		Cell[] cellHeaders = new Cell[11];
//		cellHeaders[0] = new Cell(new Phrase("检查区域", contextFont));
//		cellHeaders[1] = new Cell(new Phrase("具体检查内容", contextFont));
//		cellHeaders[2] = new Cell(new Phrase("状态确认", contextFont));
//		for (int i = 0; i < 3; i++) {
//			cellHeaders[i].setHorizontalAlignment(Element.ALIGN_CENTER);
//			cellHeaders[i].setVerticalAlignment(Element.ALIGN_MIDDLE);
//			table.addCell(cellHeaders[i]);
//		}
//
//		doc.add(table);
//		doc.close();
//
//		ByteArrayInputStream byteArray = new ByteArrayInputStream(byteArrayOut.toByteArray());
//		byteArrayOut.close();
//		return byteArray;
//	}
	public void createWord(List<BizDistribut> list) throws DocumentException, IOException{
		   String excelPath = PropertiesInitManager.PROPERTIES.getProperty("postAddressPath") + "邮寄地址信息.doc"; //word路径设置
		   Document document =new Document(PageSize.A4);//设置导出大小
		   RtfWriter2.getInstance(document, new FileOutputStream(excelPath));
		   document.open();
		   logger.info(JSON.toJSONString(list));
		   //表格内容，可从数据库取数据导出
		   for (int i = 0; i < list.size(); i++) {
               document.add(new Paragraph("邮编"+list.get(i).getrPostCode()));//邮编
			   document.add(new Paragraph("地址"+list.get(i).getrAddress()));// 地址
			   document.add(new Paragraph("单位"+list.get(i).getcName()));   // 单位
			   document.add(new Paragraph("联系人"+list.get(i).getcName()));   // 联系人
			   document.add(new Paragraph("电话"+list.get(i).getcMobile())); // 电话
			   document.add(new Paragraph("科")); // 期刊名称
			   document.add(new Paragraph(list.get(i).getdNums())); // 份数
			   document.add(new Paragraph("第"+list.get(i).getdNums()+"期")); // 第几期
			   document.add(new Paragraph("北京朝阳区麦子店街22号")); // 邮寄地址
			   document.add(new Paragraph("农业部农药检定所信息处")); // 邮寄单位
			   document.add(new Paragraph("邮政编码：100125")); // 邮寄邮编

			   document.add(new Paragraph("\n"));
		   }
		  document.close();
    }
    public static void createDocContext(String file,List<BizDistribut> list)throws DocumentException, IOException{
        file = PropertiesInitManager.PROPERTIES.getProperty("postAddressPath") + "邮寄地址信息.doc"; //word路径设置
        //设置纸张大小
        Document document = new Document(PageSize.A4);
        //建立一个书写器，与document对象关联
        RtfWriter2.getInstance(document, new FileOutputStream(file));
        document.open();
        //设置中文字体
//        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        //标题字体风格
//        Font titleFont = new Font(bfChinese,12,Font.BOLD);
//        //正文字体风格
//        Font contextFont = new Font(bfChinese,10,Font.NORMAL);
//        Paragraph title = new Paragraph("标题");
        //设置标题格式对齐方式
//        document.add(title);
        Paragraph context = new Paragraph();
        context.setAlignment(Element.ALIGN_LEFT);
//        context.setFont(contextFont);
        //段间距
        context.setSpacingBefore(1);
        //设置第一行空的列数
        context.setFirstLineIndent(20);
        document.add(context);


        for(int i = 0  ; i<list.size() ; i=i+2){

            //设置Table表格,创建一个三列的表格
            Table table = new Table(3);
            int width[] = {50,1,50};//设置每列宽度比例
            table.setWidths(width);
            table.setWidth(100);//占页面宽度比例
            table.setAlignment(Element.ALIGN_CENTER);//居中
            table.setAlignment(Element.ALIGN_MIDDLE);//垂直居中
            table.setAutoFillEmptyCells(true);//自动填满
            table.setBorderWidth(1);//边框宽度
            /**
             *
             */
            if(list.size()>i){
                BizDistribut bizDistribut = list.get(i);
                //设置表头
                StringBuffer strb = new StringBuffer();
                strb.append(bizDistribut.getrPostCode()); // 邮编
                strb.append("                                   印刷品");
                strb.append("\r\n");
                strb.append(bizDistribut.getrAddress()); // 地址
                strb.append("\r\n");
                strb.append(bizDistribut.getcName()); // 单位
                strb.append("\r\n");
                strb.append(bizDistribut.getcName());// 联系人
                strb.append("        "+bizDistribut.getcMobile());
                strb.append("\r\n");
                strb.append("\r\n");
                strb.append("   科               北京朝阳区麦子店街22号");
                strb.append("\r\n");
                strb.append("   ");
                strb.append(bizDistribut.getdNums()); // 份数
                strb.append("                农业部农药检定所信息处");
                strb.append("\r\n");
                strb.append("     ");
                strb.append("     第 "+bizDistribut.getNums()+" 期");// 第几期
                strb.append("        邮政编码：100125");
                Paragraph paragraph = new Paragraph(String.valueOf(strb));
                Cell cell1 = new Cell(paragraph);
                cell1.setVerticalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell1);
                table.addCell(new Cell(""));
            }
            /**
             *
             */
            if(list.size()>i+1){
                BizDistribut bizDistribut2 = list.get(i+1);
                //设置表头
                StringBuffer strb2 = new StringBuffer();
                strb2.append(bizDistribut2.getrPostCode()); // 邮编
                strb2.append("                                   印刷品");
                strb2.append("\r\n");
                strb2.append(bizDistribut2.getrAddress()); // 地址
                strb2.append("\r\n");
                strb2.append(bizDistribut2.getcName()); // 单位
                strb2.append("\r\n");
                strb2.append(bizDistribut2.getcName());// 联系人
                strb2.append("        "+bizDistribut2.getcMobile());
                strb2.append("\r\n");
                strb2.append("\r\n");
                strb2.append("   科               北京朝阳区麦子店街22号");
                strb2.append("\r\n");
                strb2.append("   ");
                strb2.append(bizDistribut2.getdNums()); // 份数
                strb2.append("                农业部农药检定所信息处");
                strb2.append("\r\n");
                strb2.append("     ");
                strb2.append("     第 "+bizDistribut2.getNums()+" 期");// 第几期
                strb2.append("        邮政编码：100125");
                Paragraph paragraph2 = new Paragraph(String.valueOf(strb2));
                Cell cell2 = new Cell(paragraph2);
                cell2.setVerticalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell2);
            }
            if(list.size()>i){
                document.add(table);
            }
        }



        document.close();

    }
//    public static void createDocContext(String file,String contextString)throws DocumentException, IOException{
//        //设置纸张大小
//        Document document = new Document(PageSize.A4);
//        //建立一个书写器，与document对象关联
//        RtfWriter2.getInstance(document, new FileOutputStream(file));
//        document.open();
//        //设置中文字体
////        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//        //标题字体风格
////        Font titleFont = new Font(bfChinese,12,Font.BOLD);
////        //正文字体风格
////        Font contextFont = new Font(bfChinese,10,Font.NORMAL);
////        Paragraph title = new Paragraph("标题");
//        //设置标题格式对齐方式
////        document.add(title);
//        Paragraph context = new Paragraph();
//        context.setAlignment(Element.ALIGN_LEFT);
////        context.setFont(contextFont);
//        //段间距
//        context.setSpacingBefore(1);
//        //设置第一行空的列数
//        context.setFirstLineIndent(20);
//        document.add(context);
//
//
//        for(int i = 0  ; i<100 ; i++){
//            //设置Table表格,创建一个三列的表格
//            Table table = new Table(3);
//            int width[] = {50,1,50};//设置每列宽度比例
//            table.setWidths(width);
//            table.setWidth(100);//占页面宽度比例
//            table.setAlignment(Element.ALIGN_CENTER);//居中
//            table.setAlignment(Element.ALIGN_MIDDLE);//垂直居中
//            table.setAutoFillEmptyCells(true);//自动填满
//            table.setBorderWidth(1);//边框宽度
//            //设置表头
//            StringBuffer strb = new StringBuffer();
//            strb.append("010010");
//            strb.append("                                   印刷品");
//            strb.append("\r\n");
//            strb.append("黑龙江省牡丹江市");
//            strb.append("\r\n");
//            strb.append("市政府  ");
//            strb.append("\r\n");
//            strb.append("于国栋");
//            strb.append("        13488855723");
//            strb.append("\r\n");
//            strb.append("\r\n");
//            strb.append("   科               北京朝阳区麦子店街22号");
//            strb.append("\r\n");
//            strb.append("   5                农业部农药检定所信息处");
//            strb.append("\r\n");
//            strb.append("     第 1 期        邮政编码：100125");
//
//            Paragraph paragraph = new Paragraph(String.valueOf(strb));
//            Cell cell1 = new Cell(paragraph);
//            cell1.setVerticalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell1);
//            table.addCell(new Cell(""));
//            table.addCell(cell1);
//            document.add(table);
//        }
//
//
//
//        document.close();
//
//    }
    public static void main(String[] args){
        String file = "d:\\test.doc";
        try {
            SubscribePostController.createDocContext(file,null);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
