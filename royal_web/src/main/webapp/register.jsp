<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>王者荣耀论坛注册页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common-new.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
</head>
<body>


<!-- 头部 -->
<jsp:include page="WEB-INF/jsp/common/header.jsp"/>


<div class="hm-header">
    <div class="hm-inner clearfix">
        <div class="hm-header-t clearfix">
            <h1 class="logo l">
                <a href="javascript:;"><img src="images/logo.png" height="64" width="168" alt=""/></a>
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
            <a href="index.jsp">首页</a><span>></span>注册页面
        </div>
    </div>
</div>


<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="reg-box">
            <h2>用户注册<span>（红色型号代表必填）</span></h2>
            <div class="reg-info">
                <form action="${pageContext.request.contextPath}/user/register.do" method="post"
                      onsubmit="return check()">
                    <ul>
                        <li>
                            <div class="reg-l">
                                <span class="red">*</span> 用户名：
                            </div>
                            <div class="reg-c">
                                <input type="text" id="registUserName" name="userName" class="txt" value=""/>
                            </div>
                            <span class="tips">用户名必须是由英文、数字、下划线组成</span>
                        </li>
                        <li>
                            <div class="reg-l">
                                <span class="red">*</span> 密&nbsp;&nbsp;&nbsp;码：
                            </div>
                            <div class="reg-c">
                                <input type="password" id="registUserPass" name="userPass" class="txt" value=""/>
                            </div>
                            <span class="tips">密码长度必须6~10位的英文或数字</span>
                        </li>
                        <li class="no-tips">
                            <div class="reg-l">
                                <span class="red">*</span>&nbsp;&nbsp;邮&nbsp;&nbsp;&nbsp;箱：
                            </div>
                            <div class="reg-c">
                                <input type="text" id="email" name="email" class="txt" value=""/>
                            </div>
                        </li>
                        <li>
                            <div class="reg-l"></div>
                            <div class="reg-c">
                                <input type="submit" class="submit-btn" value="注册"/>
                            </div>
                            <span id="userInfo" class="reg-r"></span>
                        </li>
                    </ul>
                </form>
            </div>
        </div>
    </div>
</div>


<!-- 底部 -->
<jsp:include page="WEB-INF/jsp/common/footer.jsp"/>

<script>
    var flag1 = false;
    var flag2 = false;
    var flag3 = false;

    $(function () {

        //用户名验证
        $("#registUserName").blur(function () {
            var userName = $(this).val();
            // alert(userName)
            if (userName.length<1) {
                $("#userInfo").html("用户名必填!");
                flag1 = false;
            } else {
                var reg = /^[a-z0-9A-Z]+$/;
                if (!reg.test(userName)) {
                    $("#userInfo").html("用户名不符合规则，请重新输入!");
                    flag1 = false;
                } else {
                    $.post("${pageContext.request.contextPath}/user/findByUsername.do", {"userName": userName}, function (data) {
                        if (data) {
                            $("#userInfo").html("用户名可用！");
                            flag1 = true;
                        } else {
                            $("#userInfo").html("用户名已被占用，请重新输入!");
                            flag1 = false;
                        }
                    }, "json")
                }
            }
        });

        //密码验证
        $("#registUserPass").blur(function () {
            var userPass = $(this).val();
            // alert(userPass)
            if (userPass.length > 5 && userPass.length < 11) {
                var reg = /^[a-z0-9A-Z]{6,10}$/;
                if (!reg.test(userPass)) {
                    $("#userInfo").html("密码不符合规则，请重新输入!");
                    flag2 = false;
                } else {
                    $("#userInfo").html("");
                    flag2 = true;
                }
            } else {
                $("#userInfo").html("密码必须在6-10位之间，请重新输入!");
                flag2 = false;
            }
        });

        //邮箱验证
        $("#email").blur(function () {
            var email = $(this).val();
            // alert(email)
            if (email.length < 1) {
                $("#userInfo").html("邮箱不能为空，请重新输入！");
                flag3 = false;
            } else {
                var reg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
                if (!reg.test(email)) {
                    $("#userInfo").html("请输入正确的邮箱格式!");
                    flag3 = false;
                } else {
                    $("#userInfo").html("");
                    flag3 = true;
                }
            }
        });


    });


    function check() {
        return flag1 && flag2 && flag3;
    }


</script>


</body>
</html>