<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.zjy.utils.SystemProp"%>
<%
    String contextUrl = SystemProp.getPropertyByName("contextUrl");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="<%=contextUrl%>/css/index.css" rel="stylesheet">
<script type="text/javascript" src="<%=contextUrl%>/js/blog/modernizr.js"></script>
<script type="text/javascript" src="<%=contextUrl%>/js/kindeditor-all-min.js"></script>
<script type="text/javascript" src="<%=contextUrl%>/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=contextUrl%>/js/share.js"></script>
<script type="text/javascript" src="<%=contextUrl%>/js/blog/content.js"></script>
<script>
	var contextUrl = "<%=contextUrl%>";
</script>
</head>
<body>
<header>
  <h1><a href="/">ZZ_HOMEのYing</a></h1>
  <p>冥冥中一种花香扑鼻,令人陶醉于心的静谧,不禁回忆,我们相遇的那一季正是盛夏之花烂漫时...</p>
</header>
<!--nav begin-->
<div id="nav">
  <ul>
    <li><a href="/blog">首页</a></li>
    <li><a href="#">关于我</a></li>
    <li><a href="#">慢生活</a></li>
    <li><a href="#">学习中</a></li>
    <li><a href="#">留言板</a></li>
  </ul>
</div>
<!--nav end-->
<div class="blank"></div>
<div class="banner">
  <ul class="boy_girl">
    <li class="boyimg"><a href="http://user.qzone.qq.com/339194758/main"><span>关于他</span></a></li>
    <li class="girlimg"><a href="http://user.qzone.qq.com/379060847/main"><span>关于我</span></a></li>
  </ul>
  <ul class="texts">
    <p><img src="<%=contextUrl%>/images/t-1.png" alt="人生，是一场盛大的遇见"></p>
    <p><img src="<%=contextUrl%>/images/t-2.png" alt="若你懂得，就请珍惜。"></p>
    <p><img src="<%=contextUrl%>/images/t-3.png" alt="无论下多久的雨，最后都会有彩虹；无论你多么悲伤，要相信幸福在前方等候"></p>
  </ul>
</div>
<div id="title" style="height:3%;width:100%;border:1px;text-align:center;">
    ${article.article_name}
</div> </br>
<div id="content" style="height:90%;width:100%;border:1px;text-align:center;">
    ${article.content}
</div>
</body>
</html>