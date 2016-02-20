package com.cn.periodical.service.impl;

import com.cn.periodical.manager.AuthorInfoManager;
import com.cn.periodical.manager.SongKanDetailManager;
import com.cn.periodical.manager.SongKanInfoManager;
import com.cn.periodical.pojo.SongKanDetail;
import com.cn.periodical.pojo.SongKanInfo;
import com.cn.periodical.service.SongKanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yuguodong
 * Date: 16-1-18
 * Time: 上午11:10
 * To change this template use File | Settings | File Templates.
 */
@Service("songKanInfoService")
public class SongKanInfoServiceImpl implements SongKanInfoService {
    @Autowired
    SongKanInfoManager songKanInfoManager ;
    @Autowired
    SongKanDetailManager songKanDetailManager ;
    @Autowired
    AuthorInfoManager authorInfoManager ;
    @Autowired
    TransactionTemplate transactionTemplate;
    @Override
    public int insert(final SongKanInfo songKanInfo, final List<Map<String,Object>>articleIds) {


        final List<SongKanDetail> songKanDetails = new ArrayList<SongKanDetail>();
        /**
         *     根据文章号，查询对应的通讯作者的相关信息
          */
        for(Map<String,Object> m : articleIds){
            String articleid = (String)m.get("articleId");
            int zengSonNums = Integer.parseInt(String.valueOf(m.get("nums")));
            List<Object> list_temp0 = authorInfoManager.selectAuthorByArticl(articleid);
            SongKanDetail songKanDetail = new SongKanDetail();
            songKanDetail.setPeriodicalId(songKanInfo.getPeriodicalId());
            songKanDetail.setPeriodicalIssueNo(songKanInfo.getPeriodicalIssueNo());
            songKanDetail.setCycleNums(songKanInfo.getCycleNums());
            songKanDetail.setArticleId(articleid);
            songKanDetail.setZengSonNum(zengSonNums);
            songKanDetail.setOrderNo(songKanInfo.getOrderNo());
            if(null!=list_temp0 && !list_temp0.isEmpty()){
                Map<String,String> map_temp0 = (Map<String, String>) list_temp0.get(0);
                songKanDetail.setYoubian(map_temp0.get("receive_postcode"));
                songKanDetail.setDizhi(map_temp0.get("receive_address"));
                songKanDetail.setDanwei(map_temp0.get("company_name"));
                songKanDetail.setXingming(map_temp0.get("author_name"));
                songKanDetail.setDianhua(map_temp0.get("contacter_mobile")) ;
            }
            songKanDetails.add(songKanDetail);

        }

        /**
         * 以下是保存送刊信息
         */
        int k =(Integer) transactionTemplate.execute(new TransactionCallback<Object>(){
            public Object doInTransaction(TransactionStatus status) {
                try{
                    SongKanInfo songKanInfoQuery = new SongKanInfo() ;
                    songKanInfoQuery.setOrderNo(songKanInfo.getOrderNo());
                    List<SongKanInfo> list = songKanInfoManager.selectByCondition(songKanInfoQuery);
                    if(null!=list && !list.isEmpty()){
                        // 更新
                        songKanInfoQuery.setZengSonNums(songKanInfo.getZengSonNums());
                        int temp0 = songKanInfoManager.update(songKanInfoQuery);
                        if(1!=temp0){
                            throw new RuntimeException("songKanInfo保存失败");
                        }
                    }else{
                        int temp0 = songKanInfoManager.insert(songKanInfo);
                        if(1!=temp0){
                            throw new RuntimeException("songKanInfo保存失败");
                        }
                    }
                    songKanDetailManager.delete(songKanInfo.getOrderNo());
                    for(SongKanDetail songKanDetail : songKanDetails){
                        int temp1 = songKanDetailManager.insert(songKanDetail);
                        if(1!=temp1){
                            throw new RuntimeException("songKanDetail保存失败");
                        }
                    }
                    return 1 ;

                }catch (Exception e){
                    status.setRollbackOnly();
                    return 0 ;
                }

            }
        });
        return k ;
    }

    @Override
    public List<SongKanInfo> selectByCondition(SongKanInfo songKanInfo) {
        return songKanInfoManager.selectByCondition(songKanInfo);
    }

    @Override
    public List<SongKanDetail> selectByOrderNo(String orderNo) {
        return songKanDetailManager.selectByOrderNo(orderNo);
    }


    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public SongKanInfoManager getSongKanInfoManager() {
        return songKanInfoManager;
    }

    public void setSongKanInfoManager(SongKanInfoManager songKanInfoManager) {
        this.songKanInfoManager = songKanInfoManager;
    }

    public SongKanDetailManager getSongKanDetailManager() {
        return songKanDetailManager;
    }

    public void setSongKanDetailManager(SongKanDetailManager songKanDetailManager) {
        this.songKanDetailManager = songKanDetailManager;
    }

    public AuthorInfoManager getAuthorInfoManager() {
        return authorInfoManager;
    }

    public void setAuthorInfoManager(AuthorInfoManager authorInfoManager) {
        this.authorInfoManager = authorInfoManager;
    }
}
