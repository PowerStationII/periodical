package com.cn.periodical.dao.impl;

import com.cn.periodical.dao.BaseDao;
import com.cn.periodical.dao.SongKanInfoDao;
import com.cn.periodical.dao.Zeng4KanInfoDao;
import com.cn.periodical.pojo.SongKanInfo;
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
@Repository("zeng4KanInfoDao")
public class Zeng4KanInfoDaoImpl extends BaseDao implements Zeng4KanInfoDao {
    @Override
    public int insert(Zeng4KanInfo zeng4KanInfo) {
        return super.getSqlSession().insert("Zeng4KanInfoMapper.insert", zeng4KanInfo);
    }

    @Override
    public List<Zeng4KanInfo> selectByCondition(Zeng4KanInfo zeng4KanInfo) {
        return super.getSqlSession().selectList("Zeng4KanInfoMapper.selectByCondition",zeng4KanInfo );
    }

}
