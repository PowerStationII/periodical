package com.cn.periodical.manager.impl;

import com.cn.periodical.dao.SongKanDetailDao;
import com.cn.periodical.dao.Zeng4KanDetailDao;
import com.cn.periodical.manager.SongKanDetailManager;
import com.cn.periodical.manager.Zeng4KanDetailManager;
import com.cn.periodical.pojo.SongKanDetail;
import com.cn.periodical.pojo.Zeng4KanDetail;
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
@Component("zeng4KanDetailManager")
public class Zeng4KanDetailMangerImpl implements Zeng4KanDetailManager {

    @Autowired
    Zeng4KanDetailDao zeng4KanDetailDao ;
    @Override
    public int insert(Zeng4KanDetail zeng4KanDetail) {
        return zeng4KanDetailDao.insert(zeng4KanDetail);
    }

    @Override
    public Zeng4KanDetail selectArticle(String articleId) {
        return zeng4KanDetailDao.selectArticle(articleId);
    }

    @Override
    public List<Zeng4KanDetail> selectByOrderNo(String orderNo) {
        return zeng4KanDetailDao.selectByOrderNo(orderNo);
    }

    @Override
    public int deleteByorderNo(String orderNo) {
        return zeng4KanDetailDao.deleteByorderNo(orderNo);
    }

}
