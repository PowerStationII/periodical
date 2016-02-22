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
	    "value":'0002',    
	    "text":"已送审"
	},{
	    "value":'0006',    
	    "text":"已返修"
	},{    
	    "value":'0007',    
	    "text":"已退稿"
	},{    
	    "value":'0008',    
	    "text":"已待刊"
	}] ;
	return data;
}
//function getArticleState(){
//	var data=[{
//	    "value":'',
//	    "text":"全部",
//	    "selected":true
//	},
////        {
////	    "value":'0000',
////	    "text":"初投稿"
////	},
//        {
//	    "value":'0001',
//	    "text":"已登记"
//	},{
//	    "value":'0002',
//	    "text":"已送审"
//	},{
//	    "value":'0003',
//	    "text":"已待刊"
//	},{
//	    "value":'0004',
//	    "text":"处理中"
//	},{
//	    "value":'0005',
//	    "text":"作废"
//	},{
//	    "value":'0006',
//	    "text":"返修"
//	},{
//	    "value":'0007',
//	    "text":"退稿"
//	},{
//	    "value":'0008',
//	    "text":"处理完成"
//	}] ;
//	return data;
//}

/**
 * 证件类型枚举下拉
 * @returns {Array}
 */
function getZJLXState(){
	var data=[{    
	    "value":'IDCARD',
	    "text":"身份证",
	    "selected":true
	},{    
	    "value":'BOOKLET',    
	    "text":"户口簿"   
	},{    
	    "value":'PASSPORT',    
	    "text":"护照",    
	},{    
	    "value":'OFFICERCARD',    
	    "text":"军官证"   
	},{    
	    "value":'SOLDIERCARD',    
	    "text":"士兵证"   
	},{    
	    "value":'HKANDMCARD',    
	    "text":"港澳居民来往内地通行证",    
	},{    
	    "value":'TAIWANCARD',    
	    "text":"台湾同胞来往内地通行证"   
	},{    
	    "value":'TEMPORARYID',    
	    "text":"临时身份证"   
	},{    
	    "value":'ForeignerID',    
	    "text":"外国人居留证"   
	}
	,{    
	    "value":'PoliceID',    
	    "text":"警官证"   
	},{    
	    "value":'OtherCard',    
	    "text":"其他证件"   
	}] ;
	return data;
}

/**
 * 证件类型枚举下拉2
 * @returns {Array}
 */
function getZJLXState2(){
	var data=[{    
	    "value":'0',
	    "text":"身份证",
	    "selected":true
	},{    
	    "value":'1',    
	    "text":"户口簿"   
	},{    
	    "value":'2',    
	    "text":"护照",    
	},{    
	    "value":'3',    
	    "text":"军官证"   
	},{    
	    "value":'4',    
	    "text":"士兵证"   
	},{    
	    "value":'5',    
	    "text":"港澳居民来往内地通行证",    
	},{    
	    "value":'6',    
	    "text":"台湾同胞来往内地通行证"   
	},{    
	    "value":'7',    
	    "text":"临时身份证"   
	},{    
	    "value":'8',    
	    "text":"外国人居留证"   
	}
	,{    
	    "value":'9',    
	    "text":"警官证"   
	},{    
	    "value":'X',    
	    "text":"其他证件"   
	}] ;
	return data;
}

/**
 * 学历类型枚举下拉
 * @returns {Array}
 */
function getXLLXState(){
	var data=[{    
	    "value":'JUNIOR_SCHOOL',
	    "text":"小学",
	    "selected":true
	},{    
	    "value":'MIDDLE_SCHOOL',    
	    "text":"初中"   
	},{    
	    "value":'SENIOR_SCHOOL',    
	    "text":"高中",    
	},{    
	    "value":'POLYTECHNIC_SCHOOL',    
	    "text":"中专"   
	},{    
	    "value":'VOCATIONAL_SCHOOL',    
	    "text":"高职"   
	},{    
	    "value":'JUNIOR_COLLEGE',    
	    "text":"专科",    
	},{    
	    "value":'BACHELOR_DEGREE',    
	    "text":"本科"   
	},{    
	    "value":'MASTER_DEGREE',    
	    "text":"硕士研究生"   
	},{    
	    "value":'DOCTORAL',    
	    "text":"博士研究生"   
	}] ;
	return data;
}

