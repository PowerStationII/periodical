/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import com.cn.periodical.dao.ArticalCodeDao;
import com.cn.periodical.dao.BaseDao;
import com.cn.periodical.pojo.ArticalCode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("articalCodeDao")
public class ArticalCodeDaoImpl extends BaseDao implements ArticalCodeDao {


    @Override
    public int insert(ArticalCode articalCode) {
        return super.getSqlSession().insert("ArticalCodeMapper.insert", articalCode);
    }

    @Override
    public ArticalCode queryArticalCodeByType(ArticalCode articalCode) {
        List<ArticalCode>  list = super.getSqlSession().selectList("ArticalCodeMapper.queryArticalCodeByType", articalCode);
        ArticalCode articalCodeRet = null ;
        if(null!=list && !list.isEmpty()){
            articalCodeRet = list.get(0);
        }else{
            articalCodeRet = new ArticalCode();
            articalCodeRet.setCode("0");
            articalCodeRet.setType(articalCode.getType());
            articalCodeRet.setYear(articalCode.getYear());
        }
        return articalCodeRet;
    }
}
