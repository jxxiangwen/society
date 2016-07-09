<%@page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
    <div class="container-fluid" id="database">
        <div class="row">
            <jsp:include page="../../left.jsp"/>
            <div class="col-md-9">
                <c:choose>
                    <c:when test="${null ne voteTopic}">
                        <div class="page-header">
                            <h1>${voteTopic.title}</h1>
                        </div>
                        <c:choose>
                            <c:when test="${null ne voteTopic.voteSubjectList and 0 ne voteTopic.voteSubjectList.size()}">
                                <c:forEach var="voteSubjectList" items="${voteTopic.voteSubjectList}"
                                           varStatus="status">
                                    <div class="page-header">
                                        <h2>${status.index + 1}.${voteSubjectList.title}</h2>
                                    </div>
                                    <div id="subject${voteSubjectList.id}" style="width: 100%;height: 150px">

                                    </div>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                没有数据
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        没有数据
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
    <script src="/js/echarts.common.min.js"></script>
    <script type="text/javascript">
        <c:choose>
        <c:when test="${null ne voteTopic}">
        <c:choose>
        <c:when test="${null ne voteTopic.voteSubjectList and 0 ne voteTopic.voteSubjectList.size()}">
        <c:forEach var="voteSubjectList" items="${voteTopic.voteSubjectList}"
                   varStatus="status">
        <c:choose>
        <c:when test="${null ne voteSubjectList.voteItemList and 0 ne voteSubjectList.voteItemList.size()}">
        <c:choose>
        <c:when test="${3 == voteSubjectList.voteSubjectTypeId}">

        </c:when>
        <c:otherwise>
        var myChart${voteSubjectList.id} = echarts.init(document.getElementById('subject${voteSubjectList.id}'));
        option${voteSubjectList.id} = {
            title: {
                text: '${voteSubjectList.title}',
                subtext: '纯属虚构',
                x: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left'
            },
            series: [
                {
                    name: '${voteSubjectList.title}',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '60%'],
                    data: [
                        <c:forEach var="voteItemList"
                                       items="${voteSubjectList.voteItemList}"
                                       varStatus="itemStatus">
                        <c:choose>
                        <c:when test="${itemStatus.index + 1 eq voteSubjectList.voteItemList.size()}">
                        {value: ${voteItemList.voteNum}, name: '${voteItemList.content}'}
                        </c:when>
                        <c:otherwise>
                        {value: ${voteItemList.voteNum}, name: '${voteItemList.content}'},
                        </c:otherwise>
                        </c:choose>
                        </c:forEach>
                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart${voteSubjectList.id}.setOption(option${voteSubjectList.id});
        </c:otherwise>
        </c:choose>
        </c:when>
        <c:otherwise>
        </c:otherwise>
        </c:choose>
        </c:forEach>
        </c:when>
        <c:otherwise>
        </c:otherwise>
        </c:choose>
        </c:when>
        <c:otherwise>
        </c:otherwise>
        </c:choose>
    </script>
</div>
