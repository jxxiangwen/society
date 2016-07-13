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
            <div class="col-md-9">
                <table class="table">
                    <thead>
                    <tr>
                        <th>留言类别</th>
                        <th>留言条数</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:choose>
                        <c:when test="${null ne messageTypeList and 0 ne messageTypeList.size()}">
                            <c:forEach var="list" items="${messageTypeList}">
                                <tr>
                                    <td><a href="/message/list/${list.id}/page/1">${list.typeName}</a></td>
                                    <td>${list.count}</td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            暂时没有留言
                        </c:otherwise>
                    </c:choose>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

