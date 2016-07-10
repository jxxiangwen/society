<%@page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<!DOCTYPE html>
<html>
<head>
    <title>
        <sitemesh:write property='title'/>
    </title>
    <!--[if lt IE 9]>
    <script src="/js/html5shiv.min.js"></script>
    <script src="/js/respond.js"></script>
    <![endif]-->
    <title>Page title</title>
    <meta charset="utf-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
    <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap-switch.min.css" rel="stylesheet">
    <link href="/validation/validationEngine.jquery.css" rel="stylesheet">
    <link href="/laypage/skin/laypage.css" rel="stylesheet">
    <link href="/css/message.css" rel="stylesheet">
    <script src="/js/jquery-1.11.3.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/bootstrap-switch.min.js"></script>
    <script src="/js/bootstrap-hover-dropdown.min.js"></script>
    <script src="/validation/jquery.validationEngine.js"></script>
    <script src="/validation/jquery.validationEngine-zh_CN.js"></script>
    <script src="/laypage/laypage.js"></script>
    <script src="/layer/layer.js"></script>
    <script src="/laytpl/laytpl.js"></script>
    <sitemesh:write property='head'/>
</head>
<body>
<jsp:include page="../adminHead.jsp"/>
<sitemesh:write property='body'/>
<jsp:include page="../adminFoot.jsp"/>
</body>
</html>