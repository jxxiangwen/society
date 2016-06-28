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
            <div class="col-xs-6">
                <c:choose>
                    <c:when test="${null ne voteList and 0 ne voteList.size()}">
                        <ul class="list-group">
                            <c:forEach var="list" items="${voteList}">
                                <li class="list-group-item">
                                    <a href="vote/name/<c:out value="${list.id}"/>"><c:out value="${list.title}"/></a>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        暂时没有投票
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>
