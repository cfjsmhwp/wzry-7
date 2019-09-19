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
                <a href="javascript:;"><img src="/images/logo.png" height="64" width="168" alt=""/></a>
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
            <a href="${pageContext.request.contextPath}/article/findAll.do">首页</a><span></span>个人信息
        </div>
    </div>
</div>



<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="user-info clearfix">
            <div class="user-info-t" style="height:20px;"></div>

            <!--左侧用户名，头像-->
            <div class="user-info-l l">
                <div class="user-info-l-t">
                    <img src="${pageContext.request.contextPath}/${loginUser.picUrl}"/>
                    <div class="username">${loginUser.userName}</div>
                </div>
                <ul class="user-info-l-b">
                    <li class="cur"><i class="info-icon"></i>我的资料</li>
                    <li><i class="safe-icon"></i>修改密码</li>
                </ul>
            </div>


            <!--右侧用户信息-->
            <div class="user-info-r r">
                <ul class="clearfix hd">
                    <li class="cur"><a href="${pageContext.request.contextPath}/user/getUser.do?method=userInfo">个人信息</a></li>
                    <li><a href="${pageContext.request.contextPath}/user/getUser.do?method=userPwd">修改密码</a></li>
                    <c:if test="${loginUser.role==1}"><li><a href="${pageContext.request.contextPath}/user/getUser.do?method=userUpgrade">申请高级用户</a></li></c:if>
                    <c:if test="${loginUser.role==2}"><li><a href="${pageContext.request.contextPath}/user/getUser.do?method=userZoneApply">开辟新版块</a></li></c:if>
                </ul>


                <form id="userInfoForm" action="#" method="post" enctype="multipart/form-data">
                    <ul class="bd">
                        <li class="clearfix">
                            <div class="info-l"><i class="red"></i>用户名：</div>
                            <div class="info-r"><input type="text" name="userName" value="${loginUser.userName}" class="txt" readonly="readonly"/></div>
                        </li>
                        <li class="clearfix">
                            <div class="info-l">邮箱地址：</div>
                            <div class="info-r"><input id="email" type="email" name="email" class="txt" /></div>
                        </li>email
                        <li class="clearfix">
                            <div class="info-l">上传头像：</div>
                            <div class="info-r"><input type="file" name="upload" class="file-btn"/></div>
                        </li>
                        <li class="clearfix">
                            <div class="info-l"></div>
                            <div class="info-r">
                                <input id="userInfo_btn" type="button" class="btn" value="保存"/>
                                <span id="successInfo" style="color:red;"></span>
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

    $(function () {

        $("#userInfo_btn").click(function () {
            var formData = new FormData($("#userInfoForm")[0]);
            $.ajax({
                url:'${pageContext.request.contextPath}/user/updateUserInfo.do',
                type:'POST',
                data:formData,
                dataType:'JSON',
                cache:false,
                processData:false,
                contentType:false,
                success:function(data) {
                    alert("上传成功");
                    $("#email").val("");

                }
            });
        })

    })
</script>


</body>
</html>