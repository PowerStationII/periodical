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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.periodical.manager.AddressInfoManager;
import com.cn.periodical.manager.BizOrderManager;
import com.cn.periodical.manager.OrderInfoManager;
import com.cn.periodical.pojo.BizDistribut;
import com.cn.periodical.pojo.BizOrder;
import com.cn.periodical.pojo.UserInfo;
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
	@ResponseBody
	public String toExportReaderAddressInfo(HttpServletRequest request,HttpServletResponse response,
			String orderNo,String periodicalId,String periodicalIssueNo) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("发行编辑-导出读者订阅地址信息Page:[" + userInfo.getUserId() + "]");
		BizDistribut distribut = new BizDistribut();
		distribut.setOrderNo(orderNo);
		distribut.setpId(periodicalId);
		distribut.setpIsNo(periodicalIssueNo);
		List<BizDistribut> list = addressInfoManager.exportReaderAddressInfos(distribut);
		
		try {
			createWord(list);
			UtilLoad.fileDownload(request, response, "word.doc", "e:\\");
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

		return "";
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
		   for (int i = 0; i < list.size(); i++) {
			   document.add(new Paragraph("详细地址:"+list.get(i).getrAddress()));
			   document.add(new Paragraph("联系人:"+list.get(i).getcName()));
			   document.add(new Paragraph("联系电话:"+list.get(i).getcMobile()));
			   document.add(new Paragraph("邮寄本数:"+list.get(i).getdNums()));
			   document.add(new Paragraph("增刊1:"+list.get(i).getsIdNums1()));
			   document.add(new Paragraph("增刊2:"+list.get(i).getsIdNums2()));
			   document.add(new Paragraph("增刊3:"+list.get(i).getsIdNums3()+"\n\n\n\n"));
		   }
		  document.close();
		  }
}
