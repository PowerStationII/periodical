package com.cn.periodical.dao.impl;

import com.cn.periodical.dao.BaseDao;
import com.cn.periodical.dao.Zeng1KanInfoDao;
import com.cn.periodical.dao.Zeng4KanInfoDao;
import com.cn.periodical.pojo.Zeng1KanInfo;
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
@Repository("zeng1KanInfoDao")
public class Zeng1KanInfoDaoImpl extends BaseDao implements Zeng1KanInfoDao {
    @Override
    public int insert(Zeng1KanInfo zeng1KanInfo) {
        return super.getSqlSession().insert("Zeng1KanInfoMapper.insert", zeng1KanInfo);
    }

    @Override
    public List<Zeng1KanInfo> selectByCondition(Zeng1KanInfo zeng1KanInfo) {
        return super.getSqlSession().selectList("Zeng1KanInfoMapper.selectByCondition",zeng1KanInfo );
    }

}
