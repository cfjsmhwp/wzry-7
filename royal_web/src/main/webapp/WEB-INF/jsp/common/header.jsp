<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户登录</title>
</head>
<body>
<div class="hm-top-nav">
    <div class="hm-inner clearfix">
        <div class="hm-inner-l l"></div>
        <div class="hm-inner-r r">
            <div class="box">
                <c:if test="${empty loginUser}">
                    <a href="javascipt:;" id="login" class="to-login">用户登录</a>
                    <a href="${pageContext.request.contextPath}/register.jsp">【新用户注册】</a>
                </c:if>
                <c:if test="${not empty loginUser && loginUser.role==1}">
                    <a href="javascipt:;" id="login" class="to-login">欢迎 普通用户：${loginUser.userName}</a>
                    <a href="${pageContext.request.contextPath}/user/getUser.do?method=userInfo">个人中心</a>
                    <a href="${pageContext.request.contextPath}/user/logout.do">注销</a>
                </c:if>
                <c:if test="${not empty loginUser && loginUser.role==2}">
                    <a href="javascipt:;" id="login" class="to-login">欢迎 高级用户：${loginUser.userName}</a>
                    <a href="${pageContext.request.contextPath}/user/getUser.do?method=userInfo">个人中心</a>
                    <a href="${pageContext.request.contextPath}/user/logout.do">注销</a>
                </c:if>
                <c:if test="${not empty loginUser && loginUser.role==3}">
                    <a href="javascipt:;" id="login" class="to-login">欢迎 超级用户：${loginUser.userName}</a>
                    <a href="${pageContext.request.contextPath}/user/getUser.do?method=userInfo">个人中心</a>
                    <a href="${pageContext.request.contextPath}/user/logout.do">注销</a>
                </c:if>


                <div id="dialogBg"></div>
                <div id="dialog" class="animated">
                    <img class="dialogIco" width="50" height="40" src="../../../images/ico.png" />
                    <div class="dialogTop" style="height:25px;">
                        <a href="javascript:void(0);" class="closeDialogBtn">关闭</a>
                    </div>
                    <form action="#" method="post">
                        <ul class="editInfos">
                            <li>用户名：<input type="text" id="userName" name="userName" class="ipt"/></li>
                            <li>密&nbsp;&nbsp;&nbsp;码：<input type="password" id="userPass" name="userPass" class="ipt"/>
                            </li>
                            <li><input id="submit_btn" type="button" value="登录" class="submitBtn" onclick="checkUserInfo()"/></li>
                            <span id="loginInfo" class="red"></span>
                        </ul>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script type="text/javascript">

     function  checkUserInfo() {
         var userName = $("#userName").val();
         var userPass = $("#userPass").val();
         $.post("${pageContext.request.contextPath}/user/login.do", {
             "userName": userName,
             "userPass": userPass
         }, function (data) {
             if (data) {
                 window.location.replace("${pageContext.request.contextPath}/index.jsp");
             }else {
                 alert("用户名或密码错误,请重新输入!");
             }
         }, "json")
     };


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

    });
</script>
</html>