<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/13
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>产品列表</title>
    <style type="text/css">
        table{
            width: 600px;
            margin-left: auto;
            margin-right: auto;
            border: 1px solid black;
            border-collapse: collapse;
        }
        td,th{
            height: 35px;
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>ID</th>
            <th>名称</th>
            <th>价格</th>
            <th>图片</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${items}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td><fmt:formatNumber value="${item.price}" minFractionDigits="2"></fmt:formatNumber></td>
                <td>${item.pic}</td>
                <td><fmt:formatDate value="${item.createtime}" pattern="yyyy年MM月dd号 HH:mm:ss"></fmt:formatDate></td>
                <td>
                    <input type="button" value="删除">
                    <input type="button" value="编辑">

                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
