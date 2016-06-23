<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>404</h2>
<c:choose>
    <c:when test="${null!=errorMsg and ''!=errorMsg}">
        <c:out value="${errorMsg}"/>
    </c:when>
    <c:otherwise>
        <h2>页面不存在</h2>
    </c:otherwise>
</c:choose>
</body>
</html>
