package com.cn.periodical.controller.editor;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cn.periodical.manager.AddressInfoManager;
import com.cn.periodical.manager.BizOrderManager;
import com.cn.periodical.manager.OrderInfoManager;
import com.cn.periodical.pojo.BizDistribut;
import com.cn.periodical.pojo.BizOrder;
import com.cn.periodical.pojo.UserInfo;
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
import com.lowagie.text.rtf.RtfWriter2;

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

		return mav;
	}

	/**
	 * toExportReaderAddressInfo 导出读者订阅地址及信息 periodical_distribute表
	 */
	@RequestMapping(value = "/toExportReaderAddressInfo")
	public ModelAndView toExportReaderAddressInfo(HttpServletRequest request,HttpServletResponse response,
			String orderNo,String periodicalId,String periodicalIssueNo) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("发行编辑-导出读者订阅地址信息Page:[" + userInfo.getUserId() + "]");
		ModelAndView mav = new ModelAndView("editor_subscribePostPage");
		
		BizDistribut distribut = new BizDistribut();
		distribut.setOrderNo(orderNo);
		distribut.setpId(periodicalId);
		distribut.setpIsNo(periodicalIssueNo);
		List<BizDistribut> list = addressInfoManager.exportReaderAddressInfos(distribut);
		
		try {
			createWord(list);
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

		return mav;
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
		   String excelPath = "e:/word.doc"; //word路径设置
		   Document document =new Document(PageSize.A4);//设置导出大小
		   RtfWriter2.getInstance(document, new FileOutputStream(excelPath));
		   document.open();
		   //页眉样式设置
		   BaseFont bfChinese = BaseFont.createFont("c:\\windows\\fonts\\simsun.ttc,1", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		   Font titleFont = new Font(bfChinese);  
		  Paragraph title = new Paragraph("智慧城市",titleFont); 
		   title.font().setColor(Color.red);
		   title.font().setSize(48);
		   //设置标题格式对齐方式
		   title.setAlignment(Element.ALIGN_CENTER);
		   document.add(title);
		   
		   //内容设置
		    String contextString = "智慧城市，是基于物联网、云计算、人工智能、数据挖掘等技术而形成的，一种新型信息化的城市形态，它被认为是继工业化、电气化和信息化之后的“第四次浪潮。"
		     + " \n"// 换行
		     + "它让城市越来越聪明，数字医疗、智能交通等电影中的情景都有望变成现实。"
		     + "近日，中国有关部门公布了首批90个国家智慧城市试点名单。";
		   Font contextFont = new Font(bfChinese);  
		  Paragraph context = new Paragraph(contextString,contextFont);
		   context.setAlignment(Element.ALIGN_LEFT);
		   
		   //离上一段落（标题）空的行数
		   context.setSpacingBefore(5);
		   // 设置第一行空的列数
		   context.setFirstLineIndent(20);
		   context.font().setColor(Color.black);//字体颜色
		   context.font().setSize(10);  //字体大小
		   document.add(context); 
		  
		   // 设置 Table 表格
		   Table aTable = new Table(7);//5----代表表格列数
		   aTable.setAlignment(Element.ALIGN_CENTER);//居中显示
		   aTable.setAlignment(Element.ALIGN_MIDDLE);//纵向居中显示
		   aTable.setAutoFillEmptyCells(true); //自动填满
		   aTable.setBorderWidth(1); //边框宽度
		   aTable.setBorderColor(new Color(50, 125, 255)); //边框颜色
		   aTable.setPadding(0);//单元格高度
		   aTable.setSpacing(0);//即单元格之间的间距
		   aTable.setBorder(2);//边框
		   
		   //设置表格行头
		   Font font = new Font(bfChinese, 18, Font.NORMAL, Color.red);
		   Cell cell = new Cell(new Phrase("详细地址",font));  
		   Cell cella = new Cell(new Phrase("联系人",font));  
		   Cell cellb = new Cell(new Phrase("联系电话",font));  
		   Cell cellc = new Cell(new Phrase("邮寄本数",font));  
		   Cell celld = new Cell(new Phrase("增刊1",font));  
		   Cell celle = new Cell(new Phrase("增刊2",font)); 
		   Cell cellf = new Cell(new Phrase("增刊3",font)); 
		  
		   cell.setHorizontalAlignment(Element.ALIGN_CENTER);//字体居中
		   cella.setHorizontalAlignment(Element.ALIGN_CENTER);//字体居中
		   cellb.setHorizontalAlignment(Element.ALIGN_CENTER);//字体居中
		   cellc.setHorizontalAlignment(Element.ALIGN_CENTER);//字体居中
		   celld.setHorizontalAlignment(Element.ALIGN_CENTER);//字体居中
		   celle.setHorizontalAlignment(Element.ALIGN_CENTER);//字体居中
		   cellf.setHorizontalAlignment(Element.ALIGN_CENTER);//字体居中
		      //cell.setHeader(true);       
		     //cell.setColspan(2);   
		 
		   aTable.addCell(cell, 0, 0);
		   aTable.addCell(cella,0, 1);
		   aTable.addCell(cellb, 0, 2); 
		   aTable.addCell(cellc, 0, 3);
		   aTable.addCell(celld, 0, 4);
		   aTable.addCell(cellc, 0, 5);
		   aTable.addCell(celld, 0, 6);
		   //表格内容，可从数据库取数据导出
		   for (int i = 0; i < list.size(); i++) {
		   aTable.addCell(new Cell(list.get(i).getrAddress()), i, 0);
		   aTable.addCell(new Cell(list.get(i).getcName()), i, 1);
		   aTable.addCell(new Cell(list.get(i).getcMobile()), i, 2); 
		   aTable.addCell(new Cell(list.get(i).getNums()+""), i, 3);
		   aTable.addCell(new Cell(list.get(i).getsIdNums1()+""), i, 4);
		   aTable.addCell(new Cell(list.get(i).getsIdNums2()+""), i, 5);
		   aTable.addCell(new Cell(list.get(i).getsIdNums3()+""), i, 6);
		   }
		   document.add(aTable);
		   document.add(new Paragraph("\n"));
		        
		  document.close();
		  }
}
