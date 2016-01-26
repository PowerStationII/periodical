package com.cn.periodical.utils;

import com.cn.periodical.pojo.AddressInfo;
import com.cn.periodical.pojo.Zeng1KanDetail;
import com.cn.periodical.pojo.Zeng4KanDetail;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 只支持一个sheet Created with IntelliJ IDEA. User: 1 Date: 15-11-15 Time: 下午3:50 To
 * change this template use File | Settings | File Templates.
 */
public class ReadExcel {

	public static void main(String[] args) {

		// try {
		// ReadExcel xlsMain = new ReadExcel("2015.xls","F:\\periodical","","");
		// xlsMain.readXls();
		// } catch (Exception e) {
		// e.printStackTrace(); //To change body of catch statement use File |
		// Settings | File Templates.
		// }
	}

	private String filePath = "";
	private String fileName = "";
	private Integer coloum_no;
	private Integer sheetNo;
	private String refRoleId = "";
	private String refId = "";
	private InputStream is;

    private String orderNo = "";
    private String qikanHao = "";
    private String kanHao = "";
    private String cycleNums = "";

	public ReadExcel(String fileName, String filePath, String refRoleId, String refId, InputStream is) {
		this.fileName = fileName;
		this.filePath = filePath;
		this.refRoleId = refRoleId;
		this.refId = refId;
		this.is = is;
	}
    public ReadExcel(String fileName, String filePath, InputStream is ,String orderNo , String qikanHao ,String kanHao,String cycleNums) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.orderNo = orderNo ;
        this.qikanHao = qikanHao ;
        this.kanHao = kanHao ;
        this.cycleNums =  cycleNums ;
        this.is = is;
    }

	public List<AddressInfo> readXls() throws Exception {
		try {
			// InputStream is = new FileInputStream( this.filePath+
			// File.separator+this.fileName);
			Workbook wb = WorkbookFactory.create(is);
			Sheet sheet =wb.getSheetAt(0);
//			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(this.is);

			List<AddressInfo> list = new ArrayList<AddressInfo>();
//			// 循环工作表Sheet
//			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
//			if (hssfSheet == null) {
//				return null;
//			}
			// 循环行Row,第0行是标题，不解析
			for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
				AddressInfo addressInfo = new AddressInfo();
				Row hssfRow = sheet.getRow(rowNum);
				if (hssfRow == null) {
					continue;
				}

				// 邮编
				Cell hssfCell0 = hssfRow.getCell(0);
				if (hssfCell0 == null || "".equals(hssfCell0)) {
					addressInfo.setReceivePostcode("");
				} else {
					addressInfo.setReceivePostcode(getValue(hssfCell0));
				}
				// 通讯地址
				Cell hssfCell1 = hssfRow.getCell(1);
				if (hssfCell1 == null || "".equals(hssfCell1)) {
					addressInfo.setReceiveAddress("");
				} else {
					addressInfo.setReceiveAddress(getValue(hssfCell1));
				}
				// 单位名称
				Cell hssfCell2 = hssfRow.getCell(2);
				if (hssfCell2 == null || "".equals(hssfCell2)) {
					addressInfo.setContacterName("");
				} else {
					addressInfo.setContacterName(getValue(hssfCell2));
				}
				// 联系人
				Cell hssfCell3 = hssfRow.getCell(3);
				if (hssfCell3 == null || "".equals(hssfCell3)) {
					addressInfo.setExtend2("");
				} else {
					addressInfo.setExtend2(getValue(hssfCell3));
				}
				// 联系电话
				Cell hssfCell4 = hssfRow.getCell(4);
				if (hssfCell4 == null || "".equals(hssfCell4)) {
					addressInfo.setContacterTelephone("");
					addressInfo.setContacterMobile("");
				} else {
					addressInfo.setContacterTelephone(getValue(hssfCell4));
					addressInfo.setContacterMobile(getValue(hssfCell4));
				}
//				// 订阅数量
				Cell hssfCell5 = hssfRow.getCell(5);
				if (hssfCell5 == null || "".equals(hssfCell5)) {
					addressInfo.setSubscribeNums(0);
				} else {
                    String value = getValue(hssfCell5);
					addressInfo.setSubscribeNums(getIntVal(value));
				}
				addressInfo.setRefRoleId(this.refRoleId);
				addressInfo.setRefId(this.refId);
				if ("".equals(addressInfo.getReceivePostcode()) && "".equals(addressInfo.getReceiveAddress())
						&& "".equals(addressInfo.getContacterName()) && "".equals(addressInfo.getContacterName())
						) {
					break;
				}
				list.add(addressInfo);
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();

			throw new Exception(e.getMessage());
		}
	}

    public List<Zeng4KanDetail> readXlsZeng4Kan() throws Exception {
        try {
            Workbook wb = WorkbookFactory.create(is);
            Sheet sheet =wb.getSheetAt(0);

            List<Zeng4KanDetail> list = new ArrayList<Zeng4KanDetail>();
            // 循环行Row,第0行是标题，不解析
            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Zeng4KanDetail zeng4KanDetail = new Zeng4KanDetail();
                Row hssfRow = sheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }
                zeng4KanDetail.setOrderNo(this.orderNo);
                zeng4KanDetail.setPeriodicalId(this.qikanHao);
                zeng4KanDetail.setPeriodicalIssueNo(this.kanHao);
                zeng4KanDetail.setCycleNums(Integer.parseInt(cycleNums));

                // 邮编
                Cell hssfCell0 = hssfRow.getCell(0);
                if (hssfCell0 == null || "".equals(hssfCell0)) {
                    zeng4KanDetail.setYoubian("");
                } else {
                    zeng4KanDetail.setYoubian(getValue(hssfCell0));
                }
                // 通讯地址
                Cell hssfCell1 = hssfRow.getCell(1);
                if (hssfCell1 == null || "".equals(hssfCell1)) {
                    zeng4KanDetail.setDizhi("") ;
                } else {
                    zeng4KanDetail.setDizhi(getValue(hssfCell1));
                }
                // 单位名称
                Cell hssfCell2 = hssfRow.getCell(2);
                if (hssfCell2 == null || "".equals(hssfCell2)) {
                    zeng4KanDetail.setDanwei("");
                } else {
                    zeng4KanDetail.setDanwei(getValue(hssfCell2));
                }
                // 联系人
                Cell hssfCell3 = hssfRow.getCell(3);
                if (hssfCell3 == null || "".equals(hssfCell3)) {
                    zeng4KanDetail.setXingming("");
                } else {
                    zeng4KanDetail.setXingming(getValue(hssfCell3));
                }
                // 联系电话
                Cell hssfCell4 = hssfRow.getCell(4);
                if (hssfCell4 == null || "".equals(hssfCell4)) {
                    zeng4KanDetail.setDianhua("");
                } else {
                    zeng4KanDetail.setDianhua(getValue(hssfCell4));
                }
//				// 订阅数量
                Cell hssfCell5 = hssfRow.getCell(5);
                if (hssfCell5 == null || "".equals(hssfCell5)) {
                    zeng4KanDetail.setZengSonNum(0);
                } else {
                    String value = getValue(hssfCell5);
                    zeng4KanDetail.setZengSonNum(getIntVal(value));
                }
                if ("".equals(zeng4KanDetail.getXingming()) && "".equals(zeng4KanDetail.getDanwei())
                        && "".equals(zeng4KanDetail.getDianhua()) && "".equals(zeng4KanDetail.getDizhi())
                        ) {
                    break;
                }
                list.add(zeng4KanDetail);
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();

            throw new Exception(e.getMessage());
        }
    }
    public List<Zeng1KanDetail> readXlsZeng1Kan() throws Exception {
        try {
            Workbook wb = WorkbookFactory.create(is);
            Sheet sheet =wb.getSheetAt(0);

            List<Zeng1KanDetail> list = new ArrayList<Zeng1KanDetail>();
            // 循环行Row,第0行是标题，不解析
            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Zeng1KanDetail zeng4KanDetail = new Zeng1KanDetail();
                Row hssfRow = sheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }
                zeng4KanDetail.setOrderNo(this.orderNo);
                zeng4KanDetail.setPeriodicalId(this.qikanHao);
                zeng4KanDetail.setPeriodicalIssueNo(this.kanHao);
                zeng4KanDetail.setCycleNums(Integer.parseInt(cycleNums));

                // 邮编
                Cell hssfCell0 = hssfRow.getCell(0);
                if (hssfCell0 == null || "".equals(hssfCell0)) {
                    zeng4KanDetail.setYoubian("");
                } else {
                    zeng4KanDetail.setYoubian(getValue(hssfCell0));
                }
                // 通讯地址
                Cell hssfCell1 = hssfRow.getCell(1);
                if (hssfCell1 == null || "".equals(hssfCell1)) {
                    zeng4KanDetail.setDizhi("") ;
                } else {
                    zeng4KanDetail.setDizhi(getValue(hssfCell1));
                }
                // 单位名称
                Cell hssfCell2 = hssfRow.getCell(2);
                if (hssfCell2 == null || "".equals(hssfCell2)) {
                    zeng4KanDetail.setDanwei("");
                } else {
                    zeng4KanDetail.setDanwei(getValue(hssfCell2));
                }
                // 联系人
                Cell hssfCell3 = hssfRow.getCell(3);
                if (hssfCell3 == null || "".equals(hssfCell3)) {
                    zeng4KanDetail.setXingming("");
                } else {
                    zeng4KanDetail.setXingming(getValue(hssfCell3));
                }
                // 联系电话
                Cell hssfCell4 = hssfRow.getCell(4);
                if (hssfCell4 == null || "".equals(hssfCell4)) {
                    zeng4KanDetail.setDianhua("");
                } else {
                    zeng4KanDetail.setDianhua(getValue(hssfCell4));
                }
//				// 订阅数量
                Cell hssfCell5 = hssfRow.getCell(5);
                if (hssfCell5 == null || "".equals(hssfCell5)) {
                    zeng4KanDetail.setZengSonNum(0);
                } else {
                    String value = getValue(hssfCell5);
                    zeng4KanDetail.setZengSonNum(getIntVal(value));
                }
                if ("".equals(zeng4KanDetail.getXingming()) && "".equals(zeng4KanDetail.getDanwei())
                        && "".equals(zeng4KanDetail.getDianhua()) && "".equals(zeng4KanDetail.getDizhi())
                        ) {
                    break;
                }
                list.add(zeng4KanDetail);
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();

            throw new Exception(e.getMessage());
        }
    }

    private int getIntVal(String val){
        if(val.matches("[0-9]+")){
            return Integer.parseInt(val) ;
        } else{
            return 0 ;
        }

    }
	@SuppressWarnings("static-access")
	private String getValue(Cell hssfCell) {
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			DecimalFormat df = new DecimalFormat("#");
			String value = df.format(hssfCell.getNumericCellValue());
			return value;
		} else {
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getColoum_no() {
		return coloum_no;
	}

	public void setColoum_no(Integer coloum_no) {
		this.coloum_no = coloum_no;
	}
}
