package com.cn.periodical.manager;

import com.cn.periodical.pojo.Zeng1KanInfo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午10:25
 * To change this template use File | Settings | File Templates.
 */
public interface Zeng1KanInfoManager {

    public int insert(Zeng1KanInfo zeng1KanInfo);

    public List<Zeng1KanInfo> selectByCondition(Zeng1KanInfo zeng1KanInfo);


}
