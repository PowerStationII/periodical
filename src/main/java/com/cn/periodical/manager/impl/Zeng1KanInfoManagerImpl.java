package com.cn.periodical.manager.impl;

import com.cn.periodical.dao.Zeng1KanInfoDao;
import com.cn.periodical.manager.Zeng1KanInfoManager;
import com.cn.periodical.pojo.Zeng1KanInfo;
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
@Component("zeng1KanInfoManager")
public class Zeng1KanInfoManagerImpl implements Zeng1KanInfoManager {

    @Autowired
    Zeng1KanInfoDao zeng1KanInfoDao ;
    @Override
    public int insert(Zeng1KanInfo zeng1KanInfo) {
        return zeng1KanInfoDao.insert(zeng1KanInfo);
    }

    @Override
    public List<Zeng1KanInfo> selectByCondition(Zeng1KanInfo zeng1KanInfo) {
        return zeng1KanInfoDao.selectByCondition(zeng1KanInfo);
    }

}
