var articles;
function girl(){
    var oUrl = contextUrl+"/live/article/findAll";
    var oData={};
    var callBack=function(data){
    	for(var i=0;i<9;i++){
    		articles = data.data;
    		var x = $("<li><a target='_blank' href='"+contextUrl+'/live/article/findById?id='+articles[i].id+"'>"+articles[i].article_name+"</a></li>");
    		$("#newslistUl").append(x);
    	}
    };
    ajaxRequestFun(oUrl,oData,callBack);
};

