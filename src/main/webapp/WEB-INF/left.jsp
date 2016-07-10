<%@page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-3">
    <div class="panel-group" id="accordion">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseOne">
                        投票<b class="caret"></b>
                    </a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in">
                <ul class="list-group">
                    <li class="list-group-item"><a href="/vote/topic/1/page/1">记名投票</a></li>
                    <li class="list-group-item"><a href="/vote/topic/2/page/1">不记名投票</a></li>
                </ul>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a href="/messageType/list">
                        留言
                    </a>
                </h4>
            </div>
            </div>
        <%--  <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseTwo">
                        留言<b class="caret"></b>
                    </a>
                </h4>
            </div>
          <div id="collapseTwo" class="panel-collapse collapse">

                <ul class="list-group">
                    <c:choose>
                    <c:when test="${null ne messageTypeList and 0 ne messageTypeList.size()}">
                    <c:forEach var="messageType" items="${messageTypeList}" varStatus="status">
                        <li class="list-group-item"><a
                                href="/message/list/${messageType.id}/page/${currPageNum}">${messageType.typeName}</a>
                        </li>
                    </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <li class="list-group-item">类别为空</a>
                        </li>
                    </c:otherwise>
                    </c:choose>
                    </ul>
                </ul>
            </div>


        </div>--%>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseThree">
                        活动<b class="caret"></b>
                    </a>
                </h4>
            </div>
            <div id="collapseThree" class="panel-collapse collapse">
                <ul class="list-group">
                    <li class="list-group-item"><a href="/vote/topic/2/page/1">活动</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>