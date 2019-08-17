<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/10
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--如果表单需要支持文件上传,需要添加enctype="multipart/form-data"--%>
<form action="upload" method="post" enctype="multipart/form-data">
    文件:<input type="file" name="file">
    <input type="submit" value="提交">
</form>
</body>
</html>
