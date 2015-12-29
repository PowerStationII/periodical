package com.cn.periodical.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 登录Controller
 */
@Controller 
public class TopController {

	private static final Logger logger = LoggerFactory.getLogger(TopController.class);

	/**
	 * 跳转到广告业务写死页面
	 */
	@RequestMapping(value="/toGuangGao",method = RequestMethod.GET)
	public String toGuangGaoPage() {
		return "link/guanggao";
	}
	
	/**
	 * 跳转到联系我们写死页面
	 */
	@RequestMapping(value="/toLianXi",method = RequestMethod.GET)
	public String toLianXiPage() {
		return "link/lianxiwomen";
	}
    /**
     * 跳转到编委会写死页面
     */
    @RequestMapping(value="/toBianWeiHui",method = RequestMethod.GET)
    public String toBianWeiHui() {
        return "link/bianweihui";
    }
	/**
	 * 跳转到论文规范写死页面
	 */
	@RequestMapping(value="/toGuiFan",method = RequestMethod.GET)
	public String toGuiFanPage() {
		return "link/lunwenguifan";
	}
	
	/**
	 * 跳转到期刊介绍写死页面
	 */
	@RequestMapping(value="/toJieShao",method = RequestMethod.GET)
	public String toJieShaoPage() {
		return "link/qikanjieshao";
	}
	
	/**
	 * 跳转到期刊征订写死页面
	 */
	@RequestMapping(value="/toZhengDing",method = RequestMethod.GET)
	public String toZhengDingPage() {
		return "link/qikanzhengding";
	}
	
	/**
	 * 跳转到投稿须知写死页面
	 */
	@RequestMapping(value="/toTouGao",method = RequestMethod.GET)
	public String toTouGaoPage() {
		return "link/tougaoxuzhi";
	}
	
	/**
	 * 跳转到投稿须知写死页面
	 */
	@RequestMapping(value="/toBanQuquan",method = RequestMethod.GET)
	public String toBanQuquanPage() {
		return "link/banquanxieyi";
	}
	
}
