function clickbtn(){
	var oUrl = contextUrl+"/live/article/add";
    var oData={
    	title:$("#title").val(),
       	content:$("#editor_id").val(),
       	sorted:$("#fenlei").val()
       	};
    var callBack=function(data){
    	if(data.result=="success"){
    		alert("添加成功!");
    	}
    };
    ajaxRequestFun(oUrl,oData,callBack);
};