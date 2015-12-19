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

/**
 * 会员类型枚举下拉
 * @returns {Array}
 */
function CouncilType(status){
	if('DG' == status){
		return '理事长';
	}else if('SD' == status){
		return '常务理事';
	}else if('VDG' == status){
		return '副理事长';
	}else if('D' == status){
		return '理事';
	}else{
		return '未知';
	}
}

function getAdsType(status){
	if('XX' == status){
		return '形象类';
	}else if('SP' == status){
		return '审批类';
	}else{
		return '未知';
	}
}

//证件类型
function getZJType(status){
	if('0' == status){
		return '身份证';
	}else if('1' == status){
		return '户口簿';
	}if('2' == status){
		return '护照';
	}else if('3' == status){
		return '军官证';
	}if('4' == status){
		return '士兵证';
	}else if('5' == status){
		return '港澳居民来往内地通行证';
	}if('6' == status){
		return '台湾同胞来往内地通行证';
	}else if('7' == status){
		return '临时身份证';
	}if('8' == status){
		return '外国人居留证';
	}else if('9' == status){
		return '警官证';
	}else if('X' == status){
		return '其他证件';
	}else{
		return '未知';
	}
}
