<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>帖信息管理页面</title>

</head>
<style type="text/css">
    html, body {
        overflow: auto;
        height: 100%;
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
    <%@ include file="../../jsp/commom/head.jsp" %>


    <!-- 中间部分（左侧栏+表格内容） -->
    <div class="hrms_dept_body">
        <!-- 左侧栏 -->
        <%@ include file="../../jsp/commom/leftsidebar.jsp" %>

        <!-- 表格内容 -->
        <div class="dept_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div>
                    <ol class="breadcrumb">
                        <li><a href="#">用户帖管理</a></li>
                        <li class="active">帖子信息</li>
                    </ol>
                </div>
                <hr>
                <!-- Table -->

                <div style="clear:both"></div>
                <hr>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>帖子ID</th>
                        <th>举报内容</th>
                        <th>举报人</th>
                        <th>举报时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pageInfo.list}" var="reportList">
                        <tr>
                            <td width="8%">${reportList.reportId}</td>
                            <td width="25%" class="line-limit-length">${reportList.reportContent}</td>
                            <td width="5%" class="line-limit-length">${reportList.reportTime}</td>
                            <td width="3%" class="line-limit-length">${reportList.reportUserName}</td>
                            <td width="10%" class="line-limit-length">
                                <a href="/report/deleteArticle.do?id=${article.articleId}&pn=${pageInfo.pageNum}&isTop=${article.isTop}&senderName=${article.senderName}&articleStatus=${article.articleStatus}&title="
                                   role="button" class="btn btn-primary">相关帖子</a>
                                <c:if test="${reportList.reportStatus==1}">
                                <a href="/report/deleteArticle.do?id=${reportList.articleId}&pn=${pageInfo.pageNum}&articleStatus=${reportList.reportStatus}"
                                </c:if>
                                <c:if test="${reportList.reportStatus==0}">
                                <a href="/report/deleteArticle.do?id=${reportList.articleId}&pn=${pageInfo.pageNum}&articleStatus=${reportList.reportStatus}"
                                </c:if>
                                   role="button" class="btn btn-success">显示</a>
                                <a href="/report/deleteArticle.do?id=${article.articleId}&pn=${pageInfo.pageNum}&isTop=${article.isTop}&senderName=${article.senderName}&articleStatus=${article.articleStatus}&title="
                                   role="button" class="btn btn-success">驳回</a>


                            </td>
                        </tr>
                    </c:forEach>


                    </tbody>
                </table>


            </div><!-- /.panel panel-success -->
            <!--显示分页信息-->
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
                            <li><a href="#" onclick="searchArticle(1)">首页</a></li>
                            <!--上一页-->
                            <li>
                                <c:if test="${pageInfo.hasPreviousPage}">
                                    <a href="#" onclick="searchArticle('${pageInfo.pageNum-1}')"
                                       aria-label="Previous">
                                        <span aria-hidden="true">«</span>
                                    </a>
                                </c:if>
                            </li>

                            <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
                                <c:if test="${page_num == pageInfo.pageNum}">
                                    <li class="active"><a href="#">${page_num}</a></li>
                                </c:if>
                                <c:if test="${page_num != pageInfo.pageNum}">
                                    <li><a href="#" onclick="searchArticle('${page_num}','${pageInfo.pageSize}')">${page_num}</a></li>
                                </c:if>
                            </c:forEach>

                            <!--下一页-->
                            <li>
                                <c:if test="${pageInfo.hasNextPage}">
                                    <a href="javascript:void(0)" onclick="searchArticle('${pageInfo.pageNum+1}')"
                                       aria-label="Next">
                                        <span aria-hidden="true">»</span>
                                    </a>
                                </c:if>
                            </li>
                            <li><a href="javascript:void(0)" onclick="searchArticle('${pageInfo.pages}')">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div><!-- /.dept_info -->
        <!-- 尾部-->
        <%@ include file="../../jsp/commom/foot.jsp" %>
    </div><!-- /.hrms_dept_body -->

</div><!-- /.hrms_dept_container -->

<%--<%@ include file="ArticleAdd.jsp"%>
<%@ include file="ArticleUpdate.jsp"%>--%>
</body>
<script>
    function searchArticle(page) {
        location.href="${pageContext.request.contextPath}/article/findByPage.do?page="+page;
    }
</script>
</html>
