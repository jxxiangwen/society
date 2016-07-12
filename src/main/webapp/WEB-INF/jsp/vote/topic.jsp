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
            $("#voteForm").validationEngine('attach');
        });
    </script>
    <div class="container-fluid" >
        <div class="row">
            <jsp:include page="../../left.jsp"/>
            <div class="col-md-9">
                <c:choose>
                    <c:when test="${null ne voteTopic}">
                        <div class="page-header">
                            <h1>${voteTopic.title}</h1>
                        </div>
                        <form id="voteForm" action="/vote/save" method="post">
                            <input type="hidden" name="token" value="${sessionScope.token}"/>
                            <input type="hidden" class="form-control" name="id" value="${voteTopic.id}">
                            <c:choose>
                                <c:when test="${null ne voteTopic.voteSubjectList and 0 ne voteTopic.voteSubjectList.size()}">
                                    <c:forEach var="voteSubjectList" items="${voteTopic.voteSubjectList}"
                                               varStatus="status">
                                        <div class="form-group">
                                            <label for="voteSubject${status.index + 1}"><span
                                                    class="text-danger">*</span>${status.index + 1}.${voteSubjectList.title}</label>
                                                <%--单选--%>
                                            <c:if test="${1 == voteSubjectList.voteSubjectTypeId}">
                                                <c:choose>
                                                    <c:when test="${null ne voteSubjectList.voteItemList and 0 ne voteSubjectList.voteItemList.size()}">
                                                        <c:forEach var="voteItemList"
                                                                   items="${voteSubjectList.voteItemList}"
                                                                   varStatus="itemStatus">
                                                            <div class="radio">
                                                                <label>
                                                                    <input type="radio"
                                                                           class="validate[required]"
                                                                           name="voteMap[${voteSubjectList.id}]"
                                                                           id="voteMap[${voteSubjectList.id}]"
                                                                           value="${voteItemList.id}">${voteItemList.content}
                                                                </label>
                                                            </div>
                                                        </c:forEach>
                                                    </c:when>
                                                    <c:otherwise>
                                                        没有选项
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:if>
                                                <%--多选--%>
                                            <c:if test="${2 == voteSubjectList.voteSubjectTypeId}">
                                                <c:choose>
                                                    <c:when test="${null ne voteSubjectList.voteItemList and 0 ne voteSubjectList.voteItemList.size()}">
                                                        <c:forEach var="voteItemList"
                                                                   items="${voteSubjectList.voteItemList}"
                                                                   varStatus="itemStatus">
                                                            <div class="checkbox">
                                                                <label>
                                                                    <input type="checkbox"
                                                                           class="validate[required]"
                                                                           name="voteMap[${voteSubjectList.id}]"
                                                                           id="voteMap[${voteSubjectList.id}]"
                                                                           value="${voteItemList.id}">${voteItemList.content}
                                                                </label>
                                                            </div>
                                                        </c:forEach>
                                                    </c:when>
                                                    <c:otherwise>
                                                        没有选项
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:if>
                                                <%--主观题--%>
                                            <c:if test="${3 == voteSubjectList.voteSubjectTypeId}">
                                                <textarea name="voteMap[${voteSubjectList.id}]"
                                                          id="voteMap[${voteSubjectList.id}]"
                                                          class="form-control validate[required]" rows="3"
                                                          placeholder="请输入内容"></textarea>
                                            </c:if>
                                        </div>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    没有数据
                                </c:otherwise>
                            </c:choose>
                            <div class="row">
                                <div class="col-md-4">
                                </div>
                                <div class="col-md-4">
                                    <div class="col-md-6">
                                        <input type="submit" class="form-control" placeholder="提交">
                                    </div>
                                    <div class="col-md-6">
                                        <input type="reset" class="form-control" placeholder="重置">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                </div>
                            </div>
                        </form>

                    </c:when>
                    <c:otherwise>
                        没有数据
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>
