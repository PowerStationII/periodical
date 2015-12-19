/**
 * 稿件状态枚举下拉
 * @returns {Array}
 */
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

/**
 * 证件类型后台code和前段value转换
 */
function getCtfcType(value){
	if (value=='0' || value=='IDCARD') {
		return 'IDCARD';
	}
	else if (value=='1' || value=='BOOKLET') {
		return 'BOOKLET';
	}
	else if (value=='2' || value=='PASSPORT') {
		return 'PASSPORT';
	}
	else if (value=='3' || value=='OFFICERCARD') {
		return 'OFFICERCARD';
	}
	else if (value=='4' || value=='SOLDIERCARD') {
		return 'SOLDIERCARD';
	}
	else if (value=='5' || value=='HKANDMCARD') {
		return 'HKANDMCARD';
	}
	else if (value=='6' || value=='TAIWANCARD') {
		return 'TAIWANCARD';
	}
	else if (value=='7' || value=='TEMPORARYID') {
		return 'TEMPORARYID';
	}
	else if (value=='8' || value=='ForeignerID') {
		return 'ForeignerID';
	}
	else if (value=='9' || value=='PoliceID') {
		return 'PoliceID';
	}
	else if (value=='X' || value=='OtherCard') {
		return 'OtherCard';
	}
	else {
		return 'UNKNOWN';
	}
}

/**
 * 学历后台code和前段value转换
 */
function getEducation(value){
	if (value=='0' || value=='JUNIOR_SCHOOL') {
		return 'JUNIOR_SCHOOL';
	}
	else if (value=='1' || value=='MIDDLE_SCHOOL') {
		return 'MIDDLE_SCHOOL';
	}
	else if (value=='2' || value=='SENIOR_SCHOOL') {
		return 'SENIOR_SCHOOL';
	}
	else if (value=='3' || value=='POLYTECHNIC_SCHOOL') {
		return 'POLYTECHNIC_SCHOOL';
	}
	else if (value=='4' || value=='VOCATIONAL_SCHOOL') {
		return 'VOCATIONAL_SCHOOL';
	}
	else if (value=='5' || value=='JUNIOR_COLLEGE') {
		return 'JUNIOR_COLLEGE';
	}
	else if (value=='6' || value=='BACHELOR_DEGREE') {
		return 'BACHELOR_DEGREE';
	}
	else if (value=='7' || value=='MASTER_DEGREE') {
		return 'MASTER_DEGREE';
	}
	else if (value=='8' || value=='DOCTORAL') {
		return 'DOCTORAL';
	}
	else {
		return 'UNKNOWN';
	}
}

/**
 * 学位后台code和前段value转换
 */
function getAcademicDegree(value){
	if (value=='0' || value=='BACHELOR') {
		return 'BACHELOR';
	}
	else if (value=='1' || value=='MASTER') {
		return 'MASTER';
	}
	else if (value=='2' || value=='DOCTOR') {
		return 'DOCTOR';
	}
	else if (value=='3' || value=='POST') {
		return 'POST';
	}
	else {
		return 'UNKNOWN';
	}
}

/**
 * 企业类型后台code和前段value转换
 */
function getCompayType(value){
	if (value=='0' || value=='ENTERPRISES') {
		return 'ENTERPRISES';
	}
	else if (value=='1' || value=='PRIVATE_ENTERPRISES') {
		return 'PRIVATE_ENTERPRISES';
	}
	else if (value=='2' || value=='FOREIGN_COMPANY') {
		return 'FOREIGN_COMPANY';
	}
	else if (value=='3' || value=='RESEARCH_COMPANY') {
		return 'RESEARCH_COMPANY';
	}
	else if (value=='4' || value=='COMPANY_OTHERS') {
		return 'COMPANY_OTHERS';
	}
	else {
		return 'UNKNOWN';
	}
}

/**
 * 企业类型后台code和前段value转换
 */
function getSex(value){
	if (value=='male') {
		return '男';
	}
	else if (value=='female') {
		return '女';
	}
	else {
		return 'UNKNOWN';
	}
}


/**
 * 会员类型枚举下拉
 * @returns {Array}
 */
function getCouncilType(){
	var data=[{    
	    "value":'',
	    "text":"全部"
	},{    
	    "value":'DG',
	    "text":"理事长"
	},{    
	    "value":'SD',    
	    "text":"常务理事"   
	},{    
	    "value":'VDG',    
	    "text":"副理事长"    
	},{    
	    "value":'D',    
	    "text":"理事"   
	}] ;
	return data;
}

/**
 * 会员类型枚举下拉
 * @returns {Array}
 */
function getAdType(){
	var data=[{    
	    "value":'',
	    "text":"全部"
	},{    
	    "value":'XXGG',
	    "text":"形象类"
	},{    
	    "value":'SPGG',    
	    "text":"审批类"   
	}] ;
	return data;
}
 