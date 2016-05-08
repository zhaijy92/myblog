function ajaxRequestFun(url,data,callback){//async=yes 同步
	$.ajax({
		type : "post",
		url : url,
		async : false,
		dataType : "json",
		data : data,
		success : function(data) {
			callback(data);
		},
		error : function(e){
			showAlert2("获取数据失败");
		}
	});
}

//url中传递参数
var getArgs = function (){
	var args = new Object(); //声明一个空对象
	var query = window.location.search.substring(1); // 取查询字符串，如从http://www.snowpeak.org/testjs.htm?a1=v1&a2=&a3=v3#anchor 中截出 a1=v1&a2=&a3=v3。
	var pairs = query.split("&"); // 以 & 符分开成数组
	for(var i = 0; i < pairs.length; i++) {
		var pos = pairs[i].indexOf('='); // 查找 "name=value" 对
		if (pos == -1) continue; // 若不成对，则跳出循环继续下一对
		var argname = pairs[i].substring(0,pos); // 取参数名
		var value = pairs[i].substring(pos+1); // 取参数值
		value = decodeURIComponent(value); // 若需要，则解码
		args[argname] = value; // 存成对象的一个属性
	}
	return args; // 返回此对象
};