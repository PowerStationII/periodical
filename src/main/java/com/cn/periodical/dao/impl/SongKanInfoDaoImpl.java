package com.cn.periodical.dao.impl;

import com.cn.periodical.dao.BaseDao;
import com.cn.periodical.dao.SongKanInfoDao;
import com.cn.periodical.pojo.SongKanInfo;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午10:34
 * To change this template use File | Settings | File Templates.
 */
@Repository("songKanInfoDao")
public class SongKanInfoDaoImpl extends BaseDao implements SongKanInfoDao{
    @Override
    public int insert(SongKanInfo songKanInfo) {
        return super.getSqlSession().insert("SongKanInfoMapper.insert", songKanInfo);
    }
}
