<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
            <c:if test="${empty user}">
            <div class="box">
                <a href="javascript:;" id="login" class="to-login">游客登录</a>
                <a href="register.do">【新用户注册】</a>
                <div id="dialogBg"></div>
                <div id="dialog" class="animated">
                    <img class="dialogIco" width="50" height="40" src="/images/ico.png"/>
                    <div class="dialogTop" style="height:25px;">
                        <a href="javascript:;" class="closeDialogBtn">关闭</a>
                    </div>
                    <form id="pwdLoginForm" action="#">
                        <ul class="editInfos">
                            <li>用户名：<input type="text" id="userName" name="userName" class="ipt"/></li>
                            <li>密&nbsp;&nbsp;&nbsp;码：<input type="password" id="userPass" name="userPass" class="ipt"/></li>
                            <li><input id="login_btn" type="submit" value="登录"  /></li>
                        </ul>
                    </form>
                </div>
            </div>
            </c:if>

            <c:if test="${not empty user}">
                <div class="box">
                    <span>欢迎&nbsp;&nbsp;&nbsp;</span>
                    <c:if test="${user.role==1}">普通用户:</c:if>
                    <c:if test="${user.role==2}">高级用户:</c:if>
                    <c:if test="${user.role==3}">超级管理员:</c:if>
                    <span>${user.userName}&nbsp;&nbsp;&nbsp;</span>
                    <a href="/jsp/userInfo.jsp">个人中心&nbsp;&nbsp;&nbsp;</a>
                    <a href="javascript:logout()">注销</a>
                </div>
            </c:if>

        </div>
    </div>
</div>
</body>
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

      //用户退出操作
      function logout(){
          if(confirm("确定要注销吗?")){
              location.href="${pageContext.request.contextPath}/user/logout";
          }
      }

      //用户登录验证
      $("#login_btn").click(function () {
          if ($("#userName").val()&&$("#userPass").val()){
              $.post("${pageContext.request.contextPath}/user/login",$("#pwdLoginForm").serialize(),
                  function (data) {
                  if (data.toString()=="true"){
                      location.reload();
                  }
              })
          }
      });


     <%--$("#login_btn").click(function(){--%>
          <%--//判断用户名和密码不为空的时候发送ajax请求--%>
          <%--if($("[name='userName']").val()&&$("[name='userPass']").val()){--%>
              <%--$.post("${pageContext.request.contextPath}/user/login",$("#pwdLoginForm").serialize(),function(data){--%>
                  <%--//若登录成功,刷新页面--%>
                  <%--if(data=='success'){--%>
                      <%--location.reload();--%>
                  <%--}--%>
              <%--},"json");--%>
          <%--}--%>
      <%--});--%>

  });
</script>
</html>