/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.AddressInfoDao;
import com.cn.periodical.manager.AddressInfoManager;
import com.cn.periodical.pojo.AddressInfo;
import com.cn.periodical.pojo.AddressInfoPage;
import com.cn.periodical.pojo.AddressInfoQuery;
import com.cn.periodical.pojo.BizDistribut;
import com.cn.periodical.utils.Pagenation;

@Component("addressInfoManager")
public class AddressInfoManagerImpl implements AddressInfoManager {
	
	@Autowired
	@Qualifier("addressInfoDao")
	private AddressInfoDao addressInfoDao;
	
	
	public void saveAddressInfo(AddressInfo addressInfo) {
		if (addressInfo.getId() == null) {
			addressInfoDao.insertSelective(addressInfo);
		} else {
			addressInfoDao.updateByPrimaryKeySelective(addressInfo);
		}
	}
	
	
	public AddressInfo findAddressInfoById(Long id) {
		return addressInfoDao.selectByPrimaryKey(id);
	}
	
	
	public List<AddressInfo> queryList(AddressInfoQuery query) {
		return addressInfoDao.selectByExample(query);
	}
	
	
	public void deleteAddressInfoById(Long id) {
		addressInfoDao.deleteByPrimaryKey(id);
	}
	
	
	public void deleteAddressInfo(AddressInfoQuery query) {
		addressInfoDao.deleteByExample(query);
	}
	
	
	public AddressInfoPage queryPageList(AddressInfoQuery query) {
		AddressInfoPage addressInfoPage = new AddressInfoPage();
		Integer itemCount = addressInfoDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			addressInfoPage.setValues(null);
		} else {
			addressInfoPage.setValues(addressInfoDao.selectPageByExample(query));
		}
		
		addressInfoPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return addressInfoPage;
	}

    public void saveAddressInfos(List<AddressInfo> list){
          for(AddressInfo addressInfo : list){
              addressInfoDao.insertSelective(addressInfo);
          }
    }


	public List<BizDistribut> queryAddressListByUserId(BizDistribut distribut) {
		// TODO Auto-generated method stub
		return addressInfoDao.queryAddressListByUserId(distribut);
	}
}

