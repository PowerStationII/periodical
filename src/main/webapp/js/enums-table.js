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

//稿件状态枚举
function ArticleStateEnumsEdit(status,zhuanJiaStatus){
    if('0000' == status){
        return '初投稿';
    }else if('0001' == status){
        return '已登记';
    }else if('0002' == status & '0003'==zhuanJiaStatus){
        return '已送审(专家已审核)';
    }else if('0002' == status & '0002'==zhuanJiaStatus){
        return '已送审(专家未审核)';
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
	if('XXGG' == status){
		return '形象类';
	}else if('SPGG' == status){
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
	}else if('2' == status){
		return '护照';
	}else if('3' == status){
		return '军官证';
	}else if('4' == status){
		return '士兵证';
	}else if('5' == status){
		return '港澳居民来往内地通行证';
	}else if('6' == status){
		return '台湾同胞来往内地通行证';
	}else if('7' == status){
		return '临时身份证';
	}else if('8' == status){
		return '外国人居留证';
	}else if('9' == status){
		return '警官证';
	}else if('X' == status){
		return '其他证件';
	}else{
		return '未知';
	}
}

//期刊类型
function getPeriodicalType(status){
	if('N' == status){
		return '新刊';
	}else if('APD' == status){
		return '稿件部分组刊中';
	}else if('APO' == status){
		return '稿件部分组刊完成';
	}else if('ADPD' == status){
		return '广告组刊中';
	}else if('ADPO' == status){
		return '广告组刊完成';
	}else if('PI' == status){
		return '待签发';
	}else if('FI' == status){
		return '已签发';
	}else if('YINGWEN' == status){
        return '已送英文专家';
    }else if('PIBIANJI' == status){
        return '英文专家已审核';
    }else{
		return '未知';
	}
}

//广告类型
function getGGType(status){
	if('N' == status){
		return '稿件类';
	}else if('Y' == status){
		return '广告类';
	}else{
		return '未知';
	}
}

//角色
function getRoleType(status){
	if('1001' == status){
		return '作者';
	}else if('1002' == status){
		return '读者-个人';
	}else if('1011' == status){
		return '读者-省所/企业';
	}else if('1003' == status){
		return '中文专家';
	}else if('1004' == status){
		return '英文专家';
	}else if('1005' == status){
		return '主编';
	}else if('1006' == status){
		return '稿件编辑';
	}else if('1007' == status){
		return '广告编辑';
	}else if('1008' == status){
		return '发行编辑';
	}else if('1009' == status){
		return '签发人';
	}else if('1010' == status){
		return '系统管理员';
	}else{
		return '未知';
	}
}