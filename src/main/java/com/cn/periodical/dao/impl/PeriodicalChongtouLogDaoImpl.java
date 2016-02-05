package com.cn.periodical.dao.impl;

import com.cn.periodical.dao.BaseDao;
import com.cn.periodical.dao.PeriodicalChongtouLogDao;
import com.cn.periodical.dao.Zeng4KanInfoDao;
import com.cn.periodical.pojo.PeriodicalChongtouLog;
import com.cn.periodical.pojo.Zeng4KanInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午10:34
 * To change this template use File | Settings | File Templates.
 */
@Repository("periodicalChongtouLogDao")
public class PeriodicalChongtouLogDaoImpl extends BaseDao implements PeriodicalChongtouLogDao {
    @Override
    public int insert(PeriodicalChongtouLog periodicalChongtouLog) {
        return super.getSqlSession().insert("PeriodicalChongtouLogMapper.insert", periodicalChongtouLog);
    }

    @Override
    public List<PeriodicalChongtouLog> selectByCondition(PeriodicalChongtouLog periodicalChongtouLog) {
        return super.getSqlSession().selectList("PeriodicalChongtouLogMapper.selectByCondition",periodicalChongtouLog );
    }

}
