package com.cn.periodical.utils;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;

/**
 * 编号
 * */
public class GenerateOrderNo {
	
	private static class GenerateOrderNoInit{
		private static final GenerateOrderNo genOrderNo= new GenerateOrderNo(); 
	}
	
	private GenerateOrderNo(){
		
	}
	
	public static final String generateOrderNo(){
		return GenerateOrderNoInit.genOrderNo.getNum();
	}
	
	private static Map<String, String> map = new HashMap<String, String>();
	private static String STATNUM = "01";

	public String getLastSixNum(String s) {
		String rs = s;
		int i = Integer.parseInt(rs);
		i += 1;
		rs = "" + i;
		for (int j = rs.length(); j < 6; j++) {
			rs = "0" + rs;
		}
		return rs;
	}

	public synchronized String getNum() {
		String yearAMon = new DateTime().toString("yyyyMMddHHmmssSSSS");
		String last6Num = map.get(yearAMon);
		if (last6Num == null) {
			map.put(yearAMon, STATNUM);
		} else {
			map.put(yearAMon, getLastSixNum(last6Num));
		}
		return yearAMon + map.get(yearAMon);
	}
	
	public static void main(String[] args){
		GenerateOrderNo g  = new GenerateOrderNo();
		System.out.println(g.getNum());
	}
	
}
