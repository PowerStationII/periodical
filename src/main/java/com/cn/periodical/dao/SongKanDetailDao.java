package com.cn.periodical.dao;

import com.cn.periodical.pojo.SongKanDetail;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午10:38
 * To change this template use File | Settings | File Templates.
 */
public interface SongKanDetailDao {
    public int insert(SongKanDetail songKanDetail);

    public SongKanDetail selectArticle(String articleId);
}