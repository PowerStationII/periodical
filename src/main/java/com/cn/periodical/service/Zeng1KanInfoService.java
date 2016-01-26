package com.cn.periodical.service;

import com.cn.periodical.pojo.Zeng1KanDetail;
import com.cn.periodical.pojo.Zeng1KanInfo;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午11:09
 * To change this template use File | Settings | File Templates.
 */
public interface Zeng1KanInfoService {
    public int insert(Zeng1KanInfo zeng4KanInfo, List<Map<String, Object>> articleId);

    public List<Zeng1KanInfo> selectByCondition(Zeng1KanInfo songKanInfo);

    public List<Zeng1KanDetail> selectByOrderNo(String orderNo);

    public int insert(Zeng1KanInfo zeng1KanInfo);

    public int insertZeng1KanDetail(List<Zeng1KanDetail> list);
}
