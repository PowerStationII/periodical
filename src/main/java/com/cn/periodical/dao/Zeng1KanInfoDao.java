package com.cn.periodical.dao;

import com.cn.periodical.pojo.Zeng1KanInfo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午10:33
 * To change this template use File | Settings | File Templates.
 */
public interface Zeng1KanInfoDao {
    public int insert(Zeng1KanInfo zeng1KanInfo);

    public List<Zeng1KanInfo> selectByCondition(Zeng1KanInfo zeng1KanInfo);
}
