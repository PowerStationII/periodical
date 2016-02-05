package com.cn.periodical.manager.impl;

import com.cn.periodical.dao.PeriodicalChongtouLogDao;
import com.cn.periodical.manager.PeriodicalChongtouLogManager;
import com.cn.periodical.pojo.PeriodicalChongtouLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午10:26
 * To change this template use File | Settings | File Templates.
 */
@Component("periodicalChongtouLog")
public class PeriodicalChongtouLogManagerImpl implements PeriodicalChongtouLogManager {

    @Autowired
    PeriodicalChongtouLogDao periodicalChongtouLogDao ;
    @Override
    public int insert(PeriodicalChongtouLog periodicalChongtouLog) {
        return periodicalChongtouLogDao.insert(periodicalChongtouLog);
    }

    @Override
    public List<PeriodicalChongtouLog> selectByCondition(PeriodicalChongtouLog periodicalChongtouLog) {
        return periodicalChongtouLogDao.selectByCondition(periodicalChongtouLog);
    }

}
