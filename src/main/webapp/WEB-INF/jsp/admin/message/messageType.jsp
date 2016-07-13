<%@page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
    <script type="text/javascript">
        $(document).ready(function () {
            $("#addForm,#updateForm").validationEngine('attach');
        });
    </script>
    <div class="container-fluid" id="database">
        <div class="row">
            <jsp:include page="../left.jsp"/>
            <div class="col-md-9">
                <c:choose>
                    <c:when test="${null ne messageTypeList and 0 ne messageTypeList.size()}">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>留言类别</th>
                                <th>待审核条数</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="list" items="${messageTypeList}">
                                <tr>
                                    <td>${list.typeName}</td>
                                    <td>${list.count}</td>
                                    <td>
                                        <div class="btn-group" role="group" aria-label="oprations">
                                            <a href="/admin/message/list/${list.id}/page/1/1" role="button"
                                               class="btn btn-default">已审核</a>
                                            <a href="/admin/message/list/${list.id}/page/1/0" role="button"
                                               class="btn btn-default">未审核</a>
                                            <a data-toggle="modal" data-target="#updateModal"
                                               onclick="$('#updateMessageTypeId').val(${list.id})" role="button"
                                               class="btn btn-default">更新</a>
                                            <a href="/admin/messageType/delete/${list.id}" role="button"
                                               class="btn btn-default">删除</a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>

                            <!-- 更新留言类别模体框 -->
                                <%--           <div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
                                                aria-labelledby="updateMessageType" aria-hidden="true">
                                               <div class="modal-dialog">
                                                   <div class="modal-content">
                                                       <div class="modal-header">
                                                           <button type="button" class="close"
                                                                   data-dismiss="modal" aria-hidden="true">
                                                               &times;
                                                           </button>
                                                           <h4 class="modal-title" id="updateMessageType">
                                                               更新留言类别
                                                           </h4>
                                                       </div>
                                                       <div class="modal-body">
                                                           <form action="/admin/messageType/update" id="updateForm" method="post">
                                                               <input type="hidden" id="updateMessageTypeId" name="id">
                                                               <div class="form-group">
                                                                   <label for="typeName">类别名称</label>
                                                                   <input type="input" class="form-control validate[required]" name="typeName" id="typeName" placeholder="留言标题">
                                                               </div>
                                                               <button type="submit" class="btn btn-default">提交</button>
                                                               <button type="button" class="btn btn-default"
                                                                       data-dismiss="modal">取消
                                                               </button>
                                                           </form>
                                                       </div>
                                                   </div>
                                               </div>
                                           </div>--%>

                            </tbody>
                        </table>
                    </c:when>
                    <c:otherwise>
                        暂时没有留言类别
                    </c:otherwise>
                </c:choose>
                <div style="text-align:center">
                    <button type="button" class="btn btn-default" data-toggle="modal"
                            data-target="#addModal">添加类别
                    </button>
                </div>

                <!-- 添加留言类别模体框 -->
                <div class="modal fade" id="addModal" tabindex="-1" role="dialog"
                     aria-labelledby="addMessageType" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close"
                                        data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title" id="addMessageTyepe">
                                    添加留言类别
                                </h4>
                            </div>
                            <div class="modal-body">
                                <form action="/admin/messageType/add" id="addForm" method="post">
                                    <div class="form-group">
                                        <label for="title">类别名称</label>
                                        <input type="input" class="form-control validate[required]" name="typeName"
                                               id="title" placeholder="留言标题">
                                    </div>
                                    <button type="submit" class="btn btn-default">提交</button>
                                    <button type="button" class="btn btn-default"
                                            data-dismiss="modal">取消
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
                     aria-labelledby="updateMessageType" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close"
                                        data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title" id="updateMessageType">
                                    更新留言类别
                                </h4>
                            </div>
                            <div class="modal-body">
                                <form action="/admin/messageType/update" id="updateForm" method="post">
                                    <input type="hidden" id="updateMessageTypeId" name="id">
                                    <div class="form-group">
                                        <label for="typeName">类别名称</label>
                                        <input type="input" class="form-control validate[required]" name="typeName"
                                               id="typeName" placeholder="留言标题">
                                    </div>
                                    <button type="submit" class="btn btn-default">提交</button>
                                    <button type="button" class="btn btn-default"
                                            data-dismiss="modal">取消
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>


            </div>

        </div>
    </div>
</div>
</div>
</div>
<script>
    <c:if test="${null ne delFailed and true eq delFailed}">
    layer.alert('刪除失败', {icon: 0});
    </c:if>
    <c:if test="${null ne noSuchTypeId and true eq noSuchTypeId}">
    layer.alert('更新失败', {icon: 0});
    </c:if>
    <c:if test="${null ne typeNameRepeated and true eq typeNameRepeated}">
    layer.alert('类别名称重复', {icon: 0});
    </c:if>

</script>

