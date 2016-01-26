package com.cn.periodical.manager;

import com.cn.periodical.pojo.Zeng1KanDetail;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午10:41
 * To change this template use File | Settings | File Templates.
 */
public interface Zeng1KanDetailManager {
    public int insert(Zeng1KanDetail zeng1KanDetail);

    public Zeng1KanDetail selectArticle(String articleId);

    public List<Zeng1KanDetail> selectByOrderNo(String orderNo);
}
