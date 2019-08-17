<%--
  Created by IntelliJ IDEA.
  User: 60915
  Date: 2019/8/14
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    大家好。我是一个userList的jsp页面。

    <table>
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
        </tr>
        <c:forEach items="${requestScope.users}" var="user">
            <tr>
                <td>${user.no}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.sex}</td>
            </tr>
        </c:forEach>
    </table>



</body>
</html>
