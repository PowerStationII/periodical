package com.cn.periodical.dao;

import com.cn.periodical.pojo.Zeng4KanInfo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午10:33
 * To change this template use File | Settings | File Templates.
 */
public interface Zeng4KanInfoDao {
    public int insert(Zeng4KanInfo zeng4KanInfo);

    public List<Zeng4KanInfo> selectByCondition(Zeng4KanInfo zeng4KanInfo);
}
