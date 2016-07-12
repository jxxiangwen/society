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
                                                <a href="javascript:void(0);" class="btn btn-default btn-sm" onclick="deleteType(${list.id})">
                                                    删除
                                                </a>
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
                <div id="addPlace" style="text-align:center">
                    <a class="btn btn-default" onclick="addType()">增加</a>
                </div>
            </div>
        </div>
    </div>
    <script id="typeTemplate" type="text/html">
        <form id="typeFrom" action="/admin/vote/type/add" method="post">
            <div class="=form-group">
                <label>名称 </label>
                <input type="text" class="form-control validate[required]"
                       name="typeName" id="typeName" placeholder="类别名" value="">
            </div>
            <div class="=form-group">
                <label>所属类别 </label>
                <select id="parentName" class="form-control validate[required]" name="parentName">
                    <option value="不记名投票">不记名投票</option>
                    <option value="记名投票">记名投票</option>
                </select>
            </div>
            <div class="=form-group">
                <input type="submit" class="btn" value="确认">
                <input type="reset" class="btn" value="重置">
            </div>

        </form>
    </script>
    <script>
        function deleteType(id) {
            layer.confirm('确认删除吗？',
                    function () {
                        window.location='<%=basePath %>admin/vote/type/delete/' + id;
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
