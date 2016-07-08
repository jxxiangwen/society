<%@ page import="java.text.SimpleDateFormat" %>
<%@page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
    <div class="container-fluid" id="database">
        <div class="row">
            <jsp:include page="../../left.jsp"/>
            <div class="col-md-8">
                <table class="table">
                    <thead>
                    <tr>
                        <th>投票名称</th>
                        <th>发布时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        request.setAttribute("sdf", sdf); //request域
                    %>
                    <c:choose>
                        <c:when test="${null ne voteTopicList.list and 0 ne voteTopicList.list.size()}">
                            <c:forEach var="list" items="${voteTopicList.list}">
                                <tr>
                                    <td><a href="vote/topic/<c:out value="${list.id}"/>"><c:out
                                            value="${list.title}"/></a></td>
                                    <%--<td><fmt:formatNumber value="${list.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>--%>
                                    <%--<td><%=sdf.format(list.createTime)%></td>--%>
                                    <td><c:out value="${sdf.format(list.createTime)}"/></td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            暂时没有投票
                        </c:otherwise>
                    </c:choose>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
