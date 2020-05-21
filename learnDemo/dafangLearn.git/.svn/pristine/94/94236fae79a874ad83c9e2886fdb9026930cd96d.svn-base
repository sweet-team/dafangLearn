$.ajaxSettings.async = false;
$.ajaxSetup({
	headers:{
		"token":"e0273ed5c1522e5498d320840454ad16"
	}
});
$.ajaxSettings.async = true;


(function($) {
	var _ajax = $.ajax;

	$.ajax = function(opt) {
		//备份opt中error和success方法
		var fn = {
			error: function(XMLHttpRequest, textStatus, errorThrown) {},
			success: function(data, textStatus) {}
		}

		if (opt.error) {
			fn.error = opt.error;
		}

		if (opt.success) {
			fn.success = opt.success;
		}

		//扩展增强处理
		var _opt = $.extend(opt, {
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				//错误方法增强处理
				fn.error(XMLHttpRequest, textStatus, errorThrown);
			},

			success: function(data, textStatus, xhr) {
				var statusCode = data.code;
				if(statusCode === 1001){
					if(typeof(common_login)!="undefined" && common_login!=""){
						window.location.href = common_login;
					}else{
						window.location.href = server_path+"login.html";
					}
				}else if(statusCode === 10001){
					$.message.alert("提示","文件已不存在","info");
				}else{
					fn.success(data, textStatus);
				}
			},

			statusCode: { 
				900: function() { 
					alert("您没有权限进行此项操作，请联系管理员！");
					return;
				}
			}
		});
		_ajax(_opt);
	};
})(jQuery);
