package com.cn.periodical.service.impl;

import com.cn.periodical.manager.AuthorInfoManager;
import com.cn.periodical.manager.Zeng4KanDetailManager;
import com.cn.periodical.manager.Zeng4KanInfoManager;
import com.cn.periodical.pojo.Zeng4KanDetail;
import com.cn.periodical.pojo.Zeng4KanInfo;
import com.cn.periodical.service.Zeng4KanInfoService;
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
@Service("zeng4KanInfoService")
public class Zeng4KanInfoServiceImpl implements Zeng4KanInfoService {
    @Autowired
    Zeng4KanInfoManager zeng4KanInfoManager ;
    @Autowired
    Zeng4KanDetailManager zeng4KanDetailManager ;
    @Autowired
    AuthorInfoManager authorInfoManager ;
    @Autowired
    TransactionTemplate transactionTemplate;
    @Override
    public int insert(final Zeng4KanInfo zeng4KanInfo, final List<Map<String,Object>> articleIds) {


        final List<Zeng4KanDetail> songKanDetails = new ArrayList<Zeng4KanDetail>();
        /**
         *     根据文章号，查询对应的通讯作者的相关信息
          */
        for(Map<String,Object> m : articleIds){
            String articleid = (String)m.get("articleId");
            int zengSonNums = Integer.parseInt(String.valueOf(m.get("nums")));
            List<Object> list_temp0 = authorInfoManager.selectAuthorByArticl(articleid);
            Zeng4KanDetail songKanDetail = new Zeng4KanDetail();
            songKanDetail.setPeriodicalId(zeng4KanInfo.getPeriodicalId());
            songKanDetail.setPeriodicalIssueNo(zeng4KanInfo.getPeriodicalIssueNo());
            songKanDetail.setCycleNums(zeng4KanInfo.getCycleNums());
            songKanDetail.setArticleId(articleid);
            songKanDetail.setZengSonNum(zengSonNums);
            songKanDetail.setOrderNo(zeng4KanInfo.getOrderNo());
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
                    int temp0 = zeng4KanInfoManager.insert(zeng4KanInfo);
                    if(1!=temp0){
                        throw new RuntimeException("songKanInfo保存失败");
                    }
                    for(Zeng4KanDetail zeng4KanDetail : songKanDetails){
                        int temp1 = zeng4KanDetailManager.insert(zeng4KanDetail);
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
    public List<Zeng4KanInfo> selectByCondition(Zeng4KanInfo zeng4KanInfo) {
        return zeng4KanInfoManager.selectByCondition(zeng4KanInfo);
    }

    @Override
    public List<Zeng4KanDetail> selectByOrderNo(String orderNo) {
        return zeng4KanDetailManager.selectByOrderNo(orderNo);
    }

    /**
     * 初始化赠刊用的，暂时未完成
     * @param zeng4KanInfo
     *
     * INSERT INTO `zeng4kan_info` (periodical_id,periodical_issue_no,cycle_nums,zengSon_nums,order_no,YEAR)
    SELECT periodical_id,periodical_issue_no,cycle_nums,0,'ZK20150001',periodical_year FROM `periodical`
     * @return
     */
    @Override
    public int insert(final Zeng4KanInfo zeng4KanInfo) {
        int k =(Integer) transactionTemplate.execute(new TransactionCallback<Object>(){
            public Object doInTransaction(TransactionStatus status) {
                try{
                  for(int i = 1 ; i<=12 ; i++){
                      zeng4KanInfoManager.insert(zeng4KanInfo) ;
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

    @Override
    public int insertZeng4KanDetail(final List<Zeng4KanDetail> list) {
        int k =(Integer) transactionTemplate.execute(new TransactionCallback<Object>(){
            public Object doInTransaction(TransactionStatus status) {
                try{
                    for(Zeng4KanDetail zeng4KanDetail :list){
                        int i = zeng4KanDetailManager.insert(zeng4KanDetail) ;
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

    public Zeng4KanInfoManager getZeng4KanInfoManager() {
        return zeng4KanInfoManager;
    }

    public void setZeng4KanInfoManager(Zeng4KanInfoManager zeng4KanInfoManager) {
        this.zeng4KanInfoManager = zeng4KanInfoManager;
    }

    public Zeng4KanDetailManager getZeng4KanDetailManager() {
        return zeng4KanDetailManager;
    }

    public void setZeng4KanDetailManager(Zeng4KanDetailManager zeng4KanDetailManager) {
        this.zeng4KanDetailManager = zeng4KanDetailManager;
    }
}
