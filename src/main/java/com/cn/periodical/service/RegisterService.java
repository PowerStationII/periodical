package com.cn.periodical.service;

import org.springframework.stereotype.Service;

import com.cn.periodical.request.RegisteRequestDto;

public interface RegisterService {
	/**
	 * 注册
	 * */
	public int addAuthor(RegisteRequestDto registeRequestDto);
	public int addEditor(RegisteRequestDto registeRequestDto);
	public int addExpert(RegisteRequestDto registeRequestDto);
	public int addReader(RegisteRequestDto registeRequestDto);
}
