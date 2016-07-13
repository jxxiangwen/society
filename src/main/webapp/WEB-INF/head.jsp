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
            <%--<a href="#">W3Cschool</a>--%>
        </div>
        <div>
            <div class="collapse navbar-collapse" id="example-navbar-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="http://cms.shu.edu.cn/Default.aspx?tabid=35557">首页</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown">
                            学院概况 <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="http://cms.shu.edu.cn/Default.aspx?tabid=35640">学院简介</a>
                            </li>
                            <li><a href="http://cms.shu.edu.cn/Default.aspx?tabid=35641">学院领导</a>
                            </li>
                            <li><a href="http://cms.shu.edu.cn/Default.aspx?tabid=35642">院徽院训</a>
                            </li>
                        </ul>
                    </li>
                    <li><a href="http://cms.shu.edu.cn/Default.aspx?tabid=35644">组织架构</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown">
                            导师团队 <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a
                                    href="http://cms.shu.edu.cn/Default.aspx?tabid=35710">课外培养中心导师</a></li>
                            <li><a href="http://cms.shu.edu.cn/Default.aspx?tabid=35711">科创导师</a>
                            </li>
                            <li><a href="http://cms.shu.edu.cn/Default.aspx?tabid=35712">理工一组导师</a>
                            </li>
                            <li><a href="http://cms.shu.edu.cn/Default.aspx?tabid=35713">理工二组导师</a>
                            </li>
                            <li><a href="http://cms.shu.edu.cn/Default.aspx?tabid=35714">理工三组导师</a>
                            </li>
                            <li><a
                                    href="http://cms.shu.edu.cn/Default.aspx?tabid=35715">人文经管组导师</a></li>
                        </ul>
                    </li>
                    <li class="dropdownc">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown">
                            课程导航 <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="http://cms.shu.edu.cn/Default.aspx?tabid=35702">核心通知课</a>
                            </li>
                            <li><a href="http://cms.shu.edu.cn/Default.aspx?tabid=35703">培养方案</a>
                            </li>
                            <li><a href="http://poll.freshman.shu.edu.cn/">评价方案</a></li>
                        </ul>
                    </li>
                    <li><a href="http://cms.shu.edu.cn/Default.aspx?tabid=35648">相关下载</a></li>
                    <c:choose>
                        <c:when test="${null ne sessionScope.user}">
                            <li class="dropdownc">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown">
                                    欢迎您，${sessionScope.user.userName} <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a href="/user/logout">注销</a></li>
                                    <li>
                                    <li class="dropdownc">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"
                                           data-hover="dropdown">
                                            我的留言 <b class="caret"></b>
                                        </a>
                                        <ul class="dropdown-menu">
                                            <li><a href="/message/list/user/page/1/1">已审核</a></li>
                                            <li><a href="/message/list/user/page/1/0">未审核</a></li>
                                        </ul>
                                    </li>
                                    </li>
                                </ul>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="/user/login">请登录</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </div>
</nav>
