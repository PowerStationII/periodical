<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="x-ua-compatible" content="IE=edge, chrome=1">
    <title>下载</title>
    <!-- <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="js/jquery.jdownload.min.js"></script> -->
    <script type="text/javascript">
		$(function(){
				
		 }); 
    </script>
	<style type="text/css">
		body,div,ul,li,span,p,b,table,tr,td,th,h1,h2,h3,h4{
			margin:0; 
			padding:0;
		}
		html{height:100%;}
		body{
			background-size:100% 100%; 
			background-repeat:no-repeat; 
			overflow:hidden; 
			font-family:"黑体";
			height:100%;
		}
		.navigation {
			font-size: 14px;
			color: #B8FAFF;
			background-color: #019CDE;
			line-height: 40px;
			width: 1024px;
			margin-right: auto;
			margin-left: auto;
		}
		.body {
			background-color: #FFFFFF;
			height: 600px;
			width: 1024px;
			margin-right: auto;
			margin-left: auto;
		}
		.office {
			background-color: #FBF6FC;
			position:absolute;
			width:245px;
			height:170px;
			z-index:1;
			margin-left: 45px;
			margin-top: 20px;
			border:1px solid;
		}
		.council {
			background-color: #FBF6FC;
			position:absolute;
			width:245px;
			height:100px;
			z-index:2;
			margin-left: 45px;
			margin-top: 210px;
			border:1px solid;
		}
		.cover {
			background-color: #FFFFFF;
			position:absolute;
			width:395px;
			height:541px;
			z-index:1;
			margin-left: 280px;
			margin-top: -290px;
		}
		.notice {
			background-color: #FFFFFF;
			position:absolute;
			width:243px;
			height:115px;
			z-index:2;
			left: 705px;
			margin-top: -290px;
		}
		.download {
			background-color: #FFFFFF;
			position:absolute;
			width:244px;
			height:283px;
			z-index:3;
			left: 706px;
			margin-top: -115px;
		}
		.link {
			background-color: #FFFFFF;
			position:absolute;
			width:244px;
			height:120px;
			z-index:4;
			left: 708px;
			top: 220px;
		}
		 .office li{ 
			list-style-type:none;
			border:1px solid;
			border-radius:5px;
			text-align:center;
			height:25px;
			margin-left:10px;
			margin-right:10px;
			font-size:14px;
			margin-top:5px;
			line-height:25px;
			clear:both;
		}
		.title{
			height:35px;
			line-height:35px;
			font-size:14px;
			background:url(img/background-1.png) no-repeat;
			background-size:100%;
			color:#FFFFFF;
		}
		.txtLink{
			height:32px;
			line-height:32px;
			font-size: 14px;
			border-bottom:1px solid;
			text-align:center;
		}
		.notice div li,.download div li{ 
				list-style-type:none;
				text-align:left;
				height:25px;
				margin-left:10px;
				margin-right:10px;
				font-size:12px;
				margin-top:5px;
				line-height:25px;
				overflow:hidden;
				border-bottom:1px dotted;
		}
</style>
</head>
<body>
	<div class="navigation">
		<a  style="margin-left:40px;">首页&nbsp|</a>
		<a>期刊介绍&nbsp|</a>
		<a>编委会&nbsp|</a>
		<a>投稿须知&nbsp|</a>
		<a>论文要求/规范&nbsp|</a>
		<a>广告业务&nbsp|</a>
		<a>期刊征订&nbsp|</a>
		<a>联系我们&nbsp|</a>
	</div>
	<div class="body">
		  <div>
			    <div class="office">
			    	<div  class="title">&nbsp>>&nbsp在线办公系统</div>
			    	<li>编辑办公系统</li>
			    	<li>专家审稿系统</li>
			    	<li>作者投稿系统</li>
			    	<li>读者订阅系统</li>
			    </div>
			    <div class="council">
			    	  <div  class="title">&nbsp>>&nbsp理事会</div>
			    	  <div  class="txtLink">2015年《农药科学与管理》理事会</div>
			    	  <div  class="txtLink">理事会形象展示</div>
				      <div class="cover">
						<div style="width:395px;height:35px;line-height:35px;margin-left:10px;">| 期刊封面及介绍</div>
						<div style="width:394px;border:1px solid;"></div>
						<div style="width:395px;height:476px;background:url(img/cover.png) no-repeat 10px 10px;
									background-size:95% 95%;"></div>
					  </div>
				      <div class="notice">
						<div style="width:244px;height:35px;line-height:35px;margin-left:10px;">| 公告栏</div>
						<div style="width:243px;border:1px solid;"></div>
						<div style="width:243px;">
							<li>开通门户网站及采编系统</li>
							<li>《农药科学与管理》编辑部声明</li>
							<li>关于征订《农药科学与管理》2015年</li>
						</div>
					  </div>
				      <div class="download">
						<div style="width:244px;height:35px;line-height:35px;margin-left:10px;">| 下载中心</div>
						<div style="width:243px;border:1px solid;"></div>
						<div style="width:243px;">
							<li>>>《期刊出版形式规范》说明</li>
							<li>>>期刊编程规程</li>
							<li>>>学术论文编辑规范</li>
							<li>>>科学技术报告</li>
							<li>>>出版物数学用法的规定</li>
							<li>>>中文书刊名称汉语拼音拼写法</li>
						</div>
					  </div>
				      <div class="link">
						<div style="width:244px;height:35px;line-height:35px;margin-left:10px;">| 友情链接</div>
						<div style="width:243px;border:1px solid;"></div>
					  </div>
			    </div>
		  </div>
	</div>
</body>
</html>