package com.cn.periodical.manager;

import com.cn.periodical.pojo.SongKanInfo;
import com.cn.periodical.pojo.Zeng4KanInfo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午10:25
 * To change this template use File | Settings | File Templates.
 */
public interface Zeng4KanInfoManager {

    public int insert(Zeng4KanInfo zeng4KanInfo);

    public List<Zeng4KanInfo> selectByCondition(Zeng4KanInfo zeng4KanInfo);


}
