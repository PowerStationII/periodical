package com.cn.periodical.dao.impl;

import com.cn.periodical.dao.BaseDao;
import com.cn.periodical.dao.OrderInfoDao;
import com.cn.periodical.pojo.OrderInfo;
import com.cn.periodical.pojo.OrderInfoQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 15-11-15
 * Time: 上午12:19
 * To change this template use File | Settings | File Templates.
 */
@Repository("orderInfoDao")
public class OrderInfoDaoImpl extends BaseDao implements OrderInfoDao {

    @Override
    public List<OrderInfo> selectByYear(OrderInfoQuery orderInfoQuery) {
        return super.getSqlSession().selectList("OrderInfoMapper.selectByYear", orderInfoQuery);
    }
}
