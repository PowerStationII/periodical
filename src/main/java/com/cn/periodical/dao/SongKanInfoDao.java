package com.cn.periodical.dao;

import com.cn.periodical.pojo.SongKanInfo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午10:33
 * To change this template use File | Settings | File Templates.
 */
public interface SongKanInfoDao {
    public int insert(SongKanInfo songKanInfo);

    public int update(SongKanInfo songKanInfo);

    public List<SongKanInfo> selectByCondition(SongKanInfo songKanInfo);
}
