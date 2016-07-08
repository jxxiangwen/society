<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@page import="java.util.Date" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>张江科企资源共享平台</title>
    <meta charset="utf-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
    <meta http-equiv="expires" content=<%=new Date()%>>
    <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="keywords" content="张江科企资源共享平台,平台,平台建站,平台系统,平台平台">
    <meta name="description" content="张江科企资源共享平台">
    <meta name="generator" content="上海大学智能信息处理与多媒体展示团队"/>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <meta property="qc:admins" content="1220311574763007636"/>
    <meta property="wb:webmaster" content="6b685cd5f06ba5f1"/>
    <link rel="shortcut icon" href="<%=basePath%>favicon.ico"/>
    <link rel="apple-touch-icon" href="<%=basePath%>favicon.ico"/>
    <script src="http://apps.bdimg.com/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- 幻灯片 -->
    <link href="<%=basePath%>util/js/jqplugins/fotorama/fotorama.css" type="text/css" rel="stylesheet">
    <script src="<%=basePath%>util/js/jqplugins/fotorama/fotorama.js"></script>
    <script src="<%=basePath%>util/js/bootstrap.min.js?version=3.0.3"></script>
    <script src="<%=basePath%>util/js/jquery.form.js?version=3.24"></script>
    <script src="<%=basePath%>util/js/bootstrap-datetimepicker.js?version=3.0"></script>
    <script src="<%=basePath%>util/js/bootstrap-datetimepicker.zh-CN.js?version=3.0"></script>
    <script src="<%=basePath%>util/js/holder.min.js"></script>
    <!-- 验证插件  -->
    <script src="<%=basePath%>util/jquery.validationEngine-zh_CN.js?version=2.6.2" charset="utf-8"></script>
    <script src="<%=basePath%>util/jquery.validationEngine.js?version=2.6.2" charset="utf-8"></script>
    <link rel="stylesheet" href="<%=basePath%>util/validationEngine.jquery.css?version=2.6.2" type="text/css"/>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#loginform").validationEngine('attach');
        });
    </script>
    <!-- 验证插件  -->
    <link href="<%=basePath%>tpl/default/css/style_<c:if test="${null eq session.setHomeColor}">blue</c:if><c:if test="${null ne session.setHomeColor}">${session.setHomeColor}</c:if>.css?version=4.1.0"
          type="text/css" rel="stylesheet" id="style_color">
</head>
<body id="login">
<div class="container">
    <div class="col-sm-7 hidden-xs">
        <div class="welcome-img">
            <div class="thumbnail">
                <div class='adv'>
                    <%--<a href='http://www.renwuyi.com' target='_blank' title='任务易'><img--%>
                    <%--src='tpl/default/img/grey.gif' width='485' class='lazy'--%>
                    <%--data-original='data/uploads/sys/ad/1659884648536c7ac240778.jpg'--%>
                    <%--height='245' alt='任务易' title='任务易'></a>--%>
                    <a href='<%=basePath%>' target='_blank' title='任务易'><img
                            src='data/uploads/sys/ad/0335541e488f7bc36.jpg' width='485'
                            height='245' alt='任务易' title='任务易'></a>
                </div>
            </div>
            <!-- thumbnail end-->
            <div class="caption">
                <h3>注册用户的特色功能</h3>


                <ul class="list-inline">
                    <li><p class="text-muted">
                        <i class="fa fa-check-square"></i> 实名认证后，交易保障。
                    </p></li>
                    <li><p class="text-muted">
                        <i class="fa fa-check-square"></i> 订单记录保存，随时随地查看
                    </p></li>
                    <li><p class="text-muted">
                        <i class="fa fa-check-square"></i> 关键位置推荐，惊喜不断
                    </p></li>
                </ul>

            </div>
        </div>
        <!-- welcome-img end -->
    </div>
    <div class="col-sm-5 col-xs-12">
        <div class="login-and-register-container">

            <div class="login-box">
                <div class="page-header">
                    <!-- <div class="pull-right">
                        或 <a id="register-link" href="index.php?do=register"
                            rel="show-register">注册账户</a>
                    </div> -->
                    <h1>
                        用户登录
                        <!--  <a href="http://localhost/admin/login.htm">管理员登陆</a> -->
                    </h1>
                </div>
                <form id="loginform" action="login_login" method="post"
                      namespace="/">
                    <!-- <div style="margin-bottom: 10px"> -->
                    <div class="col-sm-16">
                        <input type="text"
                               class="form-control validate[required,custom[email]]" id="email"
                               name="email" placeholder="邮箱" value="">
                    </div>
                    <br/>
                    <!-- </div> -->
                    <!-- <div style="margin-bottom: 20px"> -->
                    <div class="col-sm-16">
                        <input type="password" class="form-control validate[required]"
                               id="password" name="password" placeholder="密码" value="">
                    </div>
                    <br/>
                    <!-- </div> -->
                    <!-- <div style="margin-bottom: 20px" -->
                    <%-- <input type="checkbox" name="autoLogin" checked="checked">
                    <span>自动登录</span><br />
                    <br /> --%>
                    <!-- </div> -->
                    <div style="text-align: center; padding: 5px">
                        <input type="submit" class="btn btn-primary" value="登录"
                               style="width: 49%; height: 40px;" onclick="submitForm()">
                        <input type="reset" class="btn btn-primary" value="重置"
                               style="width: 49%; height: 40px" onclick="clearForm()">
                    </div>
                    <!-- </div> -->
                </form>
            </div>
            <%-- <script type="text/javascript">
                $(function() {
                    $('#dlg').dialog('close');
                });
            </script> --%>
            <script>
                function submitForm() {
                    //$('#loginform').form('submit');
                    $('#loginform').submit();
                }
                function clearForm() {
                    $('#loginform').form('clear');
                }
            </script>
            <!-- 登录窗口 -->
            <!-- <form action="login" role="form" name="loginForm" id="loginForm" method="post">
                    <input type="hidden" name="formhash" id="formhash" value="ce9abd">
                    <input type="hidden" name="hdn_refer" id="hdn_refer"
                        value="http://localhost:8000/weike/index.php?do=index">
                    <div class="form-group">
                        <label class="sr-only" for="username">帐号</label> <input
                            type="email" class="form-control" id="account" name="username"
                            placeholder="帐号">
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="password">密码</label> <input
                            type="password" class="form-control" id="password"
                            name="password" placeholder="请填写登录密码">
                    </div>
                    <div class="form-group pull-right">
                        <a href="index.php?do=retrieve">忘记密码？</a>
                    </div>
                    <div class="checkbox">
                        <label> <input type="checkbox" name="autoLogin" value="1">
                            记住我
                        </label>
                    </div>
                    <div class="form-group text-center">
                        <button type="submit" class="btn btn-primary btn-block">登录</button>
                    </div>
                </form> -->
        </div>
        <!-- login-box end -->

    </div>
    <!-- login-and-register-container end -->


    <div class="login-and-register-footer">
        <!--
<p>第三方登录：
  <a href="index.php?do=oauthlogin&type=sina" title=""><img src="util/img/ico/sina_t.gif" alt=""></a>
<a href="index.php?do=oauthlogin&type=qq" title=""><img src="util/img/ico/qq_t.gif" alt=""></a>
<a href="index.php?do=oauthlogin&type=renren" title=""><img src="util/img/ico/renren_t.gif" alt=""></a>
</p>
</div>
-->
        <!-- modal-footer end -->
    </div>
    <!-- col-xs-5 end -->

</div>
<%--<script src="<%=basePath%>util/js/model/register/register.js"></script>--%>

</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>