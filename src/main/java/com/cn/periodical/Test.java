package com.cn.periodical;

import com.alibaba.fastjson.JSONArray;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String array="[{\"aId\":\"37921f0db525478d87df2af435a38d45\",\"nums\":\"6\"},{\"aId\":\"69934ee5b4ed41baab2dd3f1ccf60a6c\",\"nums\":\"6\"},{\"aId\":\"765c108df1124c92883421ef293eae3c\",\"nums\":\"66\"},{\"aId\":\"350b7c0e9bce4bb6aa5525af526f770c\",\"nums\":\"6\"},{\"aId\":\"d6a3578292df4e279bc4dfab37d08176\",\"nums\":\"6\"}]";
		JSONArray str = (JSONArray) JSONArray.parse(array);
		System.out.println(str);
	}

}
