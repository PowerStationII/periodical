package com.cn.periodical.service;

import org.springframework.stereotype.Service;

import com.cn.periodical.request.RegisteRequestDto;

public interface RegisterService {
	/**
	 * 注册
	 * */
	public int add(RegisteRequestDto registeRequestDto);
}
