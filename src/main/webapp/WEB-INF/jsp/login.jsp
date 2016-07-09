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
        <%--<div class="col-md-6">--%>
        <div class="col-md-6 col-lg-6">
            <div class="login-and-register-container">

                <div class="login-box">
                    <div class="page-header">
                        <h1>
                            用户登录
                            <!--  <a href="http://localhost/admin/login.htm">管理员登陆</a> -->
                        </h1>
                    </div>
                    <c:if test="${null ne errorMsg}">
                        <div style="color:red"><c:out value="${errorMsg}"/></div>
                    </c:if>
                    <form id="loginForm" action="/user/login" method="post">
                        <!-- <div style="margin-bottom: 10px"> -->
                        <div class="=form-group">
                            <label for="userId">学号 </label>
                            <input type="text" class="form-control validate[required,custom[number]]" id="userId"
                                   name="userId" placeholder="学号" value="">
                        </div>
                        <!-- </div> -->
                        <!-- <div style="margin-bottom: 20px"> -->
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
                        <!-- </div> -->
                    </form>
                </div>
                <%--<script>--%>
                <%--function submitForm() {--%>
                <%--//$('#loginForm').form('submit');--%>
                <%--$('#loginForm').submit();--%>
                <%--}--%>
                <%--function clearForm() {--%>
                <%--$('#loginForm').form('clear');--%>
                <%--}--%>
                <%--</script>--%>
                <!-- 登录窗口 -->
            </div>
            <!-- login-box end -->

        </div>
        <!-- login-and-register-container end -->
    </div>
    <div class="col-md-3 col-sm-3  col-lg-3"></div>
    <%--</div>--%>
</div>
</body>
