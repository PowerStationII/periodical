package com.cn.periodical.service;

import com.cn.periodical.pojo.SongKanDetail;
import com.cn.periodical.pojo.SongKanInfo;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午11:09
 * To change this template use File | Settings | File Templates.
 */
public interface SongKanInfoService {
    public int insert(SongKanInfo songKanInfo , List<Map<String,Object>> articleId);

    public List<SongKanInfo> selectByCondition(SongKanInfo songKanInfo);

    public List<SongKanDetail> selectByOrderNo(String orderNo);
}
