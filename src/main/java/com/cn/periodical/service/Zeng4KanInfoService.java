package com.cn.periodical.service;

import com.cn.periodical.pojo.SongKanDetail;
import com.cn.periodical.pojo.SongKanInfo;
import com.cn.periodical.pojo.Zeng4KanDetail;
import com.cn.periodical.pojo.Zeng4KanInfo;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午11:09
 * To change this template use File | Settings | File Templates.
 */
public interface Zeng4KanInfoService {
    public int insert(Zeng4KanInfo zeng4KanInfo, List<Map<String, Object>> articleId);

    public List<Zeng4KanInfo> selectByCondition(Zeng4KanInfo songKanInfo);

    public List<Zeng4KanDetail> selectByOrderNo(String orderNo);

    public int insert(Zeng4KanInfo zeng4KanInfo);

    public int insertZeng4KanDetail(List<Zeng4KanDetail> list);
}
