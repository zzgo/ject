<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<table>
    <c:forEach items="${page.results}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.password}</td>
    </tr>
    </c:forEach>
</table>
<c:forEach begin="${page.beginPageIndex}" end="${page.endPageIndex}" varStatus="index">
    ${index.index},
</c:forEach>
<p>${page.pageNum}/${page.countPage}/</p>
<p>共计=${page.recordPage}</p>

</body>
</html>
