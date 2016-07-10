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
    <link href="/css/message.css" rel="stylesheet" >
    <script src="/js/jquery-1.11.3.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/bootstrap-switch.min.js"></script>
    <script src="/js/bootstrap-hover-dropdown.min.js"></script>
    <script src="/validation/jquery.validationEngine.js"></script>
    <script src="/validation/jquery.validationEngine-zh_CN.js"></script>
    <script src="/laypage/laypage.js"></script>
    <script language="JavaScript"> if (window != top) top.location.href = location.href; </script>
    <link id="_Portals__default_" rel="stylesheet" type="text/css" href="/css/default.css"/>
    <link id="_Portals_718_" rel="stylesheet" type="text/css" href="/css/portal.css"/>
    <script src="/js/dnncore.js"></script>
    <script>
        var _hmt = _hmt || [];
        (function() {
            var hm = document.createElement("script");
            hm.src = "//hm.baidu.com/hm.js?ebd6d1267b144441d74ce109cab9d914";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
        $('.dropdown-toggle').dropdownHover();
    </script>
    <sitemesh:write property='head'/>
</head>
<body>
<jsp:include page="../head.jsp"/>
<sitemesh:write property='body'/>
<jsp:include page="../foot.jsp"/>
</body>
</html>