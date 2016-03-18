package com.cn.periodical.dao.impl;

import com.cn.periodical.dao.BaseDao;
import com.cn.periodical.dao.Zeng4KanDetailDao;
import com.cn.periodical.pojo.Zeng4KanDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午10:38
 * To change this template use File | Settings | File Templates.
 */
@Repository("zeng4KanDetailDao")
public class Zeng4KanDetailDaoImpl extends BaseDao implements Zeng4KanDetailDao {
    @Override
    public int insert(Zeng4KanDetail zeng4KanDetail) {
        return super.getSqlSession().insert("Zeng4KanDetailMapper.insert", zeng4KanDetail);
    }

    @Override
    public Zeng4KanDetail selectArticle(String articleId) {
        return super.getSqlSession().selectOne("Zeng4KanDetailMapper.selectArticle", articleId);
    }

    @Override
    public List<Zeng4KanDetail> selectByOrderNo(String orderNo) {
        return super.getSqlSession().selectList("Zeng4KanDetailMapper.selectByOrderNo", orderNo);
    }

    @Override
    public int deleteByorderNo(String orderNo) {
        return super.getSqlSession().delete("Zeng4KanDetailMapper.deleteByorderNo", orderNo);
    }


}
