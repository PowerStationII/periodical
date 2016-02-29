/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import com.cn.periodical.pojo.ArticalCode;

public interface ArticalCodeManager {

    int insert(ArticalCode articalCode);

    ArticalCode queryArticalCodeByType(ArticalCode articalCode);

    String getCode (String type , String code);
    String getCode (String type , String code,String flag);

}