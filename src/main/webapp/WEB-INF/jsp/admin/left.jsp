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
                        投票管理<b class="caret"></b>
                    </a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in">
                <ul class="list-group">
                    <li class="list-group-item"><a href="/admin/vote/type/get">投票类别管理</a></li>
                    <li class="list-group-item"><a href="/admin/topic/check/page/1">投票管理</a></li>
                    <%--<li class="list-group-item"><a href="/admin/vote/result">导出投票结果</a></li>--%>
                </ul>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a href="/admin/messageType/list">
                        留言管理
                    </a>
                </h4>
            </div>
        </div>
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
        <%--<div class="panel panel-default">--%>
            <%--<div class="panel-heading">--%>
                <%--<h4 class="panel-title">--%>
                    <%--<a data-toggle="collapse" data-parent="#accordion"--%>
                       <%--href="#collapseFour">--%>
                        <%--用户管理<b class="caret"></b>--%>
                    <%--</a>--%>
                <%--</h4>--%>
            <%--</div>--%>
            <%--<div id="collapseFour" class="panel-collapse collapse">--%>
                <%--<ul class="list-group">--%>
                    <%--<li class="list-group-item"><a href="/admin/user/upload">导入用户</a></li>--%>
                    <%--<li class="list-group-item"><a href="/admin/user/page/1">查看用户</a></li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        <%--</div>--%>
    </div>
</div>