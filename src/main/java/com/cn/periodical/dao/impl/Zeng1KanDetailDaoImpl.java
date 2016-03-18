package com.cn.periodical.dao.impl;

import com.cn.periodical.dao.BaseDao;
import com.cn.periodical.dao.Zeng1KanDetailDao;
import com.cn.periodical.pojo.Zeng1KanDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午10:38
 * To change this template use File | Settings | File Templates.
 */
@Repository("zeng1KanDetailDao")
public class Zeng1KanDetailDaoImpl extends BaseDao implements Zeng1KanDetailDao {
    @Override
    public int insert(Zeng1KanDetail zeng1KanDetail) {
        return super.getSqlSession().insert("Zeng1KanDetailMapper.insert", zeng1KanDetail);
    }

    @Override
    public Zeng1KanDetail selectArticle(String articleId) {
        return super.getSqlSession().selectOne("Zeng1KanDetailMapper.selectArticle", articleId);
    }

    @Override
    public List<Zeng1KanDetail> selectByOrderNo(String orderNo) {
        return super.getSqlSession().selectList("Zeng1KanDetailMapper.selectByOrderNo", orderNo);
    }

    @Override
    public int deleteByorderNo(String orderNo) {
        return super.getSqlSession().delete("Zeng1KanDetailMapper.deleteByorderNo", orderNo);
    }


}
