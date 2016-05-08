<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.zjy.utils.SystemProp"%>
<%@ page isELIgnored="false" %>
<%
    String contextUrl = SystemProp.getPropertyByName("contextUrl");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="<%=contextUrl%>/css/add.css" rel="stylesheet">
<script type="text/javascript" src="<%=contextUrl%>/js/kindeditor-all-min.js"></script>
<script type="text/javascript" src="<%=contextUrl%>/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=contextUrl%>/js/share.js"></script>
<script type="text/javascript" src="<%=contextUrl%>/js/blog/add.js"></script>
<script>
	var contextUrl = "<%=contextUrl%>";
</script>
<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content"]', {
				cssPath : '../plugins/code/prettify.css',
				uploadJson : '../jsp/upload_json.jsp',
				fileManagerJson : '../jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						//document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						//document.forms['example'].submit();
					});
				},
				afterBlur:function(){
					this.sync();
				}
			});
			//prettyPrint();
		});
	</script>
</head>
<body>
    <form name="example" method="post" action="demo.jsp">
    <p><span >标题</span></p>
    <input type="text" id="title" />
    <p><span >分类</span></p>
    <select id="fenlei"  name="sorted">
        <option value="技术">技术</option>
        <option value="闲言碎语">闲言碎语</option>
        <option value="关于">关于</option>
    </select> 
    <p><span class="wen">正文</span></p>
    <p class="txt_editor">
        <textarea id="editor_id" name="content" >
        </textarea>
    </p>
    <input type="button" value="提交" onclick="clickbtn();"/>
    </form>    
</body>
</html>