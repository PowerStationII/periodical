/**
 * 
 */
	function submitForm(){  
		if ($('#u34_input').val()=="") {
			$.messager.alert('提示','用户名不能为空');
			return;
		}
		else if ($('#u35_input').val()=="") {
			$.messager.alert('提示','密码不能为空');
			return;
		}
		else {
			$('#sub').submit();
		}
	}  
	$(function(){
  		var frame = '<iframe  style="width:650px;height:760px;margin-left:400px;margin-top:75px;position:absolute;" src= "totototo"   frameborder="no" marginwidth="0" marginheight="0" scrolling="auto" allowtransparency="yes" ></iframe><div><input type="button"  value="返回"   id="back"  onclick="reBack()" style="margin-left:950px;position:absolute;font-size:18px;width:70px;height:30px;"></div>';
  		$('#u4').click(function(){
  			$('#login').hide();
  			$('iframe').remove();
  			$('#back').remove();
  			$('#u12').after(frame.replace('totototo','toTouGao'));
  			$('#back').css('margin-top','740px');
  		});
  		$('#u6').click(function(){
  			$('#login').hide();
  			$('iframe').remove();
  			$('#back').remove();
  			$('#u12').after(frame.replace('totototo','toBanQuquan'));
  			$('#back').css('margin-top','640px');
  		});
  		$('#u8').click(function(){
  			$('#login').hide();
  			$('iframe').remove();
  			$('#back').remove();
  			$('#u12').after(frame.replace('totototo','toGuiFan'));
  			$('#back').css('margin-top','740px');
  		});
  		$('#u10').click(function(){
  			window.location.href='portal';
  		});
  		$('#u12').click(function(){
  			$('#login').hide();
  			$('iframe').remove();
  			$('#back').remove();
  			$('#u12').after(frame.replace('totototo','toLianXi'));
  			$('#back').css('margin-top','640px');
  		});
	});
	
	function reBack () {
		$('#login').show();
		$('iframe').remove();
		$('#back').remove();
	}