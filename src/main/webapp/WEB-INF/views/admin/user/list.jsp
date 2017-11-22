<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<table>
    <c:forEach items="${pd.results}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.password}</td>
    </tr>
    </c:forEach>
</table>
<c:forEach begin="${pd.beginPageIndex}" end="${pd.endPageIndex}" varStatus="index">
    ${index.index},
</c:forEach>
<p>${pd.pageNum}/${pd.countPage}/</p>
<p>共计=${pd.recordPage}</p>

</body>
</html>
