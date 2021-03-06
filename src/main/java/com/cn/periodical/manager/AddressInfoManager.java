/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.AddressInfo;
import com.cn.periodical.pojo.AddressInfoBizPage;
import com.cn.periodical.pojo.AddressInfoPage;
import com.cn.periodical.pojo.AddressInfoQuery;
import com.cn.periodical.pojo.BizDistribut;

public interface AddressInfoManager {
	void saveAddressInfo(AddressInfo addressInfo);

	AddressInfo findAddressInfoById(Long id);

    public AddressInfo selectByArticleIdKey(AddressInfoQuery example);
	
	List<AddressInfo> queryList(AddressInfoQuery query);
	
	void deleteAddressInfoById(Long id);
    public void deleteByOrderNo(String orderNo);

	void deleteAddressInfo(AddressInfoQuery query);
	
	AddressInfoPage queryPageList(AddressInfoQuery query);

    public void saveAddressInfos(List<AddressInfo> list);

	List<BizDistribut> queryAddressListByUserId(BizDistribut distribut);
	List<BizDistribut> queryAddressListForSubEditor(BizDistribut distribut);

	public List<BizDistribut> exportReaderAddressInfos(BizDistribut distribut);
	
	public AddressInfoBizPage queryPageListByBiz(BizDistribut query);
}
