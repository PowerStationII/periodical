package com.cn.periodical.result;

import com.cn.periodical.utils.Pagenation;

/**
 * 返回集合值分页结果
 * @param <T>
 */
public class PageListResult<T> extends ListResult<T>{

	private static final long serialVersionUID = 1L;
	
	public static <E> PageListResult<E> newPageListResult() {
		return new PageListResult<E>();
	}
	
	/**
	 * @return 辅助分页查询结果
	 */
	private Pagenation pagenation;

	public Pagenation getPagenation() {
		return pagenation;
	}

	public PageListResult<T> setPagenation(Pagenation pagenation) {
		this.pagenation = pagenation;
		return this;
	}
}
