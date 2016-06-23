<%@page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
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
</head>
<body>
<div class="container">
    <jsp:include page="head.jsp"/>
    <div id="body"></div>
    <div class="container-fluid" id="database">
        <div class="row">
            <div class="col-xs-6">
                <div class="form-group">
                    <label for="masterUrl">原数据库URL <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="masterUrl" placeholder="原数据库URL">
                </div>
            </div>
            <div class="col-xs-6">
                <div class="form-group">
                    <label for="slaveUrl">新数据库URL <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="slaveUrl" placeholder="新数据库URL">
                </div>
            </div>
            <div class="col-xs-2">
                <input class="btn btn-default btn-block" type="button" value="验证" onclick="checkType('master')">
            </div>
            <div class="col-xs-2">
                <input class="btn btn-default btn-block" type="button" value="保存" onclick="setDataBaseURL('master')">
            </div>
            <div class="col-xs-2">
                <input class="btn btn-default btn-block" type="button" value="重置" onclick="resetUrl('master')">
            </div>
            <div class="col-xs-2">
                <input class="btn btn-default btn-block" type="button" value="验证" onclick="checkType('slave')">
            </div>
            <div class="col-xs-2">
                <input class="btn btn-default btn-block" type="button" value="保存" onclick="setDataBaseURL('slave')">
            </div>
            <div class="col-xs-2">
                <input class="btn btn-default btn-block" type="button" value="保存" onclick="resetUrl('slave')">
            </div>
        </div>
    </div>
    <div class="container-fluid" id="table">
        <div class="row">
            <div class="col-xs-6">
                <div class="form-group">
                    <label for="masterTable">原数据库表 <span class="text-danger">*</span></label>
                    <select class="form-control" id="masterTable">
                        <option>请选择原数据库表</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                </div>
            </div>
            <div class="col-xs-6">
                <div class="form-group">
                    <label for="slaveTable">新数据库表 <span class="text-danger">*</span></label>
                    <select class="form-control" id="slaveTable">
                        <option>请选择新数据库表</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="container-fluid" id="column">

        </div>
    </div>
    <div class="col-xs-4">
    </div>
    <div class="col-xs-4">
        <button class="btn btn-default btn-block"onclick="addTable()">新增表</button>
    </div>
    <div class="col-xs-4">
    </div>

</div>
<%--<input type="checkbox" name="my-checkbox" data-size="small" checked>--%>
</body>
<script type="text/javascript">
    $("[name='my-checkbox']").bootstrapSwitch();
    function checkURL(url) {
        if (url == "" || url == null) {
            alert("url不能为空！");
            return false;
        } else {
//            alert("false");
            return true;
        }
    }
    function checkType(type) {
        if ("master" == type) {
            return checkURL($("#masterUrl").val())
        } else {
            return checkURL($("#slaveUrl").val())
        }
    }
    function setDataBaseURL(type) {
        if(checkType(type)){
            if ("master" == type) {
                if ($('#masterUrl').attr("readonly") == undefined) {
                    $("#masterUrl").attr("readonly", "readonly");
                }
            } else {
                //判断input元素是否已经设置了readonly属性
                if ($('#slaveUrl').attr("readonly") == undefined) {
                    $("#slaveUrl").attr("readonly", "readonly");
                }
            }
        }
    }
    function resetUrl() {
    }
    function addTable(type) {
    }
</script>
</html>
