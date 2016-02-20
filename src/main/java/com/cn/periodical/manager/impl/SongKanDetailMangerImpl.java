package com.cn.periodical.manager.impl;

import com.cn.periodical.dao.SongKanDetailDao;
import com.cn.periodical.manager.SongKanDetailManager;
import com.cn.periodical.pojo.SongKanDetail;
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
@Component("songKanDetailManager")
public class SongKanDetailMangerImpl implements SongKanDetailManager {

    @Autowired
    SongKanDetailDao songKanDetailDao ;
    @Override
    public int insert(SongKanDetail songKanDetail) {
        return songKanDetailDao.insert(songKanDetail);
    }

    @Override
    public SongKanDetail selectArticle(String articleId) {
        return songKanDetailDao.selectArticle(articleId);
    }
    @Override
    public int delete(String articleId) {
        return songKanDetailDao.delete(articleId);
    }

    @Override
    public List<SongKanDetail> selectByOrderNo(String orderNo) {
        return songKanDetailDao.selectByOrderNo(orderNo);
    }

    public SongKanDetailDao getSongKanDetailDao() {
        return songKanDetailDao;
    }

    public void setSongKanDetailDao(SongKanDetailDao songKanDetailDao) {
        this.songKanDetailDao = songKanDetailDao;
    }
}
