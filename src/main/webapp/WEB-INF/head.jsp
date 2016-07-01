<%@page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <nav class="navbar navbar-inverse" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#example-navbar-collapse">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">W3Cschool</a>
        </div>
        <div>
            <div class="collapse navbar-collapse" id="example-navbar-collapse">
                <ul class="nav navbar-nav">
                    <li <c:if test="${0==nav}">class="active"</c:if>><a href="#">课外活动</a></li>
                    <li <c:if test="${1==nav}">class="active"</c:if>><a href="#">留言板</a></li>
                    <li class="dropdown <c:if test="${2==nav}">active</c:if>">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            投票 <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">记名投票</a></li>
                            <li><a href="#">不记名投票</a></li>
                            <%--<li class="divider"></li>--%>
                            <%--<li><a href="#">分离的链接</a></li>--%>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
