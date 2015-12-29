package com.cn.periodical.manager.impl;

import com.cn.periodical.dao.ArticalCodeDao;
import com.cn.periodical.enums.ArticalCodeEnums;
import com.cn.periodical.manager.ArticalCodeManager;
import com.cn.periodical.pojo.ArticalCode;
import com.cn.periodical.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: 1
 * Date: 15-12-26
 * Time: 下午2:20
 * To change this template use File | Settings | File Templates.
 */
@Component("articalCodeManager")
public class ArticalCodeManagerImpl implements ArticalCodeManager {

    @Autowired
    @Qualifier("articalCodeDao")
    private ArticalCodeDao articalCodeDao;

    @Override
    public int insert(ArticalCode articalCode) {
        return articalCodeDao.insert(articalCode);
    }

    @Override
    public ArticalCode queryArticalCodeByType(ArticalCode articalCode) {
        return articalCodeDao.queryArticalCodeByType(articalCode);
    }

    @Override
    public String getCode(String type , String code) {
        ArticalCode articalCode = new ArticalCode();
        articalCode.setType(type);
        articalCode.setYear(DateUtil.getYear());
        ArticalCode articalCodeRet = this.queryArticalCodeByType(articalCode) ;
        int temp = articalCodeRet.getCode()+1;
//        String temp = String.valueOf(articalCodeRet.getCode()+1);
        String temp0 = "0000"+temp;
        final String articleId= code+articalCodeRet.getYear()+temp0.substring(temp0.length()-4,temp0.length());
        articalCode.setCode(temp);
        this.insert(articalCode);
        return articleId;
    }

}
