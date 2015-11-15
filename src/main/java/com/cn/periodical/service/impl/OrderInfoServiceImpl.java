package com.cn.periodical.service.impl;

import com.cn.periodical.manager.OrderInfoManager;
import com.cn.periodical.pojo.OrderInfo;
import com.cn.periodical.pojo.OrderInfoQuery;
import com.cn.periodical.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 1
 * Date: 15-11-15
 * Time: 上午12:56
 * To change this template use File | Settings | File Templates.
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    OrderInfoManager orderInfoManager ;

    public List<OrderInfo> selectByYear(OrderInfoQuery orderInfoQuery) {
        return orderInfoManager.selectByYear(orderInfoQuery);
    }
}
