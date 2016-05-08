var oJson=getArgs();
var id = oJson.id;//ID
function liOnclick(){
    var oUrl = contextUrl+"/live/article/findById";
    var oData={
    	id:id
    	};
    var callBack=function(data){
    	$("#content").html(data.data.content);
    };
    ajaxRequestFun(oUrl,oData,callBack);
};