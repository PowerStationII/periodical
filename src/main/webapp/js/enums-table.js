//稿件状态枚举
function ArticleStateEnums(status){
	if('0000' == status){
		return '初投稿';
	}else if('0001' == status){
		return '已登记';
	}else if('0002' == status){
		return '已送审';
	}else if('0003' == status){
		return '已待刊';
	}else if('0004' == status){
		return '处理中';
	}else if('0005' == status){
		return '作废';
	}else if('0006' == status){
		return '返修';
	}else if('0007' == status){
		return '退稿';
	}else if('0008' == status){
		return '处理完成';
	}else{
		return '未知';
	}
}
