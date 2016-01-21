package com.cn.periodical.dao;

import com.cn.periodical.pojo.Zeng4KanDetail;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午10:38
 * To change this template use File | Settings | File Templates.
 */
public interface Zeng4KanDetailDao {
    public int insert(Zeng4KanDetail zeng4KanDetail);

    public Zeng4KanDetail selectArticle(String articleId);
    public List<Zeng4KanDetail> selectByOrderNo(String orderNo);
}
