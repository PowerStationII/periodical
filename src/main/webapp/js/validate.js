function emailCheck(obj) {  
    var objName = obj.val();  
    var pattern = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;  
    if (!pattern.test(objName)) {  
        return false;  
    }  
    return true;  
}  