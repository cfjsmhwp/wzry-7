<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>王者荣耀论坛</title>
    <link rel="stylesheet" href="../css/common.css"/>
    <link rel="stylesheet" href="../css/common-new.css"/>
    <link rel="stylesheet" href="../css/index.css"/>
    <link rel="stylesheet" href="../css/search.css"/>
    <link rel="stylesheet" href="../css/index-new.css"/>
    <script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="../js/hm-bbs.js"></script>
</head>
<body>
<!-- 头部 -->
<div class="hm-top-nav">
    <div class="hm-inner clearfix">
        <div class="hm-inner-l l"></div>
        <div class="hm-inner-r r">
            <div class="box">
                <a href="javascript:;" id="login" class="to-login">游客登录</a>
                <a href="register.html">【新用户注册】</a>
                <div id="dialogBg"></div>
                <div id="dialog" class="animated">
                    <img class="dialogIco" width="50" height="40" src="../images/ico.png"/>
                    <div class="dialogTop" style="height:25px;">
                        <a href="javascript:;" class="closeDialogBtn">关闭</a>
                    </div>
                    <form action="user/login.do" >
                        <ul class="editInfos">
                            <li>用户名：<input type="text" id="userName" name="userName" class="ipt"/></li>
                            <li>密&nbsp;&nbsp;&nbsp;码：<input type="password" id="userPass" name="userPass" class="ipt"/></li>
                            <li><input type="submit" value="登录" class="submitBtn"/></li>
                        </ul>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- 主体部分 -->
<div class="hm-header"></div>
<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="hm-banner"></div>




        <!--头部，帖子统计，搜索-->
        <div class="hm-bbs-info">
            <div class="hm-bbs-icon l" style="width:130px;">
                <span><img src="../images/bbs-icon.png" height="80"/></span>
            </div>
            <div class="hm-bbs-info-in l" style="margin-left:30px;">
                <div class="t clearfix"><h2 class="l">王者荣耀</h2></div>
                <p>
                    <span>今日帖子<strong>${articleCountToday}</strong></span>
                    <span>全部帖子<strong>${allArticleCount}</strong></span>
                </p>
            </div>
            <div class="search-box l">
                <form action="${pageContext.request.contextPath}/article/findAll.do">
                    <input type="text" class="txt l" placeholder="请输入关键字" name="condition">
                    <input type="submit" value="搜索" class="btn l"/>
                </form>
            </div>
        </div>




        <!-- 导航 -->
        <ul class="hm-bbs-nav border-lrb clearfix">

            <c:forEach items="${zoneList}" var="zone" varStatus="vs">
                <c:if test="${zone.zoneId == vs.index}">
                    <li class="current">
                </c:if>
                <c:if test="${zone.zoneId != vs.index}">
                    <li>
                </c:if>
                    <a href="${pageContext.request.contextPath}/article/findAll.do?zoneId=${zone.zoneId}"><em></em>${zone.zoneName}</a>
                </li>
            </c:forEach>

        </ul>




        <!-- 主体部分 -->
        <div class="hm-bbs-main border-lrb clearfix">
            <!-- 左侧列表 -->
            <div class="list-view l">
                <ul>

                    <c:forEach items="${articleList}" var="article">
                        <c:if test="${article.isTop==1}">
                            <li class="clearfix ding">
                        </c:if>
                        <c:if test="${article.isTop==0}">
                            <li class="clearfix">
                        </c:if>
                            <div class="hm-index-title"><i class="set-to-top">顶</i>
                                <a href="${pageContext.request.contextPath}/article/getArticle.do?articleId=${article.articleId}">${article.title}</a>
                            </div>
                            <div class="hm-index-con">${article.content}</div>
                            <div class="hm-index-info l">
                                <span class="article-username">${article.senderName}</span>
                                <span class="post-time">${article.sendTimeStr}</span>
                            </div>
                            <div class="hm-index-fun r">
                                <span class="icon-like"><i></i>${article.upvoteCount}</span>
                                <span class="icon-talk"><i></i>${article.browseCount}</span>
                            </div>
                        </li>
                    </c:forEach>

                </ul>
            </div>




            <!-- 右侧侧边栏,在线用户 -->
            <div class="aside l">
                <div class="aside-box">
                    <h3 class="t">
                        <a href="javascript:;">${onlineUserCount}</a>
                    </h3>
                    <ul class="b clearfix">
                        <c:forEach items="${onlineUserNames}" var="onlineUserName">
                            <li>
                                <div><img src="../images/default.png" height="55"/> </div>
                                <p>${onlineUserName}</p>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>



        </div>
    </div>
</div>


<!-- 底部 -->
<div class="hm-footer" style="padding-top:10px;">
    <div class="hm-inner">
        <div class="hm-footer-cpr">
            <p>Copyright@2006-2017 ITCAST. All Rights Reserved</p>
            <p>传智播客 版权所有</p>
        </div>
    </div>
</div>

<!-- 右边发帖，回顶部 -->
<div class="fixedBar" id="j_fixedBar">
    <a id="newTopicBtn" href="javascript:;" class="newTopic"><span></span>发帖</a>
    <a href="#" class="goTop"><i></i><span>返回<br/>顶部</span></a>
</div>

<!-- 发帖弹出框 -->
<form action="" method="post">
    <div class="pop-box ft-box">
        <div class="mask"></div>
        <div class="win">
            <div class="win_hd">
                <h4 class="l">主题帖</h4><span class="close r">&times;</span>
            </div>
            <div class="win_bd">
                <div class="win_bd_t">
                    <input type="text" id="title" name="title" placeholder="帖子标题"/>
                </div>
                <div class="win_bd_b">
                    <textarea id="content" name="content" placeholder="正文"></textarea>
                </div>
            </div>
            <div class="win_ft">
                <div class="win_ft_in">
                    <input type="submit" class="btn" value="发表"/>
                </div>
            </div>
        </div>
    </div>
</form>


</body>
</html>
<script type="text/javascript">
  $(function () {
      //显示弹框
      $('.box #login').click(function () {
          var className = $(this).attr('class');
          $('#dialogBg').fadeIn(300);
          $('#dialog').removeAttr('class').addClass('animated ' + className + '').fadeIn();
          $('#userName').focus();
          $("#j_fixedBar").hide();
      });

      //关闭弹窗
      $('.closeDialogBtn').click(function () {
          $('#dialogBg').fadeOut(300, function () {
              $('#dialog').addClass('bounceOutUp').fadeOut();
              $("#j_fixedBar").show();
          });
      });

      //查询用户是否登录
      $.post("user/findUser.do",{},function(data){

          alert(data);
      })
  });
</script>