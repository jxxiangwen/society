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
                <form id="topicFrom" action="/admin/topic/add" method="post">
                    <div class="form-group">
                        <label>问卷名 </label>
                        <input type="text" class="form-control validate[required]" name="topicTitle"
                               placeholder="问卷名" value="">
                    </div>
                    <div class="form-group">
                        <label>所属类别 </label>
                        <c:choose>
                            <c:when test="${null ne voteTypeList and 0 ne voteTypeList.size()}">
                                <select id="typeId" class="form-control validate[required]" name="parentName">
                                    <c:forEach var="list" items="${voteTypeList}">
                                        <option value=${list.id}>${list.typeName}</option>
                                    </c:forEach>
                                </select>
                            </c:when>
                            <c:otherwise>
                                暂时没有类别
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div id="subjectArea"></div>
                    <div id="addSubject" class="form-group" style="text-align:center">
                        <a href="javascript:void(0);" class="btn btn-default" onclick="addSubject();">
                            增加问题
                        </a>
                    </div>
                    <div class="form-group" style="text-align:center">
                        <a href="javascript:void(0);" class="btn btn-default" onclick="formSubmit();">
                            确认
                        </a>
                    </div>
                </form>
                <script>
                </script>
            </div>
        </div>
    </div>
    <script id="itemTemplate" type="text/html">
        <div class="form-group" id="item{{ d.subjectIndex }}-{{ d.itemIndex }}">
            <label for="topic[{{ d.subjectIndex }}].item[{{ d.itemIndex }}].itemTitle">选项名 </label>
            <div class="col-md-6">
                <input type="text" class="form-control validate[required]" id="topic[{{ d.subjectIndex }}].item[{{ d.itemIndex }}].itemTitle"
                       name="topic[{{ d.subjectIndex }}].item[{{ d.itemIndex }}].itemTitle"
                       placeholder="选项名" value="">
            </div>
            <a href="javascript:void(0);" class="btn btn-default" onclick="deleteItem('{{ d.subjectIndex }}','{{ d.itemIndex }}');">
                删除选项
            </a>
        </div>
    </script>
    <script id="defaultItemTemplate" type="text/html">
        <div class="form-group">
            <label for="topic[{{ d.subjectIndex }}].item[0].itemTitle">选项名 </label>
            <input type="text" class="form-control validate[required]" id="topic[{{ d.subjectIndex }}].item[0].itemTitle"
                   name="topic[{{ d.subjectIndex }}].item[0].itemTitle"
                   placeholder="选项名" value="">
        </div>
        <div class="form-group">
            <label for="topic[{{ d.subjectIndex }}].item[1].itemTitle">选项名 </label>
            <input type="text" class="form-control validate[required]"  id="topic[{{ d.subjectIndex }}].item[1].itemTitle"
                   name="topic[{{ d.subjectIndex }}].item[1].itemTitle"
                   placeholder="选项名" value="">
        </div>
        <a href="javascript:void(0);" class="btn btn-default" onclick="addItem('{{ d.subjectIndex }}');">
            增加选项
        </a>
    </script>
    <script id="subjectTemplate" type="text/html">
        <div id="subject{{ d.subjectIndex }}">
            <div class="form-group">
                <label>问题名 </label>
                <input type="text" class="form-control validate[required]" name="topic[{{ d.subjectIndex }}].subjectTitle"
                       placeholder="问题名" value="">
            </div>
            <div class="form-group">
                <label>问题类型 </label>
                <select id="subjectType{{ d.subjectIndex }}" class="form-control validate[required]"
                        name="topic[{{ d.subjectIndex }}].subjectType">
                    <option value="单选题">单选题</option>
                    <option value="多选题">多选题</option>
                    <option value="主观题">主观题</option>
                </select>
            </div>
            <div id="item{{ d.subjectIndex }}">
                <div class="form-group">
                    <label for="topic[{{ d.subjectIndex }}].item[0].itemTitle">选项名 </label>
                    <input type="text" class="form-control validate[required]" id="topic[{{ d.subjectIndex }}].item[0].itemTitle"
                           name="topic[{{ d.subjectIndex }}].item[0].itemTitle"
                           placeholder="选项名" value="">
                </div>
                <div class="form-group">
                    <label for="topic[{{ d.subjectIndex }}].item[1].itemTitle">选项名 </label>
                    <input type="text" class="form-control validate[required]"  id="topic[{{ d.subjectIndex }}].item[1].itemTitle"
                           name="topic[{{ d.subjectIndex }}].item[1].itemTitle"
                           placeholder="选项名" value="">
                </div>
                <a href="javascript:void(0);" class="btn btn-default" onclick="addItem('{{ d.subjectIndex }}',this);">
                    增加选项
                </a>
            </div>
            <div class="form-group" style="text-align:center">
                <a href="javascript:void(0);" class="btn btn-default" onclick="deleteSubject('{{ d.subjectIndex }}');">
                    删除问题
                </a>
            </div>
        </div>
    </script>
    <script>
        //问题数目，可增加可减少
        window.subjectNum = 0;
        //问题索引，只增加不减少
        window.subjectIndex = 0;
        //问题选项长度，只会重置或者增加
        window.itemLengthArray = [];

        $(document).ready(function () {
            $("#topicFrom").validationEngine('attach');
        });
        function formSubmit() {
            if($('#topicFrom').validationEngine('validate')){
                if (1 > window.subjectNum) {
                    layer.alert('问题数不能为0');
                } else {
                    $('#topicFrom').submit();
                }
            }
        }
        function addSubject() {
            var template = $('#subjectTemplate').html();
            var data = {};
            data['subjectIndex']=window.subjectIndex;
            laytpl(template).render(data, function (html) {
                if (0 == window.subjectIndex) {
                    $('#subjectArea').empty().append(html);
                } else {
                    $('#subjectArea').append(html);
                }
            });
            window.itemLengthArray[window.subjectIndex] = 2;
            //绑定问题类型选择改变事件
            $('#subjectType' + window.subjectIndex).change(function () {
                var subjectId = $(this).attr('id');
                var subjectIndex = parseInt(subjectId.replace('subjectType',''));
                var itemId = 'item' + subjectIndex;
                var value = $(this).children('option:selected').val();
                $('#' + itemId).empty();
                if('主观题' == value){
                    window.itemLengthArray[subjectIndex] = 0;
                }else{
                    addDefaultItemByItemIndex(subjectIndex);
                    window.itemLengthArray[subjectIndex] = 2;
                }
            });
            window.subjectNum += 1;
            window.subjectIndex += 1;
        }
        function deleteSubject(id) {
            $('#subject' + id).remove();
            window.subjectNum -= 1;
        }
        function addItemByItemIndex(subjectIndex,itemIndex) {

        }
        function addDefaultItemByItemIndex(subjectIndex) {
            var template = $('#defaultItemTemplate').html();
            var data = {};
            data['subjectIndex'] = subjectIndex;
            laytpl(template).render(data, function (html) {
                $('#item' + subjectIndex).append(html);
            });
        }
        function addItem(subjectIndex,id) {
            var template = $('#itemTemplate').html();
            var data = {};
            data['subjectIndex'] = subjectIndex;
            data['itemIndex'] = window.itemLengthArray[parseInt(subjectIndex)];
            laytpl(template).render(data, function (html) {
                $(id).before(html);
            });
            window.itemLengthArray[parseInt(subjectIndex)] +=1;
        }
        function deleteItem(subjectIndex,itemIndex) {
            $('#item' + subjectIndex + '-' + itemIndex).remove();
        }
    </script>
</div>
