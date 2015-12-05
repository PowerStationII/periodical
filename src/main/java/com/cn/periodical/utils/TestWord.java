package com.cn.periodical.utils;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.rtf.RtfWriter2;

public class TestWord{
	  
	  public void createWord() throws DocumentException, IOException{
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
	   Table aTable = new Table(5);//5----代表表格列数
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
	   Cell cell = new Cell(new Phrase("供应商",font));  
	  Cell cella = new Cell(new Phrase("省",font));  
	  Cell cellb = new Cell(new Phrase("市",font));  
	  Cell cellc = new Cell(new Phrase("重量范围",font));  
	  Cell celld = new Cell(new Phrase("价格范围",font));  
	  
	   cell.setHorizontalAlignment(Element.ALIGN_CENTER);//字体居中
	   cella.setHorizontalAlignment(Element.ALIGN_CENTER);//字体居中
	   cellb.setHorizontalAlignment(Element.ALIGN_CENTER);//字体居中
	   cellc.setHorizontalAlignment(Element.ALIGN_CENTER);//字体居中
	   celld.setHorizontalAlignment(Element.ALIGN_CENTER);//字体居中
	      //cell.setHeader(true);       
	     //cell.setColspan(2);   
	 
	   aTable.addCell(cell, 0, 0);
	   aTable.addCell(cella,0, 1);
	   aTable.addCell(cellb, 0, 2); 
	  aTable.addCell(cellc, 0, 3);
	   aTable.addCell(celld, 0, 4);
	   
	         //表格内容，可从数据库取数据导出
	   for (int i = 1; i < 3; i++) {
	   aTable.addCell(new Cell("顺风"), i, 0);
	   aTable.addCell(new Cell("浙江"),i, 1);
	   aTable.addCell(new Cell("杭州"), i, 2); 
	  aTable.addCell(new Cell("20".toString()), i, 3);
	   aTable.addCell(new Cell("200".toString()), i, 4);
	   }
	   document.add(aTable);
	   document.add(new Paragraph("\n"));
	   
//	   Image img = Image.getInstance("d:\\1.jpg");       
//	  img.setAbsolutePosition(0, 0);       
//	  img.setAlignment(Image.RIGHT);// 设置图片显示位置       
//	  img.scaleAbsolute(460, 460);// 直接设定显示尺寸       
//	  // img.scalePercent(50);//表示显示的大小为原尺寸的50%       
//	  // img.scalePercent(25, 12);//图像高宽的显示比例       
//	  // img.setRotation(30);//图像旋转一定角度       
//	  document.add(img);      
	  document.close();
	  }
	  
	  public static void main(String[] args){
	     TestWord b=new TestWord();
	      try {
	       b.createWord();
	      } catch (DocumentException e) {
	     
	      e.printStackTrace();
	      } catch (IOException e) {
	    
	      e.printStackTrace();
	      }
	   } 
	  
	  
	 }
