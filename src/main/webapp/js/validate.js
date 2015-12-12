//邮箱格式
function emailCheck(obj) {  
    var objName = obj.val();  
    var pattern = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;  
    if (!pattern.test(objName)) {  
        return false;  
    }  
    return true;  
}  

//非0的正整数
function intNotZeroCheck(obj) {  
    var objName = obj.val();  
    var pattern = new RegExp("^[0-9]*$");  
    if (!pattern.test(objName)) {  
        return false;  
    }  
    return true;  
} 


