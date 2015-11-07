package com.cn.periodical.pojo;

import java.io.Serializable;

public class EditorAreaInfos implements Serializable {

	public EditorAreaInfos() {
		// TODO Auto-generated constructor stub
	}

	private String status;
	private int total;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
