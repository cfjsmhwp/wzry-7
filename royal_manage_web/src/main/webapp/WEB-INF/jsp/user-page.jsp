<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理页面</title>

</head>
<style type="text/css">
    html,body{
        overflow:auto;
        height:100%;
    }

    .line-limit-length {
        max-width: 220px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }


</style>
<script>

</script>
<body>
<div class="hrms_dept_container">
    <!-- 导航栏-->
    <%@ include file="../../jsp/commom/head.jsp"%>


    <!-- 中间部分（左侧栏+表格内容） -->
    <div class="hrms_dept_body">
        <!-- 左侧栏 -->
        <%@ include file="../../jsp/commom/leftsidebar.jsp"%>

        <!-- 表格内容 -->
        <div class="dept_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div >
                    <ol class="breadcrumb">
                        <li><a href="#">用户管理</a></li>
                        <li class="active">用户信息</li>
                    </ol>
                </div>
                <hr>
                <!-- Table -->
                <div>
                    <div style="float: left">
                        <form method="get" id="articleSearchForm">
                            <table>
                                <tr>
                                    <th>
                                        <label for="title" class="control-label">用户名:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="title" class="form-control"
                                               name="title" value="">
                                        <input type="hidden" id="pageNum" name="pn" value="">
                                    </th>
                                    <th>
                                        <label for="article_sendername" class="control-label">用户组:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="article_sendername" class="form-control"
                                               name="sendername" value="">
                                    </th>
                                    <th colspan="2">
                                        <input type="button" value="查询" class="form-control btn-primary">
                                    </th>
                                </tr>
                            </table>

                        </form>
                    </div>
                </div>
                <div style="clear:both"></div>
                <hr>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>用户名</th>
                        <th>用户组</th>
                        <th>邮箱</th>
                        <th>是否禁言</th>
                        <th>最近登录时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${pageInfo.list}" var="user">

                            <tr>
                                <td width="15%">${user.userName}</td>
                                <td width="15%" class="line-limit-length">${user.roleStr}

                                </td>
                                <td width="15%" class="line-limit-length">${user.email}

                                </td>
                                <td width="15%" class="line-limit-length">${user.talkStatusStr}

                                </td>
                                <td width="15%">${user.lastLoginTimeStr}

                                </td>



                                <td width="15%">
                                    <a href="/article/deleteArticle.do?id=${article.articleid}&pn=${articleMsgs.pageNum}&title=${articleSearch.title}&sendername=${articleSearch.sendername}" role="button" class="btn btn-primary">升级</a>
                                    <a href="/article/deleteArticle.do?id=${article.articleid}&pn=${articleMsgs.pageNum}&title=${articleSearch.title}&sendername=${articleSearch.sendername}" role="button" class="btn btn-danger danger">禁言</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>


            </div><!-- /.panel panel-success -->
            <!--显示分页信息-->
            <%--<div class="box-footer">--%>
                <%--<div class="pull-left">--%>
                    <%--<div class="form-group form-inline">--%>
                        <%--总共2 页，共14 条数据。 每页--%>
                        <%--<select class="form-control" id="changePageSize" onchange="changePageSize()">--%>
                            <%--<option>1</option>--%>
                            <%--<option>2</option>--%>
                            <%--<option>3</option>--%>
                            <%--<option>4</option>--%>
                            <%--<option>5</option>--%>
                        <%--</select> 条--%>
                    <%--</div>--%>
                <%--</div>--%>
            <div class="row">
                <!--文字信息-->
                <div class="col-md-6">
                    当前第 ${pageInfo.pageNum} 页.总共 ${pageInfo.pages} 页.一共 ${pageInfo.total} 条记录
                </div>

                <!--点击分页-->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <!--首页-->
                            <li><a href="${pageContext.request.contextPath}/user/findByPage.do?page=1&size=${pageInfo.pageSize}" aria-label="Previous">首页</a></li>
                            <!--上一页-->
                            <li><a href="${pageContext.request.contextPath}/user/findByPage.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a></li>


                            <c:forEach begin="1" end="${pageInfo.pages}" var="page_num">
                                <li><a href="${pageContext.request.contextPath}/user/findByPage.do?page=${pageInfo.pageNum}&size=${pageInfo.pageSize}">${pageInfo.pageNum}</a></li>

                            </c:forEach>

                            <!--下一页-->
                            <li><a href="${pageContext.request.contextPath}/user/findByPage.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}" >下一页</a></li>

                            <li><a href="${pageContext.request.contextPath}/user/findByPage.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}" aria-label="Previous" >尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div><!-- /.dept_info -->

        <script>
            function changePageSize() {
                //获取下拉框的值
                var pageSize = $("#changePageSize").val();

                //向服务器发送请求，改变没页显示条数
                location.href = "${pageContext.request.contextPath}/user/findAll.do?page=1&size="
                    + pageSize;
            }
            $(document).ready(function() {
                // 选择框
                $(".select2").select2();

                // WYSIHTML5编辑器
                $(".textarea").wysihtml5({
                    locale : 'zh-CN'
                });
            });

            // 设置激活菜单
            function setSidebarActive(tagUri) {
                var liObj = $("#" + tagUri);
                if (liObj.length > 0) {
                    liObj.parent().parent().addClass("active");
                    liObj.addClass("active");
                }
            }

            $(document).ready(function() {

                // 激活导航位置
                setSidebarActive("admin-datalist");

                // 列表按钮
                $("#dataList td input[type='checkbox']").iCheck({
                    checkboxClass : 'icheckbox_square-blue',
                    increaseArea : '20%'
                });
                // 全选操作
                $("#selall").click(function() {
                    var clicks = $(this).is(':checked');
                    if (!clicks) {
                        $("#dataList td input[type='checkbox']").iCheck("uncheck");
                    } else {
                        $("#dataList td input[type='checkbox']").iCheck("check");
                    }
                    $(this).data("clicks", !clicks);
                });
            });
        </script>
        <!-- 尾部-->
        <%@ include file="../../jsp/commom/foot.jsp"%>
    </div><!-- /.hrms_dept_body -->

</div><!-- /.hrms_dept_container -->

<%--<%@ include file="ArticleAdd.jsp"%>--%>
</body>
</html>
