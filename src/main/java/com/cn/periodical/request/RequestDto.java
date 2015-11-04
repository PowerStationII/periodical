package com.cn.periodical.request;

import java.io.Serializable;

/**
 * 请求参数基类
 * @author jiangjj
 */
public abstract class RequestDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String systemId;
	private String roleId;
	public String getSystemId() {
		return systemId;
	}
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
