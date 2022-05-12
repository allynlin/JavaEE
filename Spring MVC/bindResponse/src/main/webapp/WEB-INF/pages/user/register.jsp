<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <style>
        h1 {
            text-align: center;
        }

        input {
            margin: 5px;
        }
    </style>
</head>
<body>
<h1>用户注册</h1>
<hr/>
<form action="${pageContext.request.contextPath}/registerUser" method="post">
    用户名：<input type="text" placeholder="输入用户名"/><br/>
    密&nbsp;&nbsp;&nbsp;码：<input type="password" placeholder="输入密码"/><br/>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
