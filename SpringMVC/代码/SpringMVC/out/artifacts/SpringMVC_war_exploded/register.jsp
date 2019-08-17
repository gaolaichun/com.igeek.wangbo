<%--
  Created by IntelliJ IDEA.
  User: 60915
  Date: 2019/8/16
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>

    <link rel="stylesheet" href="layui/css/layui.css">

    <script type="text/javascript" src="layui/layui.js"></script>
</head>
<body>

    <form action="register" method="post">
        学号:<input type="text" name="no" class="layui-input"><br>
        姓名:<input type="text" name="name" class="layui-input"><br>
        年龄:<input type="text" name="age" class="layui-input"><br>
        性别:<input type="text" name="sex" class="layui-input"><br>
        出生日期:<input type="text" name="birthday" class="layui-input" id="test1"><br>
        <input type="submit" value="登录">
    </form>

    <script type="text/javascript">
        layui.use('laydate', function(){
            var laydate = layui.laydate;

            //执行一个laydate实例
            laydate.render({
                elem: '#test1' //指定元素
                ,type: 'datetime'
                ,format: 'yyyy-MM-dd HH:mm:ss'
            });
        });
    </script>


</body>
</html>
