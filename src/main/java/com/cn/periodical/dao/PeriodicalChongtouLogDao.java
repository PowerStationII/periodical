package com.cn.periodical.dao;

import com.cn.periodical.pojo.PeriodicalChongtouLog;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午10:33
 * To change this template use File | Settings | File Templates.
 */
public interface PeriodicalChongtouLogDao {
    public int insert(PeriodicalChongtouLog periodicalChongtouLog);

    public List<PeriodicalChongtouLog> selectByCondition(PeriodicalChongtouLog periodicalChongtouLog);
}
