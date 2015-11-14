package com.cn.periodical.service;

import com.cn.periodical.pojo.OrderInfo;
import com.cn.periodical.pojo.OrderInfoQuery;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 1
 * Date: 15-11-15
 * Time: 上午12:54
 * To change this template use File | Settings | File Templates.
 */
public interface OrderInfoService {
    public List<OrderInfo> selectByYear(OrderInfoQuery orderInfoQuery);
}
