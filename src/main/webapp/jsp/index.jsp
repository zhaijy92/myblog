<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.zjy.utils.SystemProp"%>
<%
    String contextUrl = SystemProp.getPropertyByName("contextUrl");

%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>ZZ_HOMEのYing</title>
<meta name="Keywords" content="博客模板,情侣博客模板" >
<meta name="Description" content="情侣博客模板" >
<link href="<%=contextUrl%>/css/index.css" rel="stylesheet">
<!--[if lt IE 9]><-->
<script type="text/javascript" src="<%=contextUrl%>/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=contextUrl%>/js/share.js"></script>
<script type="text/javascript" src="<%=contextUrl%>/js/blog/modernizr.js"></script>
<script type="text/javascript" src="<%=contextUrl%>/js/blog/index.js"></script>
<script>
	var contextUrl = "<%=contextUrl%>";
</script>
<script type="text/javascript">window.onload=girl;</script>
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
<div class="blank"></div>
<div class="memorial_day">
  <div class="time_axis"></div>
  <ul>
    <li class="n1"><a href="/">相遇</a>
      <div class="dateview">2004-03-01</div>
    </li>
    <li class="n2"><a href="/">相知</a>
      <div class="dateview">2005-04-07</div>
    </li>
    <li class="n3"><a href="/">在一起</a>
      <div class="dateview">2012-08-23</div>
    </li>
    <li class="n4"><a href="/">领证</a>
      <div class="dateview">2014-01-03</div>
    </li>
    <li class="n5"><a href="/">婚啦</a>
      <div class="dateview">2015-10-03</div>
    </li>
  </ul>
</div>
<div class="blank"></div>
<article>
  <div class="l_box">
    <div class="about_me">
      <h2>关于我</h2>
      <ul>
        <img src="<%=contextUrl%>/images/girl.jpg">
        <p>网名：万人疼</p>
        <p>主页：379060847@qq.com</p>
        <p>职业：java开发，前端初学者</p>
      </ul>
    </div>
    <div class="about_he">
      <h2>关于他</h2>
      <ul>
        <img src="<%=contextUrl%>/images/boy.jpg">
        <p>网名：. </p>
        <p>主页：339194758@qq.com</p>
        <p>职业：靠谱java开发</p>
      </ul>
    </div>
    <div class="newslist">
      <h2>最新日志</h2>
      <ul id="newslistUl">
      
      </ul>
    </div>
    <div class="viny">
      <ul>
        <dl>
          <dt class="art"><img src="<%=contextUrl%>/images/artwork.png" alt="专辑"></dt>
          <dd class="icon-song"><span></span>走样</dd>
          <dd class="icon-artist"><span></span>歌手：张宇</dd>
          <dd class="icon-album"><span></span>专辑：《走样》</dd>
          <dd class="music">
            <audio autoplay  loop src="<%=contextUrl%>/images/zy_zy.mp3" controls></audio>
          </dd>
          <!--添加autoplay属性 页面加载完即播放音频;添加loop属性 音频加载到末尾时，会重新播放-->
        </dl>
      </ul>
    </div>
  </div>
  <!--l_box end -->
  <div class="r_box">
    <li> <a href="/"><img src="<%=contextUrl%>/images/01.jpg"></a>
      <h3><a href="/">你是什么人便会遇上什么人</a></h3>
      <p>有时就为了一句狠话，像心头一口毒钉，永远麻�w着亲密感情交流。恶言，真要慎出，平日多�\心爱语，乃最简易之�咽�。</p>
    </li>
    <li> <a href="/"><img src="<%=contextUrl%>/images/02.jpg"></a>
      <h3><a href="/">爱情没有永远，地老天荒也走不完</a></h3>
      <p>也许，爱情没有永远，地老天荒也走不完，生命终结的末端，苦短情长。站在岁月的边端，那些美丽的定格，心伤的绝恋，都被四季的掩埋，一去不返。徒剩下这荒芜的花好月圆，一路相随，流离天涯背负了谁的思念？</p>
    </li>
    <li> <a href="/"><img src="<%=contextUrl%>/images/03.jpg"></a>
      <h3><a href="/">女孩都有浪漫的小情怀――浪漫的求婚词</a></h3>
      <p>还在为浪漫的求婚词而烦恼不知道该怎么说吗？女孩子都有着浪漫的小情怀，对于求婚更是抱着满满的浪漫期待，也希望在求婚那一天对方可以给自己一个最浪漫的求婚词。</p>
    </li>
    <li> <a href="/"><img src="<%=contextUrl%>/images/04.jpg"></a>
      <h3><a href="/">擦肩而过</a></h3>
      <p>《擦肩而过》文/清河鱼 编绘/天朝羽打开一扇窗，我不曾把你想得平常。看季节一一过往。你停留的那个地方，是否依然花儿开放？在夜里守靠着梦中的，想那仿佛前世铭刻进心肠的</p>
    </li>
    <li> <a href="/"><img src="<%=contextUrl%>/images/01.jpg"></a>
      <h3><a href="/">擦肩而过</a></h3>
      <p>《擦肩而过》文/清河鱼 编绘/天朝羽打开一扇窗，我不曾把你想得平常。看季节一一过往。你停留的那个地方，是否依然花儿开放？在夜里守靠着梦中的，想那仿佛前世铭刻进心肠的</p>
    </li>
  </div>
</article>
<footer>
  <p>Design by DanceSmile</p>
</footer>
</body>
</html>
