<%@ page import="java.text.SimpleDateFormat" %>
<%@page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
    <div class="container-fluid">
        <div class="row">
            <jsp:include page="../left.jsp"/>
            <div class="col-md-9">
                <table class="table">
                    <thead>
                    <tr>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>学院</th>
                        <th>专业</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:choose>
                        <c:when test="${null ne pageInfo.list and 0 ne pageInfo.list.size()}">
                            <c:forEach var="list" items="${pageInfo.list}">
                                <tr>
                                    <td>${list.userId}</td>
                                    <td>${list.userName}</td>
                                    <td>${list.college}</td>
                                    <td>${list.major}</td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            暂时没有投票
                        </c:otherwise>
                    </c:choose>
                    </tbody>
                </table>
                <div id="page" style="text-align:center">

                </div>
                <script>
                    //好像很实用的样子，后端的同学再也不用写分页逻辑了。
                    laypage({
                        cont: $('#page'),
                        pages: ${pageInfo.pages}, //可以叫服务端把总页数放在某一个隐藏域，再获取。假设我们获取到的是18
                        curr: ${pageInfo.pageNum},
                        jump: function (e, first) { //触发分页后的回调
                            if (!first) { //一定要加此判断，否则初始时会无限刷新
                                location.href = '<%=basePath %>admin/user/page/' + e.curr;
                            }
                        },
                        skin: 'molv', //皮肤
                        first: ${pageInfo.firstPage}, //将首页显示为数字1,。若不显示，设置false即可
                        last: ${pageInfo.lastPage}, //将尾页显示为总页数。若不显示，设置false即可
                        prev: '<', //若不显示，设置false即可
                        next: '>' //若不显示，设置false即可
                    });
                </script>
            </div>
        </div>
    </div>
</div>
