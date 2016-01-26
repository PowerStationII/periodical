package com.cn.periodical.manager.impl;

import com.cn.periodical.dao.Zeng1KanDetailDao;
import com.cn.periodical.manager.Zeng1KanDetailManager;
import com.cn.periodical.pojo.Zeng1KanDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午10:43
 * To change this template use File | Settings | File Templates.
 */
@Component("zeng1KanDetailManager")
public class Zeng1KanDetailMangerImpl implements Zeng1KanDetailManager {

    @Autowired
    Zeng1KanDetailDao zeng1KanDetailDao ;
    @Override
    public int insert(Zeng1KanDetail zeng1KanDetail) {
        return zeng1KanDetailDao.insert(zeng1KanDetail);
    }

    @Override
    public Zeng1KanDetail selectArticle(String articleId) {
        return zeng1KanDetailDao.selectArticle(articleId);
    }

    @Override
    public List<Zeng1KanDetail> selectByOrderNo(String orderNo) {
        return zeng1KanDetailDao.selectByOrderNo(orderNo);
    }

}
