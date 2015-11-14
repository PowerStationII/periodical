package com.cn.periodical.manager.impl;

import com.cn.periodical.dao.OrderInfoDao;
import com.cn.periodical.manager.OrderInfoManager;
import com.cn.periodical.pojo.OrderInfo;
import com.cn.periodical.pojo.OrderInfoQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 1
 * Date: 15-11-15
 * Time: 上午12:57
 * To change this template use File | Settings | File Templates.
 */
@Component("orderInfoManager")
public class OrderInfoManagerImpl implements OrderInfoManager {
    @Autowired
    @Qualifier("orderInfoDao")
    private OrderInfoDao orderInfoDao ;


    @Override
    public List<OrderInfo> selectByYear(OrderInfoQuery orderInfoQuery) {
        return orderInfoDao.selectByYear(orderInfoQuery)  ;
    }
}
