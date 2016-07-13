<%@ page import="java.text.SimpleDateFormat" %>
<%@page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    request.setAttribute("sdf", sdf); //request域
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
    <script type="text/javascript">
        $(document).ready(function () {
            $(".responseForm").validationEngine('attach');
        });
    </script>
    <div class="container-fluid" id="database">
        <div class="row">
            <jsp:include page="../left.jsp"/>
            <div class="col-xs-9">
                <c:choose>
                    <c:when test="${null ne pageInfo.list and 0 ne pageInfo.list.size()}">
                        <div class="list-group">
                            <c:forEach var="message" items="${pageInfo.list}" varStatus="messageStatus">
                                <li class="list-group-item"><h4 class="list-group-item-heading"><a
                                        data-toggle="collapse"
                                        href="#responselist${messageStatus.index}"
                                        aria-expanded="false"
                                        aria-controls="responselist${messageStatus.index}">
                                        ${message.title} </a></h4>
                                    <div class="list-group-item-text" style="text-indent:2em;"><p>${message.content}</p>
                                        <div class="collapse" id="responselist${messageStatus.index}">
                                            <hr/>
                                            <div class="chat">
                                                <c:if test="${null ne message.responseDTOList and 0 ne message.responseDTOList.size()}">
                                                    <div class="widget-content padded">
                                                        <ul>
                                                            <c:forEach var="response" items="${message.responseDTOList}"
                                                                       varStatus="responseListStatus">
                                                                <li>
                                                                    <div class="bubble">
                                                                        <a class="user-name">${response.userName}</a>
                                                                        <p class="message">${response.content}
                                                                        </p>
                                                                        <p class="time"><c:out
                                                                                value="${sdf.format(response.updateTime*1000)}"/>
                                                                        </p>
                                                                    </div>
                                                                </li>
                                                            </c:forEach>
                                                        </ul>
                                                    </div>
                                                </c:if>


                                                <div style="text-align:right">
                                                    <div class="btn-group" role="group" aria-label="oprations">
                                                        <a href="/admin/message/delete/${currMessageTypeId}/${message.id}/page/${pageNum}/${isPassed}"
                                                           role="button" class="btn btn-default">删除留言</a>
                                                        <c:choose>
                                                            <c:when test="${null ne messageTypeList and 0 ne messageTypeList.size()}">
                                                                <div class="btn-group" role="group">
                                                                    <button type="button"
                                                                            class="btn btn-default dropdown-toggle"
                                                                            data-toggle="dropdown" aria-haspopup="true"
                                                                            aria-expanded="false">
                                                                        修改类别
                                                                        <span class="caret"></span>
                                                                    </button>
                                                                    <ul class="dropdown-menu">
                                                                        <c:forEach var="messageType"
                                                                                   items="${messageTypeList}">
                                                                            <li>
                                                                                <a href="/admin/message/changetype/${currMessageTypeId}/${messageType.id}/${message.id}/page/${pageInfo.pageNum}/${isPassed}">${messageType.typeName}</a>
                                                                            </li>
                                                                        </c:forEach>
                                                                    </ul>
                                                                </div>
                                                            </c:when>
                                                        </c:choose>
                                                        <a onclick="$(this).parent().siblings('.post-message').show()"
                                                           role="button" class="btn btn-default">回复留言</a>
                                                    </div>
                                                    <div class="post-message" style="display:none">
                                                        <form method="post" class="responseForm"
                                                              action="/admin/response/add/${currMessageTypeId}/page/${pageInfo.pageNum}/${isPassed}">
                                                            <input type="hidden" name="messageId" value="${message.id}">
                                        <textarea name="content" class="form-control validate[required]"
                                                  placeholder="请输入您需要回复的信息"
                                                  rows="2"></textarea><input type="submit" value="发送">
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </c:forEach>
                        </div>
                        <div id="page" style="text-align:center"></div>
                    </c:when>
                    <c:otherwise>
                        没有留言
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>

<script>
    //好像很实用的样子，后端的同学再也不用写分页逻辑了。
    laypage({
        cont: $('#page'),
        pages: ${pageInfo.pages}, //可以叫服务端把总页数放在某一个隐藏域，再获取。假设我们获取到的是18
        curr: ${pageInfo.pageNum},
        jump: function (e, first) { //触发分页后的回调
            if (!first) { //一定要加此判断，否则初始时会无限刷新
                location.href = '/admin/message/list/${currMessageTypeId}/page/' + e.curr + "/" +${isPassed};
            }
        },
        skin: 'molv', //皮肤
        first: ${pageInfo.firstPage}, //将首页显示为数字1,。若不显示，设置false即可
        last: ${pageInfo.lastPage}, //将尾页显示为总页数。若不显示，设置false即可
        prev: '<', //若不显示，设置false即可
        next: '>' //若不显示，设置false即可
    });
    <c:if test="${null ne delFailed and true ne delFailed}">
    layer.alert('刪除失败', {icon: 0});
    </c:if>
</script>

