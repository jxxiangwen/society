<%@page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <%--<nav class="navbar navbar-inverse" role="navigation">--%>
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#example-navbar-collapse">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <img src="/image/logo.jpg">
            <%--<a class="navbar-brand" href="#">W3Cschool</a>--%>
        </div>
        <div>
            <div class="collapse navbar-collapse" id="example-navbar-collapse">
                <ul class="nav navbar-nav">
                    <%--<li class="navbar-brand"><a href="http://cms.shu.edu.cn/Default.aspx?tabid=35557">首页</a></li>--%>
                    <c:choose>
                        <c:when test="${null ne session.user}">
                            <li class="dropdownc navbar-brand">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown">
                                    欢迎您，${sesson.user.userName} <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="navbar-brand"><a href="/user/logout">注销</a></li>
                                </ul>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="navbar-brand"><a href="/user/login">请登录</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </div>
</nav>
