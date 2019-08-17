<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/13
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>商品编辑</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/item/update" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${item.id}">
    商品名称:<input type="text" name="name" value="${item.name}"><br>
    商品价格:<input type="text" name="price" value="${item.price}"><br>
    商品详情:<textarea name="detail" >${item.detail}</textarea><br>
    商品图片:
    <c:if test="${item.pic!=null&&item.pic!=''}">
        <img src="${item.pic}" style="width: 100px;height:80px;">
    </c:if>

    <input type="file" name="file"> <br>

    商品日期:<input type="text" name="createtime" value="<fmt:formatDate value='${item.createtime}' pattern='yyyy/MM/dd HH:mm:ss'></fmt:formatDate>"><br>
    <input type="submit" value="更新">



</form>

</body>
</html>
