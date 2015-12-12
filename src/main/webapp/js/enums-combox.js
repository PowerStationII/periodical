//稿件状态枚举下拉
function getArticleState(){
	var data=[{    
	    "value":'',
	    "text":"全部",
	    "selected":true
	},{    
	    "value":'0000',
	    "text":"初投稿"   
	},{    
	    "value":'0001',    
	    "text":"已登记"   
	},{    
	    "value":'0002',    
	    "text":"已送审",    
	},{    
	    "value":'0003',    
	    "text":"已待刊"   
	},{    
	    "value":'0004',    
	    "text":"处理中"   
	},{    
	    "value":'0005',    
	    "text":"作废",    
	},{    
	    "value":'0006',    
	    "text":"返修"   
	},{    
	    "value":'0007',    
	    "text":"退稿"   
	},{    
	    "value":'0008',    
	    "text":"处理完成"   
	}] ;
	return data;
}
 