<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>黑马程序员论坛首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common-new.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user_info.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/hm-bbs.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/messages_zh.js"></script>
    <style type="text/css">
        .hm-header-b { border-bottom: 1px solid #d9d9d9; }
    </style>
</head>
<body>


<!-- 头部 -->
<jsp:include page="common/header.jsp" />



<!--头部信息-->
<div class="hm-header">
    <div class="hm-inner clearfix">
        <div class="hm-header-t clearfix">
            <h1 class="logo l">
                <a href="javascript:;"><img src="/images/logo.png" alt=""/></a>
            </h1>
            <div class="search-box l">
                <form action="javascript:;">
                    <input type="text" class="txt l" placeholder="请输入关键字">
                    <input type="button" value="搜索" class="btn l"/>
                </form>
            </div>
        </div>
        <div class="hm-header-b">
            <i class="hm-ico-home"></i>
            <a href="${pageContext.request.contextPath}/article/findAll.do">首页</a><span>></span>修改密码
        </div>
    </div>
</div>


<!--修改密码-->
<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="user-info clearfix">
            <div class="user-info-t" style="height:20px;"></div>
            <div class="user-info-l l">
                <div class="user-info-l-t">
                    <img src="${pageContext.request.contextPath}/${loginUser.picUrl}"/>
                    <div class="username">${loginUser.userName}</div>
                </div>
                <ul class="user-info-l-b">
                    <li><i class="info-icon"></i>我的资料</li>
                    <li class="cur"><i class="safe-icon"></i>修改密码</li>
                </ul>
            </div>


            <div class="user-info-r r">
                <ul class="clearfix hd">
                    <li><a href="${pageContext.request.contextPath}/user/getUser.do?method=userInfo">个人信息</a></li>
                    <li  class="cur"><a href="${pageContext.request.contextPath}/user/getUser.do?method=userPwd">修改密码</a></li>
                    <c:if test="${loginUser.role==1}"><li><a href="${pageContext.request.contextPath}/user/getUser.do?method=userUpgrade">申请高级用户</a></li></c:if>
                    <c:if test="${loginUser.role==2}"><li><a href="${pageContext.request.contextPath}/user/getUser.do?method=userZoneApply">开辟新版块</a></li></c:if>
                </ul>
                <form id="userPwdForm" action="#" method="post">
                  <ul class="bd">
                    <li class="clearfix">
                        <div class="info-l"><i class="red">*</i>旧密码：</div>
                        <div class="info-r"><input id="oldPassword" type="password" name="oldPassword" class="txt"/></div>
                        <div class="info-r"><input type="hidden" name="userName" value="${loginUser.userName}" class="txt"/></div>
                    </li>
                    <li class="clearfix">
                        <div class="info-l"><i class="red">*</i>新密码：</div>
                        <div class="info-r"><input id="newPassword" type="password" name="newPassword" class="txt"/></div>
                    </li>
                      <li class="clearfix">
                          <div class="info-l"><i class="red">*</i>确认密码：</div>
                          <div class="info-r"><input type="password" id="confirmPassword" class="txt"/>
                          <span id="message_pwd"></span>
                          </div>
                      </li>
                    <li class="clearfix">
                        <div class="info-l"></div>
                        <div class="info-r">
						  <input id="sub_btn" type="button" class="btn" value="保存"/>
						  <input type="reset" class="btn" value="重置"/>
						  <span style="color:red;"></span>
						</div>
                    </li>
                  </ul>
                </form>

            </div>
        </div>
    </div>
</div>

<!-- 底部 -->
<jsp:include page="common/footer.jsp"/>
<script>
    $(function(){


        $("#sub_btn").click(function () {
            if ($("#newPassword").val()!=$("#confirmPassword").val()) {

                $("#message_pwd").html("新密码2次输入不一致！重新输入")
            }else{
                $.post("${pageContext.request.contextPath}/user/updatePwd.do",$("#userPwdForm").serialize(),function (data) {
                    if(data.toString()=="true"){
                        alert("更新密码成功");
                        $("#oldPassword").val("");
                        $("#newPassword").val("");
                        $("#confirmPassword").val("");
                    }
                },'json')
            }
        })

        $("#confirmPassword").focus(function(){
            $("#message_pwd").html("");
        })

    })

</script>


</body>
</html>