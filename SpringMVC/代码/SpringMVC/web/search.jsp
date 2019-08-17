<%--
  Created by IntelliJ IDEA.
  User: 60915
  Date: 2019/8/16
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="search" method="post">
        查询条件：<br />
        客户姓名：<input type="text" name="user.name" /><br/>
        客户编号：<input type="text" name="user.no" /><br/>
        客户所在的：<input type="text" name="user.address" /><br/>
        订单编号：<input type="text" name="orderNo" /><br/>

        <input type="submit" value="查询" />
    </form>

</body>
</html>
