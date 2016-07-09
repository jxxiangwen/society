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
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-3 col-md-3">
            <ul> class="nav nav-pills nav-stacked" style="position:fixed;top:0;left:7%;width:17%">
                <c:when test="${null ne messageTypeList and 0 ne messageTypeList.size()}">
                    <c:forEach var="messageType" items="${messageTypeList}" varStatus="status">
                        <li role="presentation">
                        <li class="dropdown">
                            <a href="/message/list/${messageType.id}" id="nav${status.index}" class="dropdown-toggle"
                               data-toggle="dropdown">${messageType.typeName}
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu" role="menu" aria-labelledby="nav${status.index}">
                                <li><a href="/admin/message/list/${messageType.id}?isPassed=true" tabindex="-1"
                                       data-toggle="tab">已审核</a></li>
                                <li><a href="/admin/message/list/${messageType.id}?isPassed=false" tabindex="-1"
                                       data-toggle="tab">未审核</a></li>
                                <li><a data-toggle="modal" data-target="#updateModal"
                                       onclick="$('#updateMessageTypeId').val(${messageType.id})">修改</a></li>
                                <li><a href="/admin/messageType/delete/${currMessageTypeId}/${messageType.id}">删除</a></li>
                            </ul>
                        </li>
                        </li>
                    </c:forEach>
                </c:when>
                <li role="presentation"><a data-toggle="modal"
                                           data-target="#addModal">增加类别</a></li>
            </ul>
        </div>
        <div class="col-xs-9">
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
                                        <c:when test="${null ne message.responseDTOList and 0 ne message.responseDTOList.size()}">
                                            <div class="widget-content padded">
                                                <ul>
                                                    <c:forEach var="response" items="${message.responseDTOList}"
                                                               varStatus="responseListStatus">
                                                        <li>
                                                            <div class="bubble">
                                                                <a class="user-name">${response.respondentName}</a>
                                                                <p class="message">${response.content}
                                                                </p>
                                                                <p class="time">#{sdf.format(response.updateTime*1000)}}
                                                                </p>
                                                            </div>
                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </c:when>


                                        <div style="text-align:right">
                                            <a type="button" href="/admin/message/delete/${currMessageTypeId}/${message.id}"
                                               class="btn btn-default">删除留言</a>
                                            <c:when test="${null ne messageTypeList and 0 ne messageTypeList.size()}">
                                                <div class="dropdown" style="display:inline">
                                                    <button class="btn btn-default dropdown-toggle" type="button"
                                                            id="changeMessageType${message.id}" data-toggle="dropdown"
                                                            aria-haspopup="true" aria-expanded="true">
                                                        修改留言类别
                                                        <span class="caret"></span>
                                                    </button>
                                                    <ul class="dropdown-menu"
                                                        aria-labelledby="changeMessageType${message.id}">
                                                        <c:forEach var="messageType" items="${messageTypeList}">
                                                            <li>
                                                                <a href="/admin/message/changetype/${message.id}/${messageType.id}">${messageType.typeName}</a>
                                                            </li>
                                                        </c:forEach>
                                                    </ul>
                                                </div>
                                            </c:when>

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
                <form action="/admin/messageType/add/${currMessageTypeId}" method="post">
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
                <form action="/admin/messageType/update/${currMessageTypeId}" method="post">

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
    //调用分页
    laypage({
        cont: 'page',
        pages: ${pages},
        curr: '${currPageNum}' || 1,
        jump: function (obj) {
            $.post("/admin/message/list/${messageType.id}",{pageNum:obj.curr},function() {
                    }
            )
        }

    });
</script>

