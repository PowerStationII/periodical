package com.cn.periodical.dao;

import com.cn.periodical.pojo.OrderInfo;
import com.cn.periodical.pojo.OrderInfoQuery;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 15-11-15
 * Time: 上午12:18
 * To change this template use File | Settings | File Templates.
 */
public interface OrderInfoDao {

    public List<OrderInfo> selectByYear(OrderInfoQuery orderInfoQuery);
}
