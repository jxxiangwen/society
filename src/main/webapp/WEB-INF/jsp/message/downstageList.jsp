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
    <c:when test="${null ne messageTypeList and 0 ne messageTypeList.size()}">
        <div class="row">
            <div class="col-xs-3">
                <ul class="nav nav-pills nav-stacked" style="position:fixed;top:0;left:7%;width:17%">
                    <c:forEach var="messageType" items="messageTypeList">
                        <li role="presentation"><a href="/message/list/${messageType.id}">${messageType.typeName}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col-xs-9">
                <c:when test="${null ne messageList and 0 ne messageLismot.size()}">
                    <div class="list-group">
                        <c:forEach var="message" items="messageList" varStatus="status">
                            <li class="list-group-item"><h4 class="list-group-item-heading"><a data-toggle="collapse"
                                                                                               href="#responselist${status.index}"
                                                                                               aria-expanded="false"
                                                                                               aria-controls="responselist${status.index}">
                                    ${message.title}
                            </a></h4>
                                <div class="list-group-item-text" style="text-indent:2em;"><p>${message.content}</p>
                                    <div class="collapse" id="responselist${status.index}">
                                        <c:when test="${null ne message.responseDTOList and 0 ne message.responseDTOList.size()}">
                                            <div class="chat">
                                                <div class="widget-content padded">
                                                    <ul>
                                                        <c:forEach var="response" items="${message.responseDTOList}">
                                                            <li>
                                                                <div class="bubble">
                                                                    <a class="user-name">${response.respondentName}</a>
                                                                    <p class="message">
                                                                            ${response.content}
                                                                    </p>
                                                                    <p class="time">
                                                                            #{sdf.format(response.updateTime*1000)}
                                                                    </p>
                                                                </div>
                                                            </li>
                                                        </c:forEach>
                                                    </ul>
                                                </div>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            没有回复
                                        </c:otherwise>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                        <li>
                    </div>
                </c:when>
                <c:otherwise>
                    没有留言
                </c:otherwise>
                <div style="text-align:center">
                    <button type="button" class="btn btn-default" data-toggle="modal"
                            data-target="#addModal">添加留言
                    </button>
                </div>
                <div id="page"></div>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        留言类别为空
    </c:otherwise>
</div>

<!-- 添加留言模体框 -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
     aria-labelledby="addMessage" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close"
                        data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="addMessage">
                    添加留言
                </h4>
            </div>
            <div class="modal-body">
                <form action="/message/add/${currMessageTypeId}" method="post">
                    <div class="form-group">
                        <label for="title">留言标题</label>
                        <input type="input" class="form-control" name="title" id="title" placeholder="留言标题">
                    </div>
                    <div class="form-group">
                        <label for="content">留言内容</label>
                                <textarea class="form-control" name="content" id="content" placeholder="留言内容"
                                          rows="3"></textarea>
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
<c:otherwise>
    暂时没有留言类别
</c:otherwise>
<script>
    $(document).ready(
            $("ul.nav-stacked li").click(function () {
                        for (var i = 0; i < list.size(); i++) {
                            if (list[i].hasClass("active")) {
                                list[i].removeClass("active");
                            }
                        }
                        this.addClass("active");
                    }
            )
    );
    //调用分页
    laypage({
        cont: 'page',
        pages: ${pages},
        curr: '${currPageNum}' || 1,
        jump: function (obj) {
            $.post("/message/list/${messageType.id}",{pageNum:obj.curr},function() {
            }
            )
        }

        });
</script>