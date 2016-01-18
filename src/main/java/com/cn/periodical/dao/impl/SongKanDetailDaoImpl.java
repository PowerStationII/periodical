package com.cn.periodical.dao.impl;

import com.cn.periodical.dao.BaseDao;
import com.cn.periodical.dao.SongKanDetailDao;
import com.cn.periodical.pojo.SongKanDetail;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午10:38
 * To change this template use File | Settings | File Templates.
 */
@Repository("songKanDetailDao")
public class SongKanDetailDaoImpl extends BaseDao implements SongKanDetailDao {
    @Override
    public int insert(SongKanDetail songKanDetail) {
        return super.getSqlSession().insert("SongKanDetailMapper.insert", songKanDetail);
    }

    @Override
    public SongKanDetail selectArticle(String articleId) {
        return super.getSqlSession().selectOne("SongKanDetailMapper.selectArticle", articleId);
    }


}
