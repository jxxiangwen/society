<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<!--[if lt IE 9]>
<script src="/js/html5shiv.min.js"></script>
<script src="/js/respond.js"></script>
<![endif]-->
<head>
    <link rel="shortcut icon" href="/favicon.ico"/>
    <link rel="apple-touch-icon" href="/favicon.ico"/>
    <link rel="stylesheet" href="/404/main.css" type="text/css" media="screen, projection"/>
    <!-- main stylesheet -->
    <link rel="stylesheet" type="text/css" media="all" href="/404/tipsy.css"/>
    <!-- Tipsy implementation -->
    <script src="/js/jquery-1.11.3.min.js"></script>
    <!-- uiToTop implementation -->
    <script src="/404/custom-scripts.js"></script>
    <script src="/404/jquery.tipsy.js"></script>
    <!-- Tipsy -->
    <script type="text/javascript">
        $(document).ready(function () {
            universalPreloader();
        });
        $(window).load(function () {
            //remove Universal Preloader
            universalPreloaderRemove();
            rotate();
            dogRun();
            dogTalk();
            //Tipsy implementation
            $('.with-tooltip').tipsy({gravity: $.fn.tipsy.autoNS});

        });
    </script>
    <title>404错误</title>
<body>

<div id="wrapper">
    <!-- 404 graphic -->
    <div class="graphic"></div>
    <!-- 404 graphic -->
    <!-- Not found text -->
    <div class="not-found-text">
        <c:choose>
            <c:when test="${null ne request.errorMessage}">
                <h3 class="not-found-text">${request.errorMessage}</h3>
            </c:when>
            <c:otherwise>
                <h1 class="not-found-text">对不起，页面不存在!</h1>
            </c:otherwise>
        </c:choose>

    </div>
    <!-- Not found text -->

    <!-- search form -->
    <!-- <div class="search">
        <form name="search" method="get" action="#" />
            <input type="text" name="search" value="Search ..." />
            <input class="with-tooltip" title="Search!" type="submit" name="submit" value="" />
        </form>
    </div> -->
    <!-- search form -->

    <!-- top menu -->
    <!-- <div class="top-menu">
        <a href="javascript:void(0);" class="with-tooltip" title="Return to the home page">Home</a> | <a href="javascript:void(0);" class="with-tooltip" title="Navigate through our sitemap">Sitemap</a> | <a href="javascript:void(0);" class="with-tooltip" title="Contact us!">Contact</a> | <a href="javascript:void(0);" class="with-tooltip" title="Request additional help">Help</a>
    </div> -->
    <!-- top menu -->

    <div class="dog-wrapper">
        <!-- dog running -->
        <div class="dog"></div>
        <!-- dog running -->

        <!-- dog bubble talking -->
        <div class="dog-bubble">

        </div>

        <!-- The dog bubble rotates these -->
        <div class="bubble-options">
            <p class="dog-bubble">
                Are you lost, bud? No worries, I'm an excellent guide!
            </p>

            <p class="dog-bubble">
                <br/>
                Arf! Arf!
            </p>

            <p class="dog-bubble">
                <br/>
                Don't worry! I'm on it!
            </p>

            <p class="dog-bubble">
                I wish I had a cookie<br/><img style="margin-top:8px" src="<%=basePath%>util/404/cookie.png"
                                               alt="cookie"/>
            </p>

            <p class="dog-bubble">
                <br/>
                Geez! This is pretty tiresome!
            </p>

            <p class="dog-bubble">
                <br/>
                Am I getting close?
            </p>

            <p class="dog-bubble">
                Or am I just going in circles? Nah...
            </p>

            <p class="dog-bubble">
                <br/>
                OK, I'm officially lost now...
            </p>

            <p class="dog-bubble">
                I think I saw a <br/><img style="margin-top:8px" src="<%=basePath%>util/404/cat.png" alt="cat"/>
            </p>

            <p class="dog-bubble">
                What are we supposed to be looking for, anyway? @_@
            </p>
        </div>
        <!-- The dog bubble rotates these -->
        <!-- dog bubble talking -->
    </div>

    <!-- planet at the bottom -->
    <div class="planet"></div>
    <!-- planet at the bottom -->
</div>
</body>
</html>