<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%--<%@ page isELIgnored="false"%>--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<!--[if lt IE 7]> <html dir="ltr" lang="zh-cn" id="ie6"> <![endif]-->
<!--[if IE 7]> <html dir="ltr" lang="zh-cn" id="ie7"> <![endif]-->
<!--[if IE 8]> <html dir="ltr" lang="zh-cn" id="ie8"> <![endif]-->
<!--[if lte IE 8]>
<script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
<script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<!--[if gt IE 8]><!--><html dir="ltr" lang="zh-cn"><!--<![endif]-->
<head>
    <title>资讯中心—张江科企资源共享平台</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="keywords" content="资讯中心,行业动态,媒体报导,网站公告,政策法规,安全交易，新闻列表">
    <meta name="description" content="张江科企资源共享平台">
    <meta name="generator" content="上海大学智能信息处理与多媒体展示团队"/>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <meta property="qc:admins" content="1220311574763007636"/>
    <meta property="wb:webmaster" content="6b685cd5f06ba5f1"/>
</head>
<body>
<div class="container">
    <table border="1">
        <tbody>
        <tr>
            <th>姓名</th>
            <th>年龄</th>
        </tr>
        <c:if test="${null ne listUser and 0 ne listUser.size()}">
            <c:forEach var="list" items="${listUser}">
                <tr>
                    <td>${list.user_name }</td>
                    <td>${list.age }</td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</div>
</body>
</html>
