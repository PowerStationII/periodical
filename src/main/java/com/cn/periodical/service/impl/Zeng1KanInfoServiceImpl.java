package com.cn.periodical.service.impl;

import com.cn.periodical.manager.AuthorInfoManager;
import com.cn.periodical.manager.Zeng1KanDetailManager;
import com.cn.periodical.manager.Zeng1KanInfoManager;
import com.cn.periodical.pojo.Zeng1KanDetail;
import com.cn.periodical.pojo.Zeng1KanInfo;
import com.cn.periodical.pojo.Zeng4KanDetail;
import com.cn.periodical.service.Zeng1KanInfoService;
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
@Service("zeng1KanInfoService")
public class Zeng1KanInfoServiceImpl implements Zeng1KanInfoService {
    @Autowired
    Zeng1KanInfoManager zeng1KanInfoManager ;
    @Autowired
    Zeng1KanDetailManager zeng1KanDetailManager ;
    @Autowired
    AuthorInfoManager authorInfoManager ;
    @Autowired
    TransactionTemplate transactionTemplate;
    @Override
    public int insert(final Zeng1KanInfo zeng1KanInfo, final List<Map<String,Object>> articleIds) {


        final List<Zeng1KanDetail> songKanDetails = new ArrayList<Zeng1KanDetail>();
        /**
         *     根据文章号，查询对应的通讯作者的相关信息
          */
        for(Map<String,Object> m : articleIds){
            String articleid = (String)m.get("articleId");
            int zengSonNums = Integer.parseInt(String.valueOf(m.get("nums")));
            List<Object> list_temp0 = authorInfoManager.selectAuthorByArticl(articleid);
            Zeng1KanDetail songKanDetail = new Zeng1KanDetail();
            songKanDetail.setPeriodicalId(zeng1KanInfo.getPeriodicalId());
            songKanDetail.setPeriodicalIssueNo(zeng1KanInfo.getPeriodicalIssueNo());
            songKanDetail.setCycleNums(zeng1KanInfo.getCycleNums());
            songKanDetail.setArticleId(articleid);
            songKanDetail.setZengSonNum(zengSonNums);
            songKanDetail.setOrderNo(zeng1KanInfo.getOrderNo());
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
                    int temp0 = zeng1KanInfoManager.insert(zeng1KanInfo);
                    if(1!=temp0){
                        throw new RuntimeException("songKanInfo保存失败");
                    }
                    for(Zeng1KanDetail zeng1KanDetail : songKanDetails){
                        int temp1 = zeng1KanDetailManager.insert(zeng1KanDetail);
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
    public List<Zeng1KanInfo> selectByCondition(Zeng1KanInfo zeng1KanInfo) {
        return zeng1KanInfoManager.selectByCondition(zeng1KanInfo);
    }

    @Override
    public List<Zeng1KanDetail> selectByOrderNo(String orderNo) {
        return zeng1KanDetailManager.selectByOrderNo(orderNo);
    }

    /**
     * 初始化赠刊用的，暂时未完成
     * @param zeng1KanInfo
     *
     * INSERT INTO `zeng4kan_info` (periodical_id,periodical_issue_no,cycle_nums,zengSon_nums,order_no,YEAR)
    SELECT periodical_id,periodical_issue_no,cycle_nums,0,'ZK20150001',periodical_year FROM `periodical`
     * @return
     */
    @Override
    public int insert(final Zeng1KanInfo zeng1KanInfo) {
        return zeng1KanInfoManager.insert(zeng1KanInfo) ;
    }

    @Override
    public int insertZeng1KanDetail(final List<Zeng1KanDetail> list) {
        int k =(Integer) transactionTemplate.execute(new TransactionCallback<Object>(){
            public Object doInTransaction(TransactionStatus status) {
                try{
                    if(list.size()>0){
                        Zeng1KanDetail zeng1KanDetail = list.get(0);
                        zeng1KanDetailManager.deleteByorderNo(zeng1KanDetail.getOrderNo());
                    }
                    for(Zeng1KanDetail zeng1KanDetail :list){
                        int i = zeng1KanDetailManager.insert(zeng1KanDetail) ;
                        if(1!=1){
                            throw new RuntimeException("保存赠刊信息异常");
                        }
                    }
                    return 1 ;
                }catch (Exception e){

                    status.setRollbackOnly();
                    return 0 ;
                }

            }
        });
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }


    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }


    public AuthorInfoManager getAuthorInfoManager() {
        return authorInfoManager;
    }

    public void setAuthorInfoManager(AuthorInfoManager authorInfoManager) {
        this.authorInfoManager = authorInfoManager;
    }

    public Zeng1KanInfoManager getZeng1KanInfoManager() {
        return zeng1KanInfoManager;
    }

    public void setZeng1KanInfoManager(Zeng1KanInfoManager zeng1KanInfoManager) {
        this.zeng1KanInfoManager = zeng1KanInfoManager;
    }

    public Zeng1KanDetailManager getZeng1KanDetailManager() {
        return zeng1KanDetailManager;
    }

    public void setZeng1KanDetailManager(Zeng1KanDetailManager zeng1KanDetailManager) {
        this.zeng1KanDetailManager = zeng1KanDetailManager;
    }
}
