package com.cn.periodical.service.impl;

import com.cn.periodical.manager.AddressInfoManager;
import com.cn.periodical.manager.OrderInfoManager;
import com.cn.periodical.pojo.AddressInfo;
import com.cn.periodical.pojo.OrderInfo;
import com.cn.periodical.pojo.OrderInfoQuery;
import com.cn.periodical.service.OrderInfoService;
import com.cn.periodical.utils.PropertiesInitManager;
import com.cn.periodical.utils.ReadExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 1
 * Date: 15-11-15
 * Time: 上午12:56
 * To change this template use File | Settings | File Templates.
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    OrderInfoManager orderInfoManager ;
    @Autowired
    AddressInfoManager saveAddressInfos ;

    public List<OrderInfo> selectByYear(OrderInfoQuery orderInfoQuery) {
        return orderInfoManager.queryList(orderInfoQuery);
    }

    @Override
    public void insertAddressInfo( MultipartFile[] files ,String orderNo , String refRole_id) {
        try {
            for(MultipartFile file :files ){
                InputStream is = file.getInputStream();
                ReadExcel readExcel = new ReadExcel("","",refRole_id,orderNo,is);
                List<AddressInfo> list = readExcel.readXls();
                saveAddressInfos.saveAddressInfos(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
