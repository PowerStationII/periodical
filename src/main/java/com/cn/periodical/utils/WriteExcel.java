package com.cn.periodical.utils;

import com.cn.periodical.pojo.BizDistribut;
import com.cn.periodical.pojo.BizOrder;
import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-3-10
 * Time: 下午9:30
 * To change this template use File | Settings | File Templates.
 */
public class WriteExcel {


    public void WriteExcel(List<BizDistribut> list){
        String file = PropertiesInitManager.PROPERTIES.getProperty("postAddressPathExcel") + "订单地址信息.xls"; //word路径设置
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("地址信息");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        HSSFCell cell = row.createCell((short) 0);
        cell.setCellValue("邮编");
        cell.setCellStyle(style);
        cell = row.createCell((short) 1);
        cell.setCellValue("通讯地址");
        cell.setCellStyle(style);
        cell = row.createCell((short) 2);
        cell.setCellValue("单位名称");
        cell.setCellStyle(style);
        cell = row.createCell((short) 3);
        cell.setCellValue("联系人");
        cell.setCellStyle(style);
        cell = row.createCell((short) 4);
        cell.setCellValue("联系电话");
        cell.setCellStyle(style);
        cell = row.createCell((short) 5);
        cell.setCellValue("订阅数量");
        cell.setCellStyle(style);

        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，

        for (int i = 0; i < list.size(); i++)
        {
            row = sheet.createRow(i + 1);
            BizDistribut bizOrder = (BizDistribut) list.get(i);
            // 第四步，创建单元格，并设置值
            row.createCell((short) 0).setCellValue(bizOrder.getrPostCode());
            row.createCell((short) 1).setCellValue(bizOrder.getrAddress());
            row.createCell((short) 2).setCellValue(bizOrder.getcName());
            row.createCell((short) 3).setCellValue(bizOrder.getExtends2());
            row.createCell((short) 4).setCellValue(bizOrder.getcMobile());
            row.createCell((short) 5).setCellValue(bizOrder.getdNums());
        }
        // 第六步，将文件存到指定位置
        try
        {
            FileOutputStream fout = new FileOutputStream(file);
            wb.write(fout);
            fout.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
