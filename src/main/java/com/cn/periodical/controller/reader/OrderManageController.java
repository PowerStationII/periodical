package com.cn.periodical.controller.reader;

import javax.servlet.http.HttpServletRequest;

import com.cn.periodical.manager.OrderInfoManager;
import com.cn.periodical.manager.PeriodicalInfoManager;
import com.cn.periodical.pojo.OrderInfo;
import com.cn.periodical.pojo.OrderInfoQuery;
import com.cn.periodical.pojo.PeriodicalInfo;
import com.cn.periodical.pojo.PeriodicalInfoQuery;
import com.cn.periodical.service.OrderInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 读者工作区-期刊征订-订单管理Controller
 * */
@Controller
public class OrderManageController extends ReaderController{
	
	private static final Logger logger = LoggerFactory.getLogger(OrderManageController.class);

    @Autowired
    OrderInfoService orderInfoService ;
    @Autowired
    PeriodicalInfoManager periodicalInfoManager;
	/**
	 * toOrderManagePage
	 * 订单管理页面
	 */
	@RequestMapping(value="/toOrderManagePage",method =  { RequestMethod.POST ,RequestMethod.GET})
	public ModelAndView toKeyWordsSearchPage(HttpServletRequest request ,OrderInfoQuery orderInfoQuery) {
		logger.info("订单管理Page:["+orderInfoQuery.getPeriodical_year()+"]");
        List<OrderInfo> list = orderInfoService.selectByYear(orderInfoQuery);
		ModelAndView mav = new ModelAndView("reader_orderManagePage");
		mav.addObject("list", list);
		return mav;
	}
	
	/**
	 * toCreatOrderPage
	 * 新建订单页面
	 */
	@RequestMapping(value="/toCreatOrderPage",method ={ RequestMethod.POST ,RequestMethod.GET})
	public ModelAndView toCreatOrderPage(PeriodicalInfoQuery periodicalInfoQuery) {
		logger.info("新建订单Page:["+periodicalInfoQuery+"]");
		ModelAndView mav = new ModelAndView("reader_creatOrderPage");
//        PeriodicalInfo periodicalInfo = periodicalInfoManager.findPeriodicalInfoById(1l) ;
        PeriodicalInfo periodicalInfo = new PeriodicalInfo();
        periodicalInfo.setCnNo("121");
        mav.addObject("periodicalInfo",periodicalInfo);
		
		
		
		return mav;
	}
}
