package com.cn.periodical.manager;

import com.cn.periodical.pojo.SongKanDetail;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午10:41
 * To change this template use File | Settings | File Templates.
 */
public interface SongKanDetailManager {
    public int insert(SongKanDetail songKanDetail);

    public SongKanDetail selectArticle(String articleId);

    public List<SongKanDetail> selectByOrderNo(String orderNo);
}
