package com.cn.periodical.manager.impl;

import com.cn.periodical.dao.SongKanInfoDao;
import com.cn.periodical.dao.Zeng4KanInfoDao;
import com.cn.periodical.manager.SongKanInfoManager;
import com.cn.periodical.manager.Zeng4KanInfoManager;
import com.cn.periodical.pojo.SongKanInfo;
import com.cn.periodical.pojo.Zeng4KanInfo;
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
@Component("zeng4KanInfoManager")
public class Zeng4KanInfoManagerImpl implements Zeng4KanInfoManager {

    @Autowired
    Zeng4KanInfoDao zeng4KanInfoDao ;
    @Override
    public int insert(Zeng4KanInfo zeng4KanInfo) {
        return zeng4KanInfoDao.insert(zeng4KanInfo);
    }

    @Override
    public List<Zeng4KanInfo> selectByCondition(Zeng4KanInfo zeng4KanInfo) {
        return zeng4KanInfoDao.selectByCondition(zeng4KanInfo);
    }

}
