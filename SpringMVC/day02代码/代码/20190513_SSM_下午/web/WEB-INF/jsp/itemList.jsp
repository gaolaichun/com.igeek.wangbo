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
    <title>商品列表</title>

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

        td img{
            width: 100px;
            height: 60px;
        }
    </style>
</head>
<body>

<div style="text-align: center">
    名称:<input type="text" name="name"> <input type="button" value="查询"><input type="button" value="新增">
</div>
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
            <td>
                <c:if test="${item.pic!=null}">
                    <img src="${item.pic}">
                </c:if>
            </td>
            <td><fmt:formatDate value="${item.createtime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
            <td>
                <input type="button" value="删除" onclick="deleteItem(${item.id})">
                <input type="button" value="编辑" onclick="editItem(${item.id})">

            </td>
        </tr>
    </c:forEach>

</table>

</body>

<script type="text/javascript">
    /*编辑商品*/
    function editItem(itemId) {
        location.href = "${pageContext.request.contextPath}/item/edit/"+itemId;
    }

    /*删除商品*/
    function  deleteItem(itemId) {
        if(confirm("是否确认删除?")){
            location.href = "${pageContext.request.contextPath}/item/delete/"+itemId;
        }

    }
</script>
</html>
