<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/10
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="registerForm">
    <input type="text" name="username">

    <input type="button" value="注册" id="registerBtn">

</form>

用户名 密码 邮箱
</body>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">

    /*$("#registerForm").serialize()=>username=张三&age=12&address=无锡&telPhone=666*/
    $(function(){
        $("#registerBtn").click(
            function(){
                var params = '{"name": "张三","age": 12,"address":"无锡","telPhone": "110"}';

                /*${pageContext.request.contextPath} 获取项目根路径 => /springmvc */
                $.ajax({
                    url : "${pageContext.request.contextPath}/api/user/register",
                    data : params,
                    contentType : "application/json;charset=UTF-8",//发送数据的格式
                    type : "post",
                    dataType : "json",//回调
                    success : function(data){
                        alert(data.result);
                    }

                });

            }
        )

    })

</script>
</html>
