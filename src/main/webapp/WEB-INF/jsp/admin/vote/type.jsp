<%@ page import="java.text.SimpleDateFormat" %>
<%@page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
    <div class="container-fluid">
        <div class="row">
            <jsp:include page="../left.jsp"/>
            <div class="col-md-9">
                <table class="table">
                    <thead>
                    <tr>
                        <th>类别名称</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody id="voteType">
                    <c:choose>
                        <c:when test="${null ne voteTypeList and 0 ne voteTypeList.size()}">
                            <c:forEach var="list" items="${voteTypeList}">
                                <tr id="table">
                                    <td>${list.typeName}</td>
                                        <%--<td><fmt:formatNumber value="${list.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>--%>
                                        <%--<td><%=sdf.format(list.createTime)%></td>--%>
                                    <td id="${list.id}">
                                        <c:choose>
                                            <c:when test="${nameVote eq list.typeName or anonyVote eq list.typeName}">

                                            </c:when>
                                            <c:otherwise>
                                                <button class="form-control" type="button" onclick="deleteType(this)">
                                                    删除
                                                </button>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            暂时没有类别
                        </c:otherwise>
                    </c:choose>
                    </tbody>
                </table>
                <div id="addPlace">
                    <button class="form-control" type="button" onclick="addType()">增加</button>
                </div>
            </div>
        </div>
    </div>
    <script id="typeTemplate" type="text/html">
        <form>
            <div class="=form-group">
                <label>名称 </label>
                <input type="text" class="form-control validate[required]"
                       name="userId" placeholder="学号" value="">
            </div>
            <div class="=form-group">
                <select class="form-control validate[required]">
                    <option value="不记名投票">不记名投票</option>
                    <option value="记名投票">记名投票</option>
                </select>
            </div>
            <div class="=form-group">
                <input type="submit" class="btn" value="登录" onclick="addToTable()">
                <input type="reset" class="btn" value="重置">
            </div>

        </form>
    </script>
    <script>
        function addToTable() {
            var data = {};
            data['voteTypeId'] = id;
            $.ajax({
                type: 'POST',
                url: 'admin/vote/type/add',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json', //ajax返回值设置为text（json格式也可用它返回，可打印出结果，也可设置成json）
                success: function (json) {
                    return ajaxReturnHandle(json, function (jsonData) {
                        $('tr td').remove('td[id=' + id + ']');
                        layer.alert('恭喜您删除成功');
                    });
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    layer.alert(textStatus, {icon: 2});
                }
            });
        }
        function deleteType(obj) {
            var id = $(obj).parent().attr('id');
            var data = {};
            data['voteTypeId'] = id;
            $.ajax({
                type: 'POST',
                url: 'admin/vote/type/delete',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json', //ajax返回值设置为text（json格式也可用它返回，可打印出结果，也可设置成json）
                success: function (json) {
                    return ajaxReturnHandle(json, function (jsonData) {
                        $('tr td').remove('td[id=' + id + ']');
                        layer.alert('恭喜您删除成功');
                    });
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    layer.alert(textStatus, {icon: 2});
                }
            });
        }
        function addType() {
            $('#addPlace').html('');
            var template = $('#typeTemplate').html();
            var data = {};
            laytpl(template).render(data, function (html) {
                $('#addPlace').append(html);
            });
        }
    </script>
</div>
