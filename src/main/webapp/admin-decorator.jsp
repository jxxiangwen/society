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
    <script src="/js/jquery-1.11.3.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/bootstrap-switch.min.js"></script>
    <sitemesh:write property='head'/>
</head>
<body>
<jsp:include page="WEB-INF/admin-head.jsp"/>
<sitemesh:write property='body'/>
<jsp:include page="WEB-INF/admin-foot.jsp"/>
</body>
</html>