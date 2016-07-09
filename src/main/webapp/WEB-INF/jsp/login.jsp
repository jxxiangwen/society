<%@page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<body>
<script type="text/javascript">
    $(document).ready(function () {
        $("#loginForm").validationEngine('attach');
    });
</script>
<div class="container">
    <div class="row">
        <div class="col-md-3 col-lg-3"></div>
        <div class="col-md-6 col-lg-6">
            <div class="login-and-register-container">

                <div class="login-box">
                    <div class="page-header">
                        <h1>
                            用户登录
                        </h1>
                    </div>
                    <c:if test="${null ne errorMsg}">
                        <div style="color:red"><c:out value="${errorMsg}"/></div>
                    </c:if>
                    <form id="loginForm" action="/user/login" method="post">
                        <div class="=form-group">
                            <label for="userId">学号 </label>
                            <input type="text" class="form-control validate[required,custom[number]]" id="userId"
                                   name="userId" placeholder="学号" value="">
                        </div>
                        <div class="=form-group">
                            <label for="password">密码 </label>
                            <input type="password" class="form-control validate[required]"
                                   id="password" name="password" placeholder="密码" value="">
                        </div>
                        <br/>
                        <div style="text-align: center; padding: 5px">
                            <input type="submit" class="btn btn-primary" value="登录"
                                   style="width: 49%; height: 40px;">
                            <input type="reset" class="btn btn-primary" value="重置"
                                   style="width: 49%; height: 40px">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-3 col-sm-3  col-lg-3"></div>
</div>
</body>
