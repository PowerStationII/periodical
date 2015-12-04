/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.BizArticleFeeDao;
import com.cn.periodical.manager.BizArticleFeeManager;
import com.cn.periodical.pojo.BizArticleFee;

@Component("bizArticleFeeManager")
public class BizArticleFeeManagerImpl implements BizArticleFeeManager {
	
	@Autowired
	@Qualifier("bizArticleFeeDao")
	private BizArticleFeeDao bizArticleFeeDao;

	public List<BizArticleFee> editArticleFee(BizArticleFee example) {
		// TODO Auto-generated method stub
		return bizArticleFeeDao.editArticleFee(example);
	}
}

