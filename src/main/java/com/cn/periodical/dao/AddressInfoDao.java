/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.AddressInfo;
import com.cn.periodical.pojo.AddressInfoQuery;
import com.cn.periodical.pojo.BizDistribut;

public interface AddressInfoDao {
	int countByExample(AddressInfoQuery example);
	
	int deleteByExample(AddressInfoQuery example);
	
	int deleteByPrimaryKey(Long id);
    public int deleteByOrderNo(String orderNo);

	int insert(AddressInfo record);
	
	int insertSelective(AddressInfo record);
	
	List<AddressInfo> selectByExample(AddressInfoQuery example);
	
	List<AddressInfo> selectPageByExample(AddressInfoQuery example);
	
	AddressInfo selectByPrimaryKey(Long id);

    public AddressInfo selectByArticleIdKey(AddressInfoQuery example);
	
	int updateByPrimaryKeySelective(AddressInfo record);
	
	int updateByPrimaryKey(AddressInfo record);
	
	List<BizDistribut> queryAddressListByUserId(BizDistribut distribut);
	List<BizDistribut> queryAddressListForSubEditor(BizDistribut distribut);
	List<BizDistribut> exportReaderAddressInfos(BizDistribut distribut);
	
	public int countByBiz(BizDistribut example);
}
