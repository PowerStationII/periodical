/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.BaseDao;
import com.cn.periodical.dao.BizArticleFeeDao;
import com.cn.periodical.pojo.BizArticleFee;

@Repository("bizArticleFeeDao")
public class BizArticleFeeDaoImpl extends BaseDao implements BizArticleFeeDao {

	public List<BizArticleFee> editArticleFee(BizArticleFee example) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("BizArticleFeeMapper.editArticleFee", example);
		//super.getSqlSession().selectList("BizArticleFeeMapper.editArticleFee", example);
	}

	public List<Map<String, String>> editArticleFeeMap(BizArticleFee example) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("BizArticleFeeMapper.editArticleFeeMap", example);
	}
	
}