/**
 * 学历类型枚举下拉2
 * @returns {Array}
 */
function getXLLXState2(){
	var data=[{    
	    "value":'0',
	    "text":"小学",
	    "selected":true
	},{    
	    "value":'1',    
	    "text":"初中"   
	},{    
	    "value":'2',    
	    "text":"高中",    
	},{    
	    "value":'3',    
	    "text":"中专"   
	},{    
	    "value":'4',    
	    "text":"高职"   
	},{    
	    "value":'5',    
	    "text":"专科",    
	},{    
	    "value":'6',    
	    "text":"本科"   
	},{    
	    "value":'7',    
	    "text":"硕士研究生"   
	},{    
	    "value":'8',    
	    "text":"博士研究生"   
	}] ;
	return data;
}

/**
 * 学位类型枚举下拉
 * @returns {Array}
 */
function getXWLXState(){
	var data=[{    
	    "value":'BACHELOR',
	    "text":"学士",
	    "selected":true
	},{    
	    "value":'MASTER',    
	    "text":"硕士"   
	},{    
	    "value":'DOCTOR',    
	    "text":"博士",    
	},{    
	    "value":'POST',    
	    "text":"博士后"   
	}] ;
	return data;
}

/**
 * 学位类型枚举下拉2
 * @returns {Array}
 */
function getXWLXState2(){
	var data=[{    
	    "value":'0',
	    "text":"学士",
	    "selected":true
	},{    
	    "value":'1',    
	    "text":"硕士"   
	},{    
	    "value":'2',    
	    "text":"博士",    
	},{    
	    "value":'3',    
	    "text":"博士后"   
	}] ;
	return data;
}

/**
 * 企业单位类型枚举下拉
 * @returns {Array}
 */
function getQYLXState(){
	var data=[{    
	    "value":'ENTERPRISES',
	    "text":"国企",
	    "selected":true
	},{    
	    "value":'PRIVATE_ENTERPRISES',    
	    "text":"私企"   
	},{    
	    "value":'FOREIGN_COMPANY',    
	    "text":"外企",    
	},{    
	    "value":'RESEARCH_COMPANY',    
	    "text":"科研单位"   
	},{    
	    "value":'COMPANY_OTHERS',    
	    "text":"其他"   
	}] ;
	return data;
}

/**
 * 企业单位类型枚举下拉2
 * @returns {Array}
 */
function getQYLXState2(){
	var data=[{    
	    "value":'0',
	    "text":"国企",
	    "selected":true
	},{    
	    "value":'1',    
	    "text":"私企"   
	},{    
	    "value":'2',    
	    "text":"外企",    
	},{    
	    "value":'3',    
	    "text":"科研单位"   
	},{    
	    "value":'4',    
	    "text":"其他"   
	}] ;
	return data;
}

/**
 * 性别枚举下拉
 * @returns {Array}
 */
function getXBState(){
	var data=[{    
	    "value":'male',
	    "text":"男",
	    "selected":true
	},{    
	    "value":'female',    
	    "text":"女"   
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
/**
 * 年
 * @returns {Array}
 */
function getYear(){
    var data=[{
        "value":'',
        "text":"请选择",
        "selected":true
    },
        {
	    "value":'2015',
	    "text":"2015"
	},
        {
            "value":'2016',
            "text":"2016"
        },{
            "value":'2017',
            "text":"2017"
        },{
            "value":'2018',
            "text":"2018"
        },{
            "value":'2019',
            "text":"2019"
        },{
            "value":'2020',
            "text":"2020"
        },{
            "value":'2021',
            "text":"2021"
        },{
            "value":'2022',
            "text":"2022"
        }] ;
    return data;
}

function getReadTye(){
    var data=[{
        "value":'',
        "text":"请选择",
        "selected":true
    }, {
        "value":'1011',
        "text":"企业读者"
    },
        {
            "value":'1002',
            "text":"个人读者"
        }
        ] ;
    return data;
}
 