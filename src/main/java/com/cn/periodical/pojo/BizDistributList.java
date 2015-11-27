package com.cn.periodical.pojo;

import java.io.Serializable;
import java.util.List;

public class BizDistributList implements Serializable {

	public BizDistributList() {
		// TODO Auto-generated constructor stub
	}
	private List<BizDistribut> list;
	public List<BizDistribut> getList() {
		return list;
	}
	public void setList(List<BizDistribut> list) {
		this.list = list;
	}
}
