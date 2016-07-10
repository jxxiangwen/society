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
    <div class="container-fluid" id="database">
        <div class="row">
            <div class="col-xs-3">
                <div class="panel-group" id="accordion">
                    <c:forEach var="messageType" items="${messageTypeList}" varStatus="status">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion"
                                       href="#collapse${status.index}">
                                            ${messageType.typeName}<b class="caret"></b>
                                    </a>
                                </h4>
                            </div>
                            <div id="collapse${status.index}" class="panel-collapse collapse in">
                                <ul class="list-group">
                                    <li class="list-group-item"><a
                                            href="/admin/message/list/${messageType.id}/page/1?isPassed=true">已审核</a>
                                    </li>
                                    <li class="list-group-item"><a
                                            href="/admin/message/list/${messageType.id}/page/1?isPassed=false">未审核</a>
                                    </li>
                                    <li class="list-group-item"><a
                                            href="/admin/messageType/delete/${currMessageTypeId}/${messageType.id}/page/${currPageNum}">删除</a>
                                    </li>
                                    <li class="list-group-item"><a data-toggle="modal" data-target="#updateModal"
                                                                   onclick="$('#updateMessageTypeId').val(${messageType.id})">修改</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="modal"
                                   data-target="#addModal">
                                    增加类别<b class="caret"></b>
                                </a>
                            </h4>
                        </div>
                    </div>

                </div>
            </div>


            <ul> class="nav nav-pills nav-stacked" style="position:fixed;top:0;left:7%;width:17%">
                <c:if test="${null ne messageTypeList and 0 ne messageTypeList.size()}">
                    <c:forEach var="messageType" items="${messageTypeList}" varStatus="status">
                        <li role="presentation">
                        <li class="dropdown">
                            <a id="nav${status.index}" class="dropdown-toggle"
                               data-toggle="dropdown">${messageType.typeName}
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu" role="menu" aria-labelledby="nav${status.index}">
                                <li><a href="/admin/message/list/${messageType.id}/page/1?isPassed=true" tabindex="-1"
                                       data-toggle="tab">已审核</a></li>
                                <li><a href="/admin/message/list/${messageType.id}/page/1?isPassed=false" tabindex="-1"
                                       data-toggle="tab">未审核</a></li>
                                <li><a data-toggle="modal" data-target="#updateModal"
                                       onclick="$('#updateMessageTypeId').val(${messageType.id})">修改</a></li>
                                <li>
                                    <a href="/admin/messageType/delete/${currMessageTypeId}/${messageType.id}/page/${currPageNum}">删除</a>
                                </li>
                            </ul>
                        </li>
                        </li>
                    </c:forEach>
                </c:if>
                <li role="presentation"><a data-toggle="modal"
                                           data-target="#addModal">增加类别</a></li>
            </ul>
        </div>
        <div class="col-xs-9">
            <c:choose>
                <c:when test="${null ne messageList and 0 ne messageList.size()}">
                    <div class="list-group">
                        <c:forEach var="message" items="${messageList}" varStatus="messageListStatus">
                            <li class="list-group-item"><h4 class="list-group-item-heading"><a data-toggle="collapse"
                                                                                               href="#responselist${messageListStatus.index}"
                                                                                               aria-expanded="false"
                                                                                               aria-controls="responselist${messageListStatus.index}">
                                    ${message.title} </a></h4>
                                <div class="list-group-item-text" style="text-indent:2em;"><p>${message.content}</p>
                                    <div class="collapse" id="responselist${messageListStatus.index}">
                                        <hr/>
                                        <div class="chat">
                                            <c:if test="${null ne message.responseDTOList and 0 ne message.responseDTOList.size()}">
                                                <div class="widget-content padded">
                                                    <ul>
                                                        <c:forEach var="response" items="${message.responseDTOList}"
                                                                   varStatus="responseListStatus">
                                                            <li>
                                                                <div class="bubble">
                                                                    <a class="user-name">${response.respondentName}</a>
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
                                                <a type="button"
                                                   href="/admin/message/delete/${currMessageTypeId}/${message.id}/page/${currPageNum}"
                                                   class="btn btn-default">删除留言</a>
                                                <c:if test="${null ne messageTypeList and 0 ne messageTypeList.size()}">
                                                    <div class="dropdown" style="display:inline">
                                                        <button class="btn btn-default dropdown-toggle" type="button"
                                                                id="changeMessageType${message.id}"
                                                                data-toggle="dropdown"
                                                                aria-haspopup="true" aria-expanded="true">
                                                            修改留言类别
                                                            <span class="caret"></span>
                                                        </button>
                                                        <ul class="dropdown-menu"
                                                            aria-labelledby="changeMessageType${message.id}">
                                                            <c:forEach var="messageType" items="${messageTypeList}">
                                                                <li>
                                                                    <a href="/admin/message/changetype/${message.id}/${messageType.id}/page/${currPageNum}">${messageType.typeName}</a>
                                                                </li>
                                                            </c:forEach>
                                                        </ul>
                                                    </div>
                                                </c:if>

                                                <button class="btn btn-default"
                                                        onclick="$(this).siblings('.post-message').show()">
                                                    回复留言
                                                </button>
                                                <div> class="post-message" style="display:none">
                                                    <form method="post"
                                                          action="/admin/response/add/${currMessageTypeId}">
                                                        <input type="hidden" name="messageId" value="${message.id}">
                                        <textarea name="content" class="form-control" placeholder="请输入您需要回复的信息"
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
                    <div id="page"></div>
                </c:when>
                <c:otherwise>
                    没有留言
                </c:otherwise>
            </c:choose>
        </div>


    </div>
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
                <form action="/admin/messageType/add/${currMessageTypeId}/page/${currPageNum}" method="post">
                    <input type="hidden" id="updateMessageTypeId" name="id">
                    <div class="form-group">
                        <label for="title">类别名称</label>
                        <input type="input" class="form-control" name="typeName" id="title" placeholder="留言标题">
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

<!-- 更新留言类别模体框 -->
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
                <form action="/admin/messageType/update/${currMessageTypeId}/page/${currPageNum}" method="post">

                    <div class="form-group">
                        <label for="typeName">类别名称</label>
                        <input type="input" class="form-control" name="typeName" id="typeName" placeholder="留言标题">
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

<script>
    //好像很实用的样子，后端的同学再也不用写分页逻辑了。
    laypage({
        cont: $('#page'),
        pages: ${pageInfo.pages}, //可以叫服务端把总页数放在某一个隐藏域，再获取。假设我们获取到的是18
        curr: ${pageInfo.pageNum},
        jump: function (e, first) { //触发分页后的回调
            if (!first) { //一定要加此判断，否则初始时会无限刷新
                location.href = 'admin/message/list/${currMessageTypeId}/page/' + e.curr;
            }
        },
        skin: 'molv', //皮肤
        first: ${pageInfo.firstPage}, //将首页显示为数字1,。若不显示，设置false即可
        last: ${pageInfo.lastPage}, //将尾页显示为总页数。若不显示，设置false即可
        prev: '<', //若不显示，设置false即可
        next: '>' //若不显示，设置false即可
    });
</script>

