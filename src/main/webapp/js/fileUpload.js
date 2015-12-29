/**
 * Created with IntelliJ IDEA.
 * User: 1
 * Date: 15-12-28
 * Time: 下午10:24
 * To change this template use File | Settings | File Templates.
 */

function ajaxFileUpload(){
    $.ajaxFileUpload({
            url:'../upLoadFile',            //需要链接到服务器地址
            secureuri:false,
            fileElementId:'files',                  //文件选择框的id属性
            dataType: 'json',                      //服务器返回的格式，可以是json, xml
            data:{filePath:"filePath"},
            success: function (data, status){     //相当于java中try语句块的用法
                haveUploadFile = true ;
                alert(data.message);
            },
            error: function (data, status, e){  //相当于java中catch语句块的用法
                alert(data.message);
            }
        }
    );
}