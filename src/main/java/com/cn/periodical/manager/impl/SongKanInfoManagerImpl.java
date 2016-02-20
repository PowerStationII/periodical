package com.cn.periodical.manager.impl;

import com.cn.periodical.dao.SongKanInfoDao;
import com.cn.periodical.manager.SongKanInfoManager;
import com.cn.periodical.pojo.SongKanInfo;
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
@Component("songKanInfoManager")
public class SongKanInfoManagerImpl implements SongKanInfoManager {

    @Autowired
    SongKanInfoDao songKanInfoDao ;
    @Override
    public int insert(SongKanInfo songKanInfo) {
        return songKanInfoDao.insert(songKanInfo);
    }
    @Override
    public int update(SongKanInfo songKanInfo) {
        return songKanInfoDao.update(songKanInfo);
    }

    @Override
    public List<SongKanInfo> selectByCondition(SongKanInfo songKanInfo) {
        return songKanInfoDao.selectByCondition(songKanInfo);
    }

    public SongKanInfoDao getSongKanInfoDao() {
        return songKanInfoDao;
    }

    public void setSongKanInfoDao(SongKanInfoDao songKanInfoDao) {
        this.songKanInfoDao = songKanInfoDao;
    }
}
